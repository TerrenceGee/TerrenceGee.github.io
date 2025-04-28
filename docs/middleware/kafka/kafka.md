# kafka

## docker安装单机版

```yaml
version: "3"
services:
  
  zookeeper:
    image: $ZK_IMAGE
    container_name: zookeeper
    hostname: zookeeper
    privileged: true
    restart: always
    environment:
      ALLOW_ANONYMOUS_LOGIN: "true"
    volumes:
      - ./zookeeper/data:/opt/bitnami/zookeeper/data
      - ./zookeeper/logs:/opt/bitnami/zookeeper/logs
      - ./zookeeper/conf/zoo.cfg:/opt/bitnami/zookeeper/conf/zoo.cfg
    ports:
      - "2181:2181"
  kafka:
    image: $KAFKA_IMAGE
    container_name: kafka
    hostname: kafka
    privileged: true
    restart: always
    environment:
      KAFKA_CFG_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_CFG_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:9093
      KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_CFG_LISTENERS: PLAINTEXT://:9092,PLAINTEXT_HOST://:9093
      KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE: "true"
    volumes:
      - ./kafka/data:/opt/bitnami/kafka/data
    ports:
      - "9092:9092"
        #deploy:
        #resources:
        #limits:
         # cpus: '4'
          #memory: 4G
        #reservations:
         # cpus: '0.5'
         # memory: 200M 
    depends_on:
      - zookeeper
  kafka-ui:
    image: provectuslabs/kafka-ui
    container_name: kafka-ui
    hostname: kafka-ui
    privileged: true
    restart: always
    environment:
      - DYNAMIC_CONFIG_ENABLED=true
      - AUTH_TYPE=LOGIN_FORM
      - SPRING_SECURITY_USER_NAME=kafka
      - SPRING_SECURITY_USER_PASSWORD=kafka
    #volumes:
    #  - ~/kui/config.yml:/etc/kafkaui/dynamic_config.yaml
    ports:
      - "8080:8080"
    deploy:
      resources:
        limits:
          cpus: '1'
          memory: 2G
        reservations:
          cpus: '0.5'
```

## 生产者参数

```properties
# 设置两个以上的地址
bootstrap.servers=host1:port1,host2:port2
key.serializer=org.apache.kafka.common.serialization.StringSerializer
value.serializer=org.apache.kafka.common.serialization.StringSerializer
# 
client.id=""
# 重试次数，默认是0
retries=0
# 分区器
partitioner.class=org.apache.kafka.clients.producer.internals.DefaultPartitioner
# 拦截器
interceptor.classes=className1,className2
# RecordAccumulator缓存的大小配置，单位B
buffer.memory=33554432B
# 当缓存满了的时候，阻塞时间后，抛出异常
max.block.ms=60000
# BufferPool中缓存的ByteBuffer的最大容量，这个容量对应一个ProducerBatch批次的大小，要么按这个大小创建，要么按较大的大小创建
batch.size=16384B
# 每个连接最多缓存的未响应的请求的数量，这个参数可能会因为消息重试而导致消息乱序
max.in.flight.requests.per.connection=5
# 客户端更新元数据的最大间隔时间
metadata.max.age.ms=300000

# 
acks=1
# 生产者发送消息的最大值
max.request.size=1048576B
# 重试之间的时间间隔
retry.backoff.ms=100
# 压缩，时间换空间
compression.type
# 时间关闭闲置的连接
connections.max.idle.ms=540000
# ProducerBatch发送的等待时间
lingers.ms=0

receive.buffer.bytes=32768
send.buffer.bytes=131072
# Producer等待请求响应的最长时间
request.timeout.ms=30000
```

## 消费者参数

```properties
# 配置消费者与订阅主题之间的分区分配策略
partition.assignment.strategy
# 配置消费者组id，一个消息只会被对应的消费者组中的一个消费者所消费
group.id="example-group"
# 连接broker地址清单
bootstrap.servers=host1:port1,host2:port2
# 
key.deserializer 和 value.deserializer
# 
client.id=
# 消费者提交消息消费的方式
enable.auto.commit=true
# 自动提交消息的时间间隔
auto.commit.interval.ms
```