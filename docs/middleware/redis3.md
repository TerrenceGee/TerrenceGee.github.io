# redis

> 参考资料：
>
> - 《Redis 开发与运维》

## 1.快速安装

### Linux

#### 宿主机安装

> 一般宿主机安装redis建议使用systemd的方式来管理

1.下载并编译redis

> 安装redis可以下载源码和使用包管理工具apt来.包管理工具更加方便,不需要手动创建redis的systemd单元.但是源码安装更加自由化,版本选择更自由

先安装基础环境

```bash
sudo apt update
# 
sudo apt install -y gcc
# 
sudo apt install -y libjemalloc-dev
# 
sudo apt install -y make
```

```bash
# 下载压缩包
wget http://download.redis.io/releases/redis-3.0.7.tar.gz
# 解压包
tar xzf redis-3.0.7.tar.gz
# 创建软链接
ln -s redis-3.0.7 redis

cd redis
# makefile 编译
make
# 清理make缓存
# make distclean
# 根据makefile的定义,将文件复制到系统目录
sudo make install
# 运行命令查看安装是否完成
redis-server --version
```

2.配置redis的工作目录

```bash

sudo mkdir -p /etc/redis
sudo cp redis.conf /etc/redis/redis.conf
# 编辑redis.conf,修改相关配置
sudo vim /etc/redis/redis.conf
sudo mkdir -p /var/lib/redis /var/log/redis
# 
sudo chown -R redis:redis /var/lib/redis /var/log/redis
```

3.配置systemd服务

```bash
# 创建用户和组
sudo adduser --system --group --no-create-home redis
# 创建systemd服务文件
sudo vim /etc/systemd/system/redis.service

# 安装完毕后,尝试启动
sudo systemctl daemon-reload
sudo systemctl start redis
sudo systemctl enable redis
sudo systemctl status redis

# 测试redis
redis-cli ping
redis-cli -v

# 开放防火墙
sudo ufw allow 6379
```

```ini
[Unit]
Description=Redis In-Memory Data Store
After=network.target

[Service]
User=redis
Group=redis
ExecStart=/usr/local/bin/redis-server /etc/redis/redis.conf
ExecStop=/usr/local/bin/redis-cli shutdown
Restart=always
Type=notify
WorkingDirectory=/var/lib/redis

[Install]
WantedBy=multi-user.target
```

4.配置,启动,操作,关闭redis

启动redis:有三种方式:默认配置,命令行运行配置,配置文件启动

```bash
# 
redis-server /opt/redis/redis.conf
```

进行redis操作:redis-cli,有两种使用方式:交互式和命令式

停止redis服务:redis-cli shutdown 

> redis的关闭 \
> 1.先断开与客户端的连接,生成持久化文件 \
> 2.`kill -9`不会做持久化操作,还可以导致数据丢失 \
> 3.`redis-cli shutdown nosave | save`控制redis关闭时是否生成持久化文件

#### docker

> docker安装格式建议使用docker-compose进行容器的配置

## API

## 3.小工具及其最佳实践

## 4.客户端工具

## 5.持久化

## 6.复制

## 7.Redis 阻塞问题

## 8.理解内存

## 9.哨兵集群

## 10.Redis-Cluster集群

## 11.缓存设计

## 12.踩坑

## 13.Redis 监控运维云平台 CacheCloud

## 14.Redis 配置统计字典
