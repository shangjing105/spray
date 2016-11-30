# spray-水花头条后台管理

**这里放上几张后台管理的界面**

![login](http://upload-images.jianshu.io/upload_images/2728175-54884ce28bc57ec6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![main](http://upload-images.jianshu.io/upload_images/2728175-35ff6a3536552def.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![123](http://upload-images.jianshu.io/upload_images/2728175-0f9a59de45c1e7f4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## APP下载地址

![图标](http://upload-images.jianshu.io/upload_images/2728175-90fda6375d617e2c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

[https://www.pgyer.com/0qj6](https://www.pgyer.com/0qj6)

    android版可以下载,ios没有签名,暂时不能安装,我也只给自己手机安装一个。

## 1.1 spring boot
我使用的是java的微框架**spring boot**，用于简化spring应用的初始搭建以及开发过程。没有使用配置比较麻烦的**SSM**架构,因为想比于麻烦的SSM架构，spring boot架构可以简化很多配置和没有必要的开发。对于不熟悉spring boot的我建议看下：

<<[Spring Boot——2分钟构建spring web mvc REST风格HelloWorld](http://jinnianshilongnian.iteye.com/blog/1997192)>>

<<[深入学习微框架：Spring Boot](http://blog.csdn.net/zgmzyr/article/details/49837077)>>

 这些都是官网上的程序清单，看完后想必你对spring boot就应该有个了解。

**maven添加**


	<parent>
		<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-parent</artifactId>
    	<version>1.4.0.RELEASE</version>
    </parent>
	<dependencies>
    	<dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-web</artifactId>
    	</dependency>
	</dependencies>



## 1.2 spring data jpa

在spring boot项目里使用的**spring data jpa**来简化对数据库的操作，不将时间消耗在重复的增删查改上。spring data jpa是比较简单**ORM**框架，对ORM技术（如：Hibernate,mybatis,spring data jpa）有过使用的人很快就能上手。

<<[使用 Spring Data JPA 简化 JPA 开发](http://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/)>>

**maven添加**


    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-jpa</artifactId>
        <version>1.10.2.RELEASE</version>
    </dependency>


## 1.3 spring security
上面的两种技术主要是为了简化接口的开发速度，至于**spring security**是安全权限管理，是为了后台管理系统的管理权限认证的，这都是spring boot的集成技术，使用方便，不用自己去开发，现在都流行敏捷开发，使用这些可以加快开发速度。

<<[spring security技术使用](https://spring.io/guides/gs/securing-web/)>>

**maven添加**


		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>


## 1.4 spring thymeleaf
**spring thymeleaf**是前端模板引擎，类似于jsp,freemarker前端模板，是为了更好的渲染前端页面。我这里使用它是为了开发后台的管理界面，有后端开发经验的相比用一下应该也简单。

<< [spring-boot-web-ui及thymeleaf基本使用](http://jishiweili.iteye.com/blog/2095536)>>

**maven添加**


		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>


## 1.5.MySQL

	数据库使用mysql,这个没什么介绍的。主要是设计数据库的结构，完成数据存储。
    也可以使用其他数据库：oracle,mongodb等。

## 1.6APP技术文章解析

    我会在我的博客里更新关于我这个APP的开发过程,有兴趣的可以下载APP试用一下,有需要的欢迎给我来信。

博客:[www.shuihua.me](www.shuihua.me)

邮箱:[shangjing105@163.com](shangjing105@163.com)
