---
sidebar_position: 1
sidebar_label: '微服务架构理念'
---

# theory

## 服务发现

类库封闭+编译链接：软件规模发展的第一次飞跃
服务发现（Service Discovery）：可与之相提并论的第二次飞跃（如果要与类库调用作对比，服务发现+服务调用合并起来称为飞跃更为合理）

服务对外地址信息：

1. 全限定名
2. 端口号
3. 服务标识

- 服务注册(Service Registration): 服务启动的时候，它应该能够通过某些形式将自己的坐标信息通知到服务注册中心
  - 调用API
  - 产生事件消息
  - zk/Etcd中指定位置记录
  - 存入数据库
- 服务维护(Service Maintaining): 确认服务的健康状态，死亡服务优雅地下线
  - 支持多种协议(HTTP, TCP)
  - 多种方式（长连接、心跳、探针、进程状态）
- 服务发现(Service Discovery): 消费服务通过服务发现的信号找到目标服务提供者提供的具体服务的过程
  - HTTP API请求
  - DNS Lookup
  - k8s注入环境变量

