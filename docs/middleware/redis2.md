# redis

## 持久化

### RDB(Redis Database Backup file)

| cli | feature |
| --- | --- |
| save | master execute, will block other all command |
| bgsave | aka background save, execute by worker process, not affect other process |

redis.conf, note that in `/etc/redis/redis.conf` if use docker

主动触发

```conf
daemonize no
pidfile /data/redis.pid
port 6379
bind 0.0.0.0
requirepass lilishop
rdbcompression yes
dbfilename dump.rdb

# note that RDB pattern
save 900 1
save 300 10
save 60  10000
```

RDB的执行原理：使用 copy-on-write技术

- RDB的过程中的读：读取共享内存
- RDB的过程中的写：复制一份数据用来写，当RDB结束后，用复制的数据来替换原来的数据

<!-- ![RDB原理](../../static/image/image.png) -->

RDB最大的缺点：
最后一次持久化的数据可能会出现丢失的情况。在持久化的过程中，服务器宕机，存储数据并不完整，比如子进程生成了rdb文件，但是主进程还没来得及用它覆盖掉原来的旧rdb文件，这样就把最后一次持久化的数据丢失了。

### AOF(Append Only File)

| command | desc | feature |
| --- | --- | --- |
| appendonly yes | AOF default close | |
| appendfilename "appendonly.aof" | filename | |
| appendfsync always | 每执行一次写，立即记录到AOF文件 | |
| appendfsync everysec | 默认方案，写命令执行完先进入AOF缓冲区，每隔1秒将缓冲区写入AOF文件 | |
| appendfsync always | 先放入缓冲区 | |
| bgrewrietaof | 最少命令达到最大效果 | |
| auto-aof-rewrite-percentage 100 | AOF比上次文件超出百分比自动执行重写 | |
| auto-aof-rewrite-min-size 64mb | AOF文件达到大小后触发重写 | |

### RDB与AOF对比

| aspect | RDB | AOF |
| --- | --- | --- |
| 持久化 | 定时整个内存做快照 | 记录执行命令 |
| 数据完整性 | 不完整，再次备份之间会丢失 | 相对完整，可设置刷盘策略（推荐每秒）|
| 文件大小 | 可以压缩，小 | 记录命令，可重写，大 |
| 宕机恢复 | 快 | 慢 |
| 数据恢复 | 低，完整性受损 | 高 |
| 系统占用 | 高（CPU，内存）| 低（磁盘IO）|
| 使用场景 | 可容忍数分钟数据丢失，追求启动速度 | 数据完整性要求高 |

## 删除策略

| type | command | desc | merit | demerit |
| --- | --- | --- | --- | --- |
| 惰性删除 |  | 只有在使用时才会检查是否过期 | CPU友好，不需计算 | 会一直占用内存空间 |
| 定期删除 |  | SLOW和FAST模式 | 调节频率来缓解CPU压力，释放内存 | 频率不好把控 |

实际项目中使用这两种策略混合

## 数据淘汰策略

| strategy | desc |
| --- | --- |
| nieviction | 内存满了写入失败 |
| volatile-ttl | 淘汰剩余TTL小的键 |
| allkeys-random | 淘汰随机键 |
| volatile-random | 淘汰随机设置了TTL的键 |
| allkeys-lru | least recently used 最近最少使用 |
| volatile-lru | 设置了TTL的key使用LRU |
| allkeys-lfu | least frequently used 最少频率使用 |
| volatile-lfu | 设置了TTL的key使用LFU |

使用建议

- 有明显的冷热数据：allkeys-lru
- 没有冷热数据区分：allkeys-random

数据库有超量数据，redis只能存取一部分：配置`allkeys-lru`策略，正常使用缓存，留下来的就是热点数据
Redis的内存使用完毕，使用 noeviction -> 报错，存储失败， 其他淘汰策略 -> 正常淘汰内存

## 分布式锁
