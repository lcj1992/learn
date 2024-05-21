public class InterviewBase {
    //// shell命令：网上找一下
    // 文本sed，kill、ed、awk、xargs
    // top、free、arthas、ss、


    //// spring、spring cloud、spring boot：之前的PPT
    // ApplicationContext 的初始化过程?初始化过程中发现循环依赖 Spring 是如何处理的?


    //// 数据库：高性能MySQL、极客时间课程、之前PPT，宗星的PPT、ata
    // mysql的隔离级：读未提交、读提交、可重复读、串行化
    // mysql的ACID特性：原子性、一致性、隔离性、持久性
    // 索引用 B+树有什么好处
    // b 树有什么优点，如 mongodb 中就用了 b 树。 mysql 的事务实现
    // mysql隔离级别有哪些
    // 读已提交和可重复读的区别
    // 一致性视图怎么实现的
    // binlog作用、redolog和undolog区别
    // mvcc
    // mysql主从半同步
    // 数据库索引优化
    // mysql acid 分别是怎么实现和保障的
    // mysql：事务回滚原理(undolog)、插入语句回滚的时候undolog怎么记录
    // 注册中心如果保证一致性、当主节点发生异常，如何重新选举
    // Binlog都有什么格式？怎么做同步？
    // Binlog和redo什么关系？二阶段提交怎么做？binlog挂了会怎么样？
    // 倒排索引
    // 有主键 id1 和索引 id2，范围查询 id2 的时间复杂度
    // MySql 索引是什么数据结构?B tree 有什么特点?优点是什么?
    // 慢查询怎么优化?
    // 聊一下数据库事务、默认隔离级别、以及数据库 MVCC 和锁的区别，使用场景，举个例子说明一下
    // mysql 为什么用 b+树?mysql 为什么必须要主键?InnoDB 和 MyISam 的区别
    // B+树和B树对比：我说了mysql索引实现和mongo的实现，定位不同
    // 什么是回表、索引覆盖
    // mysql 联合索引（最左匹配），大数据查询分页优化
    // 索引用 B+树有什么好处
    // 有主键 id1 和索引 id2，范围查询 id2 的时间复杂度
    // 数据一致性如何保证
    // TODO MySQL，互斥锁，乐观锁


    //// 编程语言：java并发编程实战、之前的ppt、极客时间的课
    // Java 反射，能否获取到父类
    // java的零拷贝
    // int integer 区别
    // 集合框架：HashMap、ConcurrentHashMap
    // HashMap 如果一直 put 元素会怎么样?hashcode 全都相同如何?equals 方法都相同如何?
    // 并发编程：synchronized、Lock、ThreadLocal、
    // ReentrantLock是否重入、synchronized是否重入、非公平锁是什么意思、没获取到锁进入什么队列、cas如何解决aba问题等
    // volatile，是否能保证原子性
    // 说一下可见性
    // Java 的 Atomic 的递增方法能保证可见性吗
    // 指令重排序有什么意义?
    // synchronized 怎么用? 并发包里的原子类有哪些，
    // 怎么实现?cas 在 CPU 级别用什么指令实现的?
    // 如何控制并发数，说了下信号量的底层实现
    // JDK 1.8 ConcurrentHashMap 做过什么改进?HashMap 死锁? 标记的时候怎么找出栈上的 GC Root?说出一种可能的方案，存在什么问题?
    // JDK 1.7 比前一个版本有哪些改进?
    // 锁，如何设计读写锁，aqs 的原理
    // ThreadLocal原理及其多线程下应用注意点
    // AQS底层实现。 sync和lock对比
    // 死锁的4个条件，排查线程死锁，如何定位
    // 线程池，核心线程
    // 如何解决重入的问题?在第一步写 redis 失败怎么办?
    // Java 虚引用，实际用过吗?
    // AQS 的实现原理，cas 有什么问题
    // 类加载过程
    // JUC AQS countLatch
    // 线程间通信，两个线程，一个依次输出[1,3,5,7,9],一个依次输出[2,4,6,8,10]，怎么保证最后输出结果是[1,2,3,4,5,6,7,8,9,10]
    // 之前有没有碰到过线上的并发问题
    // 最大线程10，有界队列100，执行过程中有任务被放到了有界队列，问过了一段时间后，任务执行完成后，线程池的线程数量是多少，闲置的线程是怎么销毁的

    //// RPC
    // rpc 的原理
    // dubbo 怎么做的负载均衡?有没有更好的方式?比如根据机器实际的负载均衡情况去分配，怎么实现?


    //// MQ
    // 如何用 redis 实现一个 mq
    // MQ 怎么保证消息至少投递一次
    // MQ 的一个 consumer group 里的一个 consumer 挂了，会发生什么情况
    // kafka 和rocketmq的区别
    // mq事务消息
    // 问我熟不熟悉 kafka，我用的 rocketmq，于是问了 rocketmq 的分区和顺序消费
    // 聊一下 Rocketmq，集群如何部署，消费是pull还是push，负载均衡策略，增加消费机如何分配消费队列
    // kafka 为什么 topic 多了，性能会下降?怎么设计才能使保证消息只投递过一次，不是能使用业务上的


    //// Redis、tair，redis源码，redis实战，redis源码解读
    // redis的数据结构
    // redis的扩容机制
    // Redis缓存雪崩和缓存击穿是什么？什么解决方案。
    // 缓存：一致性、双删、缓存雪崩、穿透。项目：高可用建设。
    // redis扩容原理，是怎么最小影响数据变化
    // redis在日常工作中有哪些用法和注意点
    // redis预热是在什么场景使用
    // Redis的淘汰机制有哪些？有什么算法实现？
    // Redis 数据结构有哪些?如何实现 sorted set?这种数据结构在极端情况下可能有什么问题?
    // redis 中字符串的底层结构是什么 hash 底层结构是什么
    // hash 冲突怎么解决的 冲突太多怎么办 冲突还是很多要怎么办
    // hash 扩容过程
    // hash 扩容会阻塞请求吗 用过 redis 里面的事务吗
    // Redis 怎么保证高性能和可靠性
    // RDB 刷盘的时候同时大请求量更新会有什么问题，对于大对象的内存担保策略有什么规则
    // AOF 和 RDB 单独用会有什么问题
    // redis、mq、mysql、锁、es、gc、Lru
    // redis 里面数据结构的模型
    // memcached 与 redis 的异同，memcached 的各种问题
    // redis 的事务、
    // redis的分片和slot是什么，
    // Codis分片如何做平滑迁移，迁移过程中key的读写控制
    // redis持久化过程
    // redis 多线程 单线程  6.0的一些特性
    // redis list底层数据结构
    // redis 基础
    // 如何保证缓存和数据库的一致性


    //// es、opensearch、mongo、lindorm、hbase、adb
    // es 的命令
    // 搜索引擎的删除过程


    //// ZooKeeper
    //各级之间的服务发现如何实现?ZooKeeper 是如何部署的?有没有出现过连不上 ZooKeeper 而的问题? 如何解决服务副本间的一致性问题?


    //// io模型
    // netty
    // Select poll epoll说一下 IO、NIO/BIO
    // 多路复用的原理


    //// 网络
    // https TLS协议过程
    // http2 的新特性有哪些
    // Timewait
    // http 连接复用
    // timewait 和 closewait
    // nginx，Linux 相关的问题 redis，分布式缓存的一些基本概念，然后还有海量数据的搜索
    // 网络tcp的time-wait，说下四次挥手


    //// 操作系统，CSAPP
    // 进程、线程、协程
    // ctrl+c 背后系统发生的事情


    //// 虚拟机，之前的ppt、深入理解java虚拟机
    // 字节码
    // jvm的内存结构
    // jvm的垃圾回收机制
    // GC 用什么收集器?收集的过程如何?哪些部分可以作为 GC Root?
    // ParNew 收集过程，如何调优 ParNew?如何减少 full gc?调大 YoungGen 有什么好处坏处?
    // 垃圾回收器怎么选择，考虑哪些因素?(吞吐量，响应时间)
    // 要求承载 1000qps、rt 不超过 50ms 容量的系统，怎么做 jvm 调优，内存具体设置多少怎么去确定?
    // G1&CMS说一下
    // jdk原生工具，jmx（MBean），线程池各个参数
    // javaagent接入流程


    //// 分布式事务怎么用
    // Raft协议了解吗
    // 二阶段提交过程


    //// 分布式锁怎么实现
}
