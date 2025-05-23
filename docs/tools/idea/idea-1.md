# IDEA

## IDEA的安装

idea 的安装可借助 jetbrain tools 来管理，可以控制相关的软件版本及其他同系列的软件如 RustRover

[安装官网](https://www.jetbrains.com/toolbox-app/)

1. 在jetbrain tools 中设置 IDEA 的版本为2024.1（主要是考虑使用 IDE的稳定性，后期可以每年更换为对应年份的第一个月份版本），并选中`keep using`
2. 破解 IDEA，下载破解包

## 在IDEA中快速找到指定类的Maven依赖

java项目，尤其是微服务项目，项目结构太复杂，有时候使用的类并不知道具体是哪个模块引入的哪个maven依赖。此文提供了在IDEA中查找已知类，查找maven依赖的方法。

### 背景

```java
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
```

笔者想要查找上述国密相关的包在哪个具体模块中引入。

### 过程

1. 定位到`external libraries`，找到对应依赖的具体maven artifactId 包名
2. 定位到`maven workspace`中使用该类的模块，选中该模块，点击maven中的`show diagram`功能
3. 理想情况下会出现一个比较复杂的maven依赖关系tab，在其中使用`ctrl+F`搜索步骤1中的包名
4. 此时屏幕会定位该包到中央，并且其边缘高亮，可在图中查看其maven依赖关系

## IDEA的配置

