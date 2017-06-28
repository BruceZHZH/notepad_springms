# Introduction
该程序在Spring MicroService以及Mysql数据库的基础上，实现了两个微服务功能：
1. 用户注册和登陆
2. 提交和查看TODO

原本计划是使用MongoDB存储数据的，但是在项目整合的过程中，MongoDB一直有一些问题，由于时间的原因，我们被迫改为使用Mysql数据库重新开发。

# How To Run
## 1. 启动

两个服务是完全独立的，但应当先启动account，再启动service

## 2. 运行
### account服务

#### 添加账户
访问通过浏览器访问localhost:8084/account/create，并在路径后面添加上要创建用户的用户名和密码，例如：

> localhost:8084/account/create?name=zhao&password=123

用户就可以创建成功，用户信息将保存在数据库中。

#### 登陆
通过浏览器访问localhost:8084/account/login并把用户信息作为参数
> localhost:8084/account/login?name=zhao&password=123

后台会根据用户的信息在数据库中进行查询，并返回相应的登录成功或者是失败的结果。

### TODO服务

#### 添加TODO
访问地址localhost:8080/service/add，参数需要包含执行该add操作的用户名以及TODO的具体信息，例如：
> localhost:8080/service/add?name=zhaozhen&thing=zhangyan&time=2017.6.25

属于用户zhao的一条TODO就成功添加到数据库中。
#### TODO列表
访问地址localhost:8080/service 并加上要查询的账户信息，例如：
> localhost:8080/service?name=zhao 

就可以查询到用户zhao下面所有的TODO，返回结果并在浏览器中显示。
#### 清除TODO
访问地址localhost:8080/service/clear，并加上要清除的账户信息，例如：
> localhost:8080/service/clear?name=zhao 

就可以清除用户zhao的所有的TODO了。

