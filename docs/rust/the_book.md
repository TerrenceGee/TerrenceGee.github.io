# Rust Programing Language

## 7.项目管理及模块化编程

由大至小分别是

- workspace：由多个包组成
- package：cargo的功能，包括 build, test, publish
- crate：一个模块的树型结构
- module：允许控制作用域
- path：资源的定位方式

### 包和crate

crate有两种形式：binary crate and lib crate。binary crate拥有main函数，并且编译成一个可执行程序，而 lib crate 不是，它相当于一个 library，被其他crate所使用。
package是这样：它是cargo级别的概念，包含一个toml，可以拥有多个bin crate 和 一个 lib crate；包中的src/{main.rs, lib.rs}，分别是 bin crate 和 lib crate的 root 文件。如果两个文件都存在，则代表这个有一个bin crate和一个lib crate

Rust中控制资源权限的关键字只有一个 pub，它的规则是这样的：

- 资源上没有pub：私有，即不暴露给作用域外；有pub，可以暴露在作用域外
- mod：声明一个模块，但默认情况下该模块及其内容对外不可见（除非明确使用 pub 标记）。
pub mod：声明一个模块并将其自身设为公共，允许外部模块知道它的存在并引用它。然而，这只是让模块本身变得可见，模块内部的具体项仍需通过 pub 公开。


## 14. 更多模块化功能

### 工作空间