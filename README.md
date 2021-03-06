### seata整合教程参考： [https://blog.csdn.net/jixieguang/article/details/110621561](https://blog.csdn.net/jixieguang/article/details/110621561)
 [https://blog.csdn.net/qq_42905196/article/details/106662952](https://blog.csdn.net/qq_42905196/article/details/106662952)


# seata-demo使用教程

## 介绍
Seata1.4.0分布式事务示例，整合Spring Boot 、Spring Cloud、Spring Cloud Alibaba、Nacos。


## 安装教程

### 安装[Nacos](https://nacos.io/zh-cn/)
### 安装[Seata](https://seata.io/zh-cn/)
### git clone [https://github.com/HLDBanana/seata_demo](https://github.com/HLDBanana/seata_demo)

## 使用说明

### 修改Nacos配置并初始化Nacos数据库
```bash
mysql -uroot -p
source nacos.sql
```
### 修改Seata配置并初始化seata数据库
```bash
mysql -uroot -p
source seata.sql
```
### 切换Seata注册中心为Nacos，初始化Seata配置到Nacos
```bash
# -t 命名空间id
# -g 分组
# -h nacos服务地址
sh nacos-config.sh -h 182.92.219.202 -p 8848 -g SEATA_GROUP -u nacos -w nacos -t  51915a62-d2d6-43d4-8f45-86b159eb90f5
```
### 创建并初始化业务数据库
```bash
mysql -uroot -p
source seata_account.sql
source seata_storage.sql
source seata_order.sql
```
### 启动服务测试

依次启动MySQL、Nacos、Seata、所有微服务，浏览器输入地址[http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100](http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100)进行测试。

