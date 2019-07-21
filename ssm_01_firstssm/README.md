搭建一个基本的springmvc项目

#### 1.1创建一个maven项目
new Project->maven->选择模板maven-archetype-webapp

#### 1.2修改项目目录

在main目录下创建一个java目录和resource目录，并将java目录设置为Source Folders
将resource目录设置为Resouce Folders

#### 1.3项目部署到tomcat
注意，这里一定要把项目加入到tomcat中去，在Deployment中配置，否则会报`The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.`
资源找不到错误。
#### 1.4导入jar包依赖
导入springmvc的jar包
```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.1.1.RELEASE</version>
    </dependency>
<!--servlet依赖包    -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>
```

#### 1.5配置web.xml文件
在文件中加入
```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  
</web-app>
```

#### 1.6添加springmvc.xml文件(spring的配置文件)








