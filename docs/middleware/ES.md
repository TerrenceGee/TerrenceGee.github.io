# ES

## 安装教程

兼容性：[ES 兼容性](https://www.elastic.co/cn/support/matrix)
下载地址：[官方](http://elastic.co/) \ [elastic 之家](http://elastic.show/download)

> 教学版本就使用主机方式安装

| 组件 | 版本 |
| --- | --- |

Elasticsearch 目录结构：

| 目录 | desc |
| --- | --- |
| data | 数据存放目录，生产环境必须修改 |
| logs | 默认的日志文件存储路径，生产环境务必修改 |
| modules | es 所有的模块 |
| plugins | 已经安装的插件 |
| jdk/jdk.app | 自带的 java 环境 |

安装项目结构方式：

- 单机单节点
- 单机集群单项目多个节点，注意 data 和 log 目录不同节点要分开
- 单机集群多个项目单节点

需要安装的组件有

- java，java8 或者 java11
- elasticsearch，注意中国使用要准备分词器   9200
- kibana，一个可视化控制台  5601
- es-head 插件 9100
- ik 分词器插件 `curl -X GET "localhost:9200/_cat/plugins?v"`

集群健康状态的查询方式：

```txt
GET _cat/health?v
GET _cluster/health
```
