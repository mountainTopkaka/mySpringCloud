# useGitee

#### 介绍
##### 一、基础服务
+ 1、创建eureka_server
    http://localhost:8010
+ 2、创建service_producer_a
    启动eureka、启动servicep_producer_a，查看时候注册到服务 
    http://localhost:8811/baseProducer/hi?id=jack
+ 3、创建service_consumer_feign，配置具体fei
    通过feign访问即可
    http://localhost:8911/hi?id=jack
##### 二、负载均衡
+1.1 、基于Feign的负载均衡
    创建service_producer_b所有配置同a一样，端口改成8812即可
+1.2 、访问feign，feign的服务端会自动轮询调用服务a和b的。两个服务就交替实现，实现负载  
    http://localhost:8911/hi?id=123
  
+2 、 基于ribbon的负载均衡,创建ribbon，配置并访问 
    http://localhost:8912/hi?id=123
+3 、ribbon/feign是对服务之间调用做负载，是服务之间的负载均衡

 
---  
feign对比ribbon：

Ribbon是一个基于HTTP和TCP客户端的负载均衡器，
Feign其实也使用了ribbon, 只要使用@FeignClient时，ribbon就会自动使用。

所以使用Feign是一个采用基于接口的注解的编程方式，更加简便。
    
#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
