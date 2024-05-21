public class InterviewBase {
// shell命令
2. shell 的 sed，kill
6. ed 命令
8. awk 命令

// spring
19. ApplicationContext 的初始化过程?初始化过程中发现循环依赖 Spring 是如何处理的?


//    数据库
//    mysql的隔离级：读未提交、读提交、可重复读、串行化
//    mysql的ACID特性：原子性、一致性、隔离性、持久性
//1. 索引用 B+树有什么好处
//2. b 树有什么优点，如 mongodb 中就用了 b 树。 mysql 的事务实现
1. mysql隔离级别有哪些
2. 读已提交和可重复读的区别
3. 一致性视图怎么实现的
5. binlog作用、redolog和undolog区别
mvcc
8. mysql主从半同步
9. 数据库索引优化
15. mysql acid 分别是怎么实现和保障的
16. mysql：事务回滚原理(undolog)、插入语句回滚的时候undolog怎么记录
注册中心如果保证一致性、当主节点发生异常，如何重新选举
17. Binlog都有什么格式？怎么做同步？
18. Binlog和redo什么关系？二阶段提交怎么做？binlog挂了会怎么样？
倒排索引
15. 有主键 id1 和索引 id2，范围查询 id2 的时间复杂度
24. MySql 索引是什么数据结构?B tree 有什么特点?优点是什么?
25. 慢查询怎么优化?
72. 聊一下数据库事务、默认隔离级别、以及数据库 MVCC 和锁的区别，使用场景，举个例子说明一下
32. mysql 为什么用 b+树?mysql 为什么必须要主键?InnoDB 和 MyISam 的区别
100. B+树和B树对比：我说了mysql索引实现和mongo的实现，定位不同
101. 什么是回表、索引覆盖
105. mysql 联合索引（最左匹配），大数据查询分页优化
10. 索引用 B+树有什么好处
11. 有主键 id1 和索引 id2，范围查询 id2 的时间复杂度
110. 数据一致性如何保证


//    编程语言
12. Java 反射，能否获取到父类
98. java的零拷贝
//    集合框架：HashMap、ConcurrentHashMap
18. HashMap 如果一直 put 元素会怎么样?hashcode 全都相同如何?equals 方法都相同如何?
//    并发编程：synchronized、Lock、ThreadLocal、
reentrantlock是否重入、synchronized是否重入、非公平锁是什么意思、没获取到锁进入什么队列、cas如何解决aba问题等
volatile
113. volatile是怎么样的，是否能保证原子性
13. 说一下可见性
14. Java 的 Atomic 的递增方法能保证可见性吗
21. Volatile 关键字，指令重排序有什么意义? synchronied 怎么用? 并发包里的原子类有哪些，
22. 怎么实现?cas 在 CPU 级别用什么指令实现的?
17. 如何控制并发数，说了下信号量的底层实现
27. JDK 1.8 ConcurrentHashMap 做过什么改进?HashMap 死锁? 标记的时候怎么找出栈上的 GC Root?说出一种可能的方案，存在什么问题?
29. JDK 1.7 比前一个版本有哪些改进?
锁，如何设计读写锁，aqs 的原理
99. ThreadLocal原理及其多线程下应用注意点
97. AQS底层实现。 sync和lock对比
96. 死锁的4个条件，排查线程死锁，如何定位
线程池，核心线程
如何解决重入的问题?在第一步写 redis 失败怎么办?
Java 虚引用，补了句实际用过吗?
53. AQS 的实现原理，cas 有什么问题
84. 类加载过程
86. JUC AQS countLatch
线程间通信，77. 两个线程，一个依次输出[1,3,5,7,9],一个依次输出[2,4,6,8,10]，怎么保证最后输出结果是[1,2,3,4,5,6,7,8,9,10]
112. 之前有没有碰到过线上的并发问题
9. Java 的 Atomic 的递增方法能保证可见性吗
5. 说一下可见性

//    RPC
rpc 的原理
52. dubbo 怎么做的负载均衡?有没有更好的方式?比如根据机器实际的负载均衡情况去分配，怎么实现?

//    MQ
如何用 redis 实现一个 mq
66. MQ 怎么保证消息至少投递一次
67. MQ 的一个 consumer group 里的一个 consumer 挂了，会发生什么情况
107. kafka 和rocketmq的区别
mq事务消息
119. 问我熟不熟悉 kafka，我用的 rocketmq，于是问了 rocketmq 的分区和顺序消费
76. 聊一下 Rocketmq，集群如何部署，消费是pull还是push，负载均衡策略，增加消费机如何分配消费队列



//    Redis
//    1. redis的数据结构
//    2. redis的扩容机制
//    3. Redis缓存雪崩和缓存击穿是什么？什么解决方案。
11. 缓存：一致性、双删、缓存雪崩、穿透。项目：高可用建设。
12. redis扩容原理，是怎么最小影响数据变化
13. redis在日常工作中有哪些用法和注意点
14. redis预热是在什么场景使用
21. Redis的淘汰机制有哪些？有什么算法实现？
23. Redis 数据结构有哪些?如何实现 sorted set?这种数据结构在极端情况下可能有什么问题?
57. redis 中字符串的底层结构是什么 hash 底层结构是什么
58. hash 冲突怎么解决的 冲突太多怎么办 冲突还是很多要怎么办
59. hash 扩容过程
60. hash 扩容会阻塞请求吗 用过 redis 里面的事务吗
64. Redis 怎么保证高性能和可靠性
65. RDB 刷盘的时候同时大请求量更新会有什么问题，对于大对象的内存担保策略有什么规则
68. AOF 和 RDB 单独用会有什么问题
31. redis、mq、mysql、锁、es、gc、Lru
33. redis 里面数据结构的模型
34. memcached 与 redis 的异同，memcached 的各种问题
redis 的事务、
102. redis的分片和slot是什么，
103. Codis分片如何做平滑迁移，迁移过程中key的读写控制
104. redis持久化过程
redis 多线程 单线程  6.0的一些特性
114. redis list底层数据结构
106. redis 基础
70. 如何保证缓存和数据库的一致性


// es
35. es 的命令

// ZooKeeper
各级之间的服务发现如何实现?ZooKeeper 是如何部署的?有没有出现过连不上 ZooKeeper 而的问题? 如何解决服务副本间的一致性问题?

// io模型
// netty
82. Select poll epoll说一下 IO、NIO/BIO
83. 多路复用的原理


//    网络
https TLS协议过程
4. http2 的新特性有哪些
42. Timewait
43. http 连接复用
45. timewait 和 closewait
46. nginx，Linux 相关的问题 redis，分布式缓存的一些基本概念，然后还有海量数据的搜索
网络tcp的time-wait，说下四次挥手


//    操作系统
//    进程、线程、协程
ctrl+c 背后系统发生的事情

//    虚拟机
//    字节码
28. 字节码有了解过吗?
//    jvm的内存结构
//    jvm的垃圾回收机制
20. GC 用什么收集器?收集的过程如何?哪些部分可以作为 GC Root?
30. ParNew 收集过程，如何调优 ParNew?如何减少 full gc?调大 YoungGen 有什么好处坏处?
55. 垃圾回收器怎么选择，考虑哪些因素?(吞吐量，响应时间)
56. 要求承载 1000qps、rt 不超过 50ms 容量的系统，怎么做 jvm 调优，内存具体设置多少怎么去确定?
87. G1&CMS说一下

// 分布式事务怎么用，
115. Raft协议了解吗
116. 二阶段提交过程

// 分布式锁怎么实现。
}
