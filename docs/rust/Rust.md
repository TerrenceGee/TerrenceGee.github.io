# Rust

## Rust 安装 及相关工具

| tools | todo |
| --- | --- |
| rustup | 安装工具和版本管理工具 |
| cargo | 构建工具、包管理器 |
| cargo.toml | toml 是一种类似于 xml，properties，yml 的配置文件规范，在 Rust 中包含了项目的元数据和依赖库 |
| crates.io | Rust 包的仓库，Rust 中习惯把包称做 "crates" |

### toml文件
>
> toml：Tom's Obvious, Minimal Language.

```toml
# 这是一个 TOML 文档

title = "TOML 示例"

[owner]
name = "Tom Preston-Werner"
dob = 1979-05-27T07:32:00-08:00

[database]
enabled = true
ports = [ 8000, 8001, 8002 ]
data = [ ["delta", "phi"], [3.14] ]
temp_targets = { cpu = 79.5, case = 72.0 }

[servers]

[servers.alpha]
ip = "10.0.0.1"
role = "前端"

[servers.beta]
ip = "10.0.0.2"
role = "后端"
```

以上是一个典型的 toml 配置文件例子，由上可以看出它的特点

1. 有表头，使用[]符号来定义一个表，其后的键值对都属于这个表
2. 键值对行，一行定义一个键值对

Rust中的 cargo 使用 toml 文件来作为配置文件，以下是一个 cargo 中的 toml 文件 的例子：

```toml
[package]
name = "hello_cargo"
version = "0.1.0"
edition = "2021"

# See more keys and their definitions at https://doc.rust-lang.org/cargo/reference/manifest.html

[dependencies]
```

关于rust 对 toml 具体的定义，可参考上述的地址

### Rust 的安装

> macos，Apple M2，ARM64

1.安装 Rustup：`curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh` \
国内安装比较慢，可以先添加一个国内的镜像地址的环境变量，修改`~/.zshrc`文件，添加

```zsh
export RUSTUP_DIST_SERVER=https://mirrors.ustc.edu.cn/rust-static
export RUSTUP_UPDATE_ROOT=https://mirrors.ustc.edu.cn/rust-static/rustup
```

安装完成后，Rust 相关安装目录如下表

| path | desc |
| --- |--- |
| ~/.rustup | RUSTUP_HOME|
| ~/.cargo | CARGO_HOME |
| ~/.cargo/bin | commands tool，cargo、rustc、rustup and others |
| ~/.profile <br></br> ~/.bash_profile <br></br> ~/.zshenv   | rust add PATH environment variable automatically |

安装完毕后，使用`rustc --version`命令查看安装是否成功，查看相关环境变量的设置

> .zshrc 与 .zshenv 的区别，.zshenv 的加载顺序为最先，且在交互式（终端）和非交互式（脚本）下都可以加载，.zshrc 只有在终端情况下加载

2.升级和卸载

升级，使用 rustup 命令：`rustup update`
卸载，使用命令：`rustup self uninstall`

## Rust 项目规范

## Rust 进阶

### ownership

所有权是 Rust 中核心概念之一，它确保了 Rust 在无需垃圾回收器的帮助下保证内存的使用和安全。
> Ownership is a set of rules that govern how a Rust program manages memory.
> 主流语言处理内存的方式：
>
> 1. 编程者手动申请和释放内存
> 2. 依赖程序运行时的垃圾回收器
> 3. 编译期的拥有权规则检查

所有权规则：

- Each value in Rust has an owner.
- There can only be one owner at a time.
- One value can exist after it is created, and before it goes out of its scope.
- When the owner goes out of scope, the value will be dropped.

堆和栈分配：

字符串字面量和字符串实例内存分配的不同：

- 字符串字面量是确实的、不可变的，可以存储在程序的数据段中，硬编码，它用起来会很快
- 字符串实例，即 String type，由于其大小不确实，所以要在堆上分配，使用 allocator

Rust 程序会在作用域结束后，自动调用`drop`方法来释放失去所有权的变量占用的内存

#### Variables and Data Interacting with Move

值类型和指针类型在copy 时的行为对比：

- 值类型在重赋值变量时，会将值复制一份进入栈中
- 指针类型以 String 类型为例，栈上存储的是ptr、len和 capacity 信息，堆上存储的是真实的数据，在重赋值时，只会复制栈上的信息，入栈，并没有复制堆上的数据，这个过程也叫浅拷贝。但是在 Rust 中，它会使原来的变量失效，堆上内存的使用权全部转交给新的变量。所以这个过程叫做`move`。

move 行为解决了对于指针类型，重赋值时，作用域结束，rust 需要调用两次 drop 释放同一块内存，从而引起内存安全的问题。

#### Scope and Assignment

这个行为是指当对象类型的指针，从原来的内存地址，指向一个新的内存地址时，Rust 会立即调用 drop 方法来释放旧的内存地址内存

#### Variables and Data Interacting with Clone

如果想实现深拷贝，可以调用实例类型的`clone`函数，这样创建的变量和原来的变量就是分别指向两个内存地址，原来的变量就不会失效

#### Stack-Only Data: Copy

对于值类型，由于内存大小是固定的，在栈上分配，所以复制时只需进行栈上的复制就行。但是这样会和 Rust 的变量 assignment 导致前变量释放的规则不符合，但是这是 Rust 允许的。\
Rust 的 Copy trait 使类型，变量不会 move，而是 shallow copy，并且赋值给另一个变量后仍然有效。\
实现了 Copy trait 的类型有，all integer types、boolean types、float types、character type、tuples。

#### Ownership and Functions

将变量作为入参传递给函数，和变量赋值的情况是一样的；会根据变量类型有没有 Copy trait 来进行 move 或者 copy

#### Return Values and Scope

将变量作为返回值传递出去，也会转移所有权；但是 Rust 觉得一个函数，传入的时候要转移所有权，传出的时候也要转移所有权，这样太冗余复杂了；于是便有了 Reference 引用

### Rust编译

## 参考资料

- [Rust 官方网站](https://www.rust-lang.org/)
- [The book](https://doc.rust-lang.org/book/)
- [rustlings：一个练习的仓库](https://github.com/rust-lang/rustlings/)
- [Rust By Example](https://doc.rust-lang.org/rust-by-example/)
