# Java Version Feature

Java 自 1995 年发布以来，经历了多次版本更新，每个版本都引入了新特性和改进。以下是 Java 的主要版本及其关键特性概览：

## detail

---

### **Java 1.0 (1996)**

- 初代正式版本，包含核心 API 如 `java.lang`、`java.util`、`java.io` 等。
- 特性：AWT（图形界面）、基本线程支持、Applet。

### **Java 1.1 (1997)**

- 引入内部类（Inner Classes）、JDBC（数据库连接）、RMI（远程方法调用）。
- 反射 API（Reflection）、JavaBeans 组件模型。

### **Java 1.2 (1998) - "Java 2"**

- 集合框架（`Collection Framework`，如 `List`、`Map`）。
- JIT 编译器、Swing（改进的 GUI）、`strictfp` 关键字。
- 分为三个版本：J2SE（标准版）、J2EE（企业版）、J2ME（微型版）。

### **Java 1.4 (2002)**

- 正则表达式、NIO（非阻塞 I/O）、日志 API（`java.util.logging`）。
- 断言（`assert` 关键字）、IPv6 支持。

---

### **Java 5 (2004) - 里程碑版本**

- **泛型（Generics）**：类型安全的集合（如 `List<String>`）。
- **注解（Annotations）**：如 `@Override`、`@Deprecated`。
- **自动装箱/拆箱**：`int` ↔ `Integer` 自动转换。
- **枚举（Enums）**：`enum` 关键字。
- **可变参数**：`void method(String... args)`。
- **`for-each` 循环**：简化集合遍历。

---

### **Java 6 (2006)**

- 脚本语言支持（`javax.script`）、JAX-WS（Web 服务）。
- 改进 JVM：性能优化、诊断工具（如 `jstack`、`jmap`）。

---

### **Java 7 (2011)**

- **`try-with-resources`**：自动资源管理（如文件流）。
- **NIO.2**：`Path`、`Files` 等文件操作 API。
- **钻石操作符**：简化泛型声明（`List<String> list = new ArrayList<>()`）。
- **字符串 `switch`**、二进制字面量（`0b1010`）。

---

### **Java 8 (2014) - 重大更新**

- **Lambda 表达式**：`(a, b) -> a + b`。
- **Stream API**：函数式集合操作（如 `filter`、`map`、`reduce`）。
- **默认方法（Default Methods）**：接口支持实现方法。
- **新的日期时间 API**：`java.time`（`LocalDate`、`ZonedDateTime`）。
- **Optional**：避免 `NullPointerException`。

---

### **Java 9 (2017)**

- **模块化系统（JPMS）**：通过 `module-info.java` 定义模块。
- **JShell**：交互式 REPL 工具。
- 工厂方法创建集合：`List.of("a", "b")`。

---

### **Java 10 (2018)**

- **局部变量类型推断**：`var list = new ArrayList<String>()`。
- G1 垃圾回收器成为默认 GC。

---

### **Java 11 (2018) - LTS 版本**

- **HTTP Client API**（标准化）。
- **`var` 支持 Lambda 参数**。
- 移除 Java EE 和 CORBA 模块。
- 单文件源代码直接运行（`java Hello.java`）。

---

### **Java 12~17 (非 LTS / LTS)**

- **Java 12-16**：  
  - Switch 表达式（`->` 语法）、文本块（`"""` 多行字符串）。  
  - `record` 类（简化不可变对象）、`sealed` 类（限制继承）。  
  - 模式匹配 `instanceof`（直接提取变量）。  
- **Java 17 (2021) - LTS**：  
  - 正式启用 `sealed` 类、`switch` 模式匹配。  
  - 恢复严格的浮点语义（`strictfp` 默认启用）。

---

### **Java 18~21 (最新特性)**

- **Java 18 (2022)**：  
  - UTF-8 默认字符集、简单的 Web 服务器（`jwebserver`）。  
- **Java 19 (2022)**：  
  - 虚拟线程（预览，Project Loom）、结构化并发。  
- **Java 20 (2023)**：  
  - 作用域值（Scoped Values）、记录模式（Record Patterns）。  
- **Java 21 (2023) - LTS**：  
  - **虚拟线程正式发布**（轻量级并发）。  
  - 模式匹配 `switch` 最终版、分代 ZGC（垃圾回收）。  

---

### **版本分类**

- **LTS（长期支持）**：Java 8、11、17、21（每 2~3 年发布一个 LTS，企业常用）。  
- **非 LTS**：每 6 个月发布一次，支持期限短（如 Java 12~16）。  

---

### **如何查看当前版本？**

```bash
java -version
```

企业开发中，LTS 版本（如 8、11、17、21）是主流选择，而新版本适合探索前沿特性。
