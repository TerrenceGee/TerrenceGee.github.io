# kafka

## docker安装单机版

```yaml
version: '3'

services:
  zookeeper:
    image: $ZOOKEEPER_IMAGE
    container_name: zookeeper_1
    ports:
      - "2181:2181"
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes  # 允许匿名访问（测试用）
    volumes:
      - "zookeeper_data:/bitnami/zookeeper"
    privileged: true

  kafka:
    image: $KAFKA_IMAGE
    container_name: kafka_1
    ports:
      - "9092:9092"  # Kafka 对外端口
    environment:
      - TZ=Asia/Shanghai
      - KAFKA_BROKER_ID=1
      - KAFKA_CFG_NODE_ID=1
      - KAFKA_CFS_LISTENERS=9092
      - KAFKA_CFS_ADVERTISED_LISTENERS=192.168.190.129:9092
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes  # 允许明文通信（测试用）
      - KAFKA_HEAP_OPTS=-Xmx512m -Xms256m
    volumes:
      - "kafka_data:/bitnami/kafka"
    depends_on:
      - zookeeper
    privileged: true

volumes:
  zookeeper_data:
  kafka_data:
```