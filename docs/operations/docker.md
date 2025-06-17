# docker

## 安装

一键安装docker的脚本：

地址需要时从百度网盘中拉取
```text
https://pan.baidu.com/s/1RHh37ZMajnuDVsjrUYNugQ?pwd=uxrx
```

> 上面的脚本中的docker安装没有自动创建docker group 和赋予当前用户权限，后续需要补充

> 下面是一个获取镜像加速的地址：`https://docker.xuanyuan.me/`

## docker拉取镜像

有两种方式，分别是配置代理服务和科学上网

### 配置代理服务器

在2024年6月之前，这种方式都是比较好用的，国内有一些比较可靠的镜像源使用。但是现在已经行不通了，现在想通过这种方式一般是修改一些其他源（外国人搭建的镜像），或者通过cloudflare提供的服务自行搭建镜像服务器。

这种方式由于需要自行维护，费时费力。

### 科学上网

如果是频繁拉取不同镜像的用途，使用这种方式就需要考虑自己的流量是否能支撑。
下面教程适用于使用`systemd`管理`docker`服务的机器。

#### 1.创建docker相关的systemd目录以覆盖docker的默认配置

`mkdir -p /etc/systemd/system/docker.service.d`

创建配置文件`http-proxy.conf`

```plaintext
[Service]
Environment="HTTP_PROXY=http://proxy.example.com:80"
Environment="HTTPS_PROXY=https://proxy.example.com:443"
Environment="NO_PROXY=your-registry.com,10.10.10.10,*.example.com"
```

下面是我司的配置

```plaintext
Environment="HTTP_PROXY=http://192.168.99.11:7890"
Environment="HTTPS_PROXY=http://192.168.99.11:7890"
Environment="NO_PROXY=localhost,127.0.0.1,192.168.99.*,*.aliyuncs.com"
```

#### 2.重新加载docker

```bash
sudo systemctl daemon-reload
sudo systemctl restart docker
```

#### 3.验证配置已应用

`systemctl show --property=Environment docker`
