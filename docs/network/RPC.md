# RPC 协议

## 概念

RPC：Remote Procedure Call
IPC：Inter Process Communication

RPC 的三个基本问题：

- 如何表示数据？->序列化与反序列化方式
- 如何传输数据？->一般指的是应用层数据，传输层数据都是 TCP，UDP 没有意义
- 如何表示方法？->

## gRPC 对于 RPC 的实现

- 表示数据？protobuffers 的二进制序列化
- 传输数据？基于 HTTP/2
- 表示方法？使用 proto 文件中进行定义

### HTTP/2与 HTTP/1.1的对比

## 参考资料

- 周志明《凤凰架构》
