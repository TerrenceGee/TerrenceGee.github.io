# go

### 一、基础打印函数
在Go语言中，打印操作主要通过`fmt`标准包实现，分为**基础打印**、**格式化打印**和**输出重定向**三大类。以下是详细分类解析（附使用场景和性能考量）：

#### 1. 终端标准输出
| 函数签名               | 行为描述                | 示例                       |
| ---------------------- | ----------------------- | -------------------------- |
| `fmt.Print(args...)`   | 无分隔符输出，连续打印  | `Print("a", 1)` → `a1`     |
| `fmt.Println(args...)` | 自动空格分隔 + 末尾换行 | `Println("a",1)` → `a 1\n` |
| `fmt.Println()`        | 单独调用时输出纯换行符  | 输出`\n`                   |

```go
fmt.Print("Hello", "World")   // 输出：HelloWorld
fmt.Println("Hello", "World") // 输出：Hello World\n
```

#### 2. 字符串格式化
| 函数签名                | 返回值               | 使用场景                           |
| ----------------------- | -------------------- | ---------------------------------- |
| `fmt.Sprint(args...)`   | 拼接后的字符串       | 字符串构造：`s := Sprint(1,"+",1)` |
| `fmt.Sprintln(args...)` | 带空格和换行的字符串 | 生成日志消息正文                   |

```go
msg := fmt.Sprintln("Error:", err) // "Error: file not found\n"
```

---

### 二、格式化打印（核心功能）
#### 1. 标准格式化输出
| 函数签名                          | 特性                                 |
| --------------------------------- | ------------------------------------ |
| `fmt.Printf(format, args...)`     | 按占位符输出到标准输出               |
| `fmt.Sprintf(format, args...)`    | 返回格式化字符串                     |
| `fmt.Fprintf(w, format, args...)` | 定向输出到`io.Writer`（文件/网络等） |

#### 2. 常用占位符速查
| 占位符 | 类型           | 示例                      | 输出           |
| ------ | -------------- | ------------------------- | -------------- |
| `%v`   | 通用值         | `Printf("%v", data)`      | 默认格式       |
| `%#v`  | Go语法表示     | `Printf("%#v", "a")`      | `"a"`          |
| `%T`   | 类型           | `Printf("%T", 3.14)`      | `float64`      |
| `%d`   | 十进制整数     | `Printf("%d", 0x0F)`      | `15`           |
| `%b`   | 二进制         | `Printf("%b", 5)`         | `101`          |
| `%f`   | 浮点数         | `Printf("%.2f", 3.14159)` | `3.14`         |
| `%s`   | 字符串         | `Printf("%s", "go")`      | `go`           |
| `%p`   | 指针地址       | `Printf("%p", &x)`        | `0x40e020`     |
| `%+v`  | 结构体带字段名 | `Printf("%+v", user)`     | `{Name:"Bob"}` |
| `%q`   | 带引号字符串   | `Printf("%q", "a")`       | `"a"`          |

```go
fmt.Printf("User: %s, Age: %02d, Score: %05.2f\n", "Tom", 5, 92.5)
// 输出：User: Tom, Age: 05, Score: 92.50
```

---

### 三、高级打印技巧
#### 1. 输出重定向
```go
// 重定向到文件
file, _ := os.Create("output.log")
fmt.Fprintf(file, "Server started at %v", time.Now())

// 重定向到字节缓冲
var buf bytes.Buffer
fmt.Fprint(&buf, "Error:", err)
log.Write(buf.Bytes())
```

#### 2. 自定义类型打印
实现`Stringer`接口定制输出：
```go
type Point struct{ X, Y int }

func (p Point) String() string {
    return fmt.Sprintf("(%d,%d)", p.X, p.Y)
}

func main() {
    p := Point{3, 4}
    fmt.Println(p) // 输出: (3,4)
}
```

#### 3. 打印调试技巧
```go
// 打印结构体时展开字段
fmt.Printf("%#v\n", user) 
// 输出：main.User{Name:"Alice", Age:30}

// 多行格式化（自动添加逗号）
data := []int{1,2,3}
fmt.Printf("Data: %#v\n", data)
// 输出：Data: []int{1, 2, 3}
```

---

### 四、性能优化指南
| 场景              | 推荐方案                 | 原因                           |
| ----------------- | ------------------------ | ------------------------------ |
| **高频日志输出**  | 使用`fmt.Fprint(writer)` | 避免控制台I/O阻塞              |
| **字符串拼接**    | `fmt.Sprintf`替代`+`     | 减少内存分配（尤其>5个变量时） |
| **DEBUG模式关闭** | 用`log.Logger`控制开关   | 移除生产环境不必要的打印       |

```go
// 高效拼接示例
func buildSQL(id int) string {
    // 比 "+" 拼接效率高30%
    return fmt.Sprintf("SELECT * FROM users WHERE id=%d", id)
}
```

---

### 五、错误处理模式
```go
// 错误打印标准化
if err := process(); err != nil {
    // 带错误类型和堆栈
    fmt.Printf("%[1]T: %[1]v\n", err) 
    // 输出：*os.PathError: open /tmp: no such file
}

// 带上下文格式化
fmt.Errorf("processing failed: %w", err) // 创建嵌套错误
```

> **最佳实践**：  
> 生产环境避免直接`Print`，使用`log`包附加时间戳和日志级别  
> 格式化字符串优先占位符（`%s`/`%d`）而非类型转换