以下是在 Java Web 应用中实施单元测试的最佳实践及可参考的代码示例，涵盖 Controller、Service、Repository 等不同层级的测试策略：

---

### 一、Controller 层测试 (Spring MVC)
#### 使用 `@WebMvcTest` 进行切片测试
```java
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUser_shouldReturn200() throws Exception {
        // Mock服务层返回
        when(userService.getUser(1L))
            .thenReturn(new User(1L, "test@example.com"));

        // 发起请求并验证
        mockMvc.perform(get("/api/users/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1L))
               .andExpect(jsonPath("$.email").value("test@example.com"));

        // 验证服务调用
        verify(userService).getUser(1L);
    }

    @Test
    void createUser_shouldValidateInput() throws Exception {
        // 测试参数校验
        mockMvc.perform(post("/api/users")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"email\":\"invalid\"}")) // 无效邮箱
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors[0].field").value("email"));
    }
}
```

---

### 二、Service 层测试
#### 纯单元测试 (Mock 依赖)
```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registerUser_shouldSendWelcomeEmail() {
        // 准备测试数据
        User newUser = new User(null, "new@example.com");
        User savedUser = new User(1L, "new@example.com");

        // Mock依赖行为
        when(userRepository.save(newUser)).thenReturn(savedUser);

        // 执行测试
        User result = userService.registerUser(newUser);

        // 验证结果
        assertThat(result.getId()).isNotNull();
        verify(emailService).sendWelcomeEmail("new@example.com");
    }

    @Test
    void deleteUser_shouldSoftDelete() {
        // 测试业务逻辑：软删除
        userService.deleteUser(1L);
        
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());
        
        assertThat(captor.getValue().isDeleted()).isTrue();
    }
}
```

---

### 三、Repository 层测试
#### 使用 `@DataJpaTest` + H2 内存数据库
```java
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail_shouldIgnoreCase() {
        // 准备数据
        entityManager.persist(new User("Test@Example.com"));

        // 执行查询
        Optional<User> user = userRepository.findByEmailIgnoreCase("test@example.com");

        // 验证结果
        assertThat(user).isPresent();
        assertThat(user.get().getEmail()).isEqualTo("Test@Example.com");
    }

    @Test
    void countByStatus_shouldFilterCorrectly() {
        entityManager.persist(new User().setStatus(Status.ACTIVE));
        entityManager.persist(new User().setStatus(Status.INACTIVE));

        long count = userRepository.countByStatus(Status.ACTIVE);
        assertThat(count).isEqualTo(1);
    }
}
```

---

### 四、REST API 集成测试
#### 使用 `@SpringBootTest` + `TestRestTemplate`
```java
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserApiIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void getUser_shouldReturn404WhenNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/users/999", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).contains("User not found");
    }

    @Test
    void createUser_shouldReturn201() {
        UserDto request = new UserDto("test@example.com");
        
        ResponseEntity<UserDto> response = restTemplate.postForEntity(
            "http://localhost:" + port + "/api/users",
            request,
            UserDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isNotNull();
    }
}
```

---

### 五、测试工具类的最佳实践
```java
class PasswordUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"weak", "123456", "password"})
    void isStrongPassword_shouldRejectWeak(String weakPassword) {
        assertThat(PasswordUtil.isStrong(weakPassword)).isFalse();
    }

    @Test
    void encryptPassword_shouldGenerateDifferentSalts() {
        String pwd1 = PasswordUtil.encrypt("123456");
        String pwd2 = PasswordUtil.encrypt("123456");
        
        assertThat(pwd1).isNotEqualTo(pwd2); // 确保每次加密结果不同
        assertThat(PasswordUtil.matches("123456", pwd1)).isTrue();
    }
}
```

---

### 六、关键最佳实践总结

1. **分层测试策略**：
   - Controller：验证HTTP交互和参数校验
   - Service：核心业务逻辑
   - Repository：数据库交互
   - API测试：端到端流程

2. **测试数据管理**：
   ```java
   // 使用Builder模式创建测试对象
   User testUser = User.builder()
       .email("test@example.com")
       .status(Status.ACTIVE)
       .build();
   ```

3. **验证技术选型**：
   - 优先使用AssertJ（`assertThat`）
   - 参数化测试（`@ParameterizedTest`）
   - 自定义Matcher处理复杂断言

4. **测试配置隔离**：
   ```properties
   # src/test/resources/application-test.properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.jpa.hibernate.ddl-auto=create-drop
   ```

---

### 七、参考开源项目
1. [Spring PetClinic](https://github.com/spring-projects/spring-petclinic) - Spring官方示例
2. [JHipster Sample Apps](https://github.com/jhipster/jhipster-sample-app) - 完整的企业级测试实践
3. [Testing Spring Boot Applications](https://spring.io/guides/gs/testing-web/) - Spring官方指南

这些示例展示了如何在真实Web应用中实施有效的单元测试，覆盖从HTTP接口到数据库交互的全链路验证。