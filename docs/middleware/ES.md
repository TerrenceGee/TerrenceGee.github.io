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

> 生产环境要求一个服务器只能启动一个节点

## 核心概念

分布式的搜索、存储和分析引擎。
用途：搜索引擎、垂直搜索、BI（商业智能）、ELKB

节点：每一个启动的 Java 进程
角色：

- master：候选节点
- data：数据节点
- data_content：数据内容节点
- data_hot：热节点
- data_warm：索引不再 定期更新
- data_cold：冷节点， 只读索引
- Ingest：预处理节点，作用类似于 Logstash 中的 FIlter
- ml：机器学习节点
- remote_cluster_client
- transform
- voting_only：仅投票节点

分片

- 每个数据拥有 N 个分片，第个分片拥有 M 个副本。7.0之前默认5个分片，7.0之后默认一个主分片。副本可以在索引创建之后修改数量，而主分片的数量一旦确定，就不能修改
- 每个节点是一个 ES 实例，每个分片是一个 Lucene 实例，有完整的创建索引和处理请求的能力
- ES 会自动在 nodes 上做分片均衡
- 一个 doc 不可能同时存在于多个主分片中，但是可以在每个主分片的不同副本中
- 每个主分片和其副本分片不能同时存在于同一个节点上，所以最低的可用配置是两个节点互为主备。

集群

- 原生分布式
- 一个节点≠一台服务器

集群的健康值：

- Green
- Yallow
- Red：至少一个 Replica 不可用，但是所有 Primary 均为 active，
- `_cat/health?v`
- `_cluster/health`

索引和文档

索引-Index，类似于关系型数据库中的表
文档-Document，类似于关系型数据库的数据行

## 安装

### docker安装单机版

```yml
version: '3'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.12.0
    container_name: elasticsearch
    environment:
      - discovery.type=single-node
      - ES_JAVA_OPTS=-Xms1g -Xmx1g
      - xpack.security.enabled=false # 禁用认证（仅测试环境使用）
    volumes:
      - es_data:/usr/share/elasticsearch/data
    ports:
      - "9200:9200"
    networks:
      - elk_network

  kibana:
    image: docker.elastic.co/kibana/kibana:8.12.0
    container_name: kibana
    depends_on:
      - elasticsearch
    ports:
      - "5601:5601"
    environment:
      - ELASTICSEARCH_HOSTS=http://elasticsearch:9200
    networks:
      - elk_network

volumes:
  es_data:

networks:
  elk_network:
    driver: bridge
~                    
```