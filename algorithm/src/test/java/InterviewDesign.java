public class InterviewDesign {
26. 项目: 各部分职责，有哪些优化点

// 电商

// ToB IM

// feed流，内容

// 开放平台

// 分布式限流
//   2. 分布式限流，限流组件设计

// 分布式调度
//  3. 设计一个分布式任务调度系统，模型如何设计？核心api如何设计
//  - addTask 添加任务
//  - addDependence 添加依赖
//  - fetchTask 获取任务，只能获取没有依赖，或依赖已全部执行完的
//  - executeTask 执行任务
//  - 如何分库分表，addTask和addDependence会有跨库依赖问题吗？fetchTask会有会有跨库依赖问题吗？问题严重吗？如何处理跨库依赖问题
//  - 设计题还有一个问题：executeTask如何跨节点执行
//  4. 设计一个延时任务系统


// 异地多活架构
//    7. 异地多活架构设计

// 秒杀



// 其他
//  5. 介绍下怎么实现流式处理里面的双流JOIN。
6. 文件网关设计（指标、容错、时效性、高可用）
8. 高考查分数，选用什么数据库，等等。
9. 抖音上购买电影票，在一个事务中，以下三条SQL语句要怎么排列呢
1. 从顾客A账户余额中扣除电影票价；
2. 给影院平台B账户余额增加这张电影票价；
3. 记录一条交易日志。
10. 直播打赏系统（多次考）
11. 金币管理系统
1. 有学生老师 课程，一个学生可以选择多个课程一个老师也可以教多个课程，提供这个数据结构的解决方案。所有的学生一起抢一个课程，需要去保证公平性，一致性，实时性这三个的解决方案。

19. A和B两个系统，数据异构，需要交换信息？怎么保证一致性？怎么保证5个9的可用性？
直播过程中的“送礼“场景:数百用户同时向一个主播的账户(数据库)写入，出现“抢锁”局面，性能 上不去，如何解决?
41. 海量数据处理(如何在 10G 内存中找颠倒的字符串，内存只有 2g)， 字典树排序， 线程的各种通信方式:管道，消息队列等使用场景和各自优缺点 线程调度算法
49. 生成短链题
设计一个短链服务
71. 单点登录的实现原理
75. 最大线程10，有界队列100，执行过程中有任务被放到了有界队列，问过了一段时间后，任务执行完成后，线程池的线程数量是多少，闲置的线程是怎么销毁的
22. 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就 是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高 金额。


1. 比如 app 启动的时候 如何保证广告对广告主的预算不超 项目里面会提问 主要也是 数据库 并行 同步 异步相关的（广告）
2. mysql 索引,当分页 offset 很大时怎么优化? 如何实现一条广告每天只展示给定次数，或者一段时间内最多展示 n 次数 分布式 session，怎样实现多域名单点登录有效
3. 假如要做一个日志采集的agent，如何设计?
4. 一个推送场景，50 条内容，定时推送，先推 5%用户，一段时间后再找出效果最好的几条， 推给所有用户。设计相关库表，系统模块, 需要可以落地，有伪代码
5. 怎样实现很多人的实时在线聊天室系统
6. 领域建模有什么坑?有什么好的建模方式
7. 问了下秒杀系统设计细节
8. 设计一个延时任务系统
9. 场景题(优惠券的设计，各种场景如何保证）
10. 领域模型优劣


1. 什么是广告；广告投放、触发相关工作（广告业务）
2. 说说项目中最难，或者最有挑战的内容; 说一下对你挑战最大的一个项目
3. 本地缓存怎么优化空间?(提出 BitMap)BitMap 可行吗?怎么验证可行性?如果不可行，怎么证伪? 其他语言有了解过吗?Scala 的集合有什么特性?python 有什么高级特性? 怎么学习新技术?哪些是基础技术?
4. 在部门中是什么角色定位?
5. 在什么时间点展示“送礼”行为最合适?
6. 基本上项目里用到的中间件或者框架都会问到、中间件的原理 基础知识和框架等都会问如何使用的，用来干嘛，然后就是为何选型等
7. 数据同步怎么做的?怎么保证一致性?
8. 平时遇到的问题，查询的思路，优化的思路
9. 做过的项目碰到过哪些难点
}
