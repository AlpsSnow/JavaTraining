# Maven

### 用Maven构建Java项目
Maven 使用原型 archetype 插件创建项目。要创建一个简单的 Java 应用，我们将使用 maven-archetype-quickstart 插件.

### Maven仓库
Maven 仓库能帮助我们管理构件（主要是JAR），它就是放置所有JAR文件（WAR，ZIP，POM等等）的地方。

Manven仓库有三种类型：  
* 本地  
Maven 的本地仓库，在安装 Maven 后并不会创建，它是在第一次执行 maven 命令的时候才被创建。
* 中央  
Maven 中央仓库是由 Maven 社区提供的仓库，其中包含了大量常用的库。
* 远程  
它是开发人员自己定制仓库，包含了所需要的代码库或者其他工程中用到的 jar 文件。

Maven 依赖搜索顺序：  
当我们执行Maven构建命令时，Maven开始按照以下顺序查找依赖的库

* 步骤 1 － 在本地仓库中搜索，如果找不到，执行步骤 2，如果找到了则执行其他操作。
* 步骤 2 － 在中央仓库中搜索，如果找不到，并且有一个或多个远程仓库已经设置，则执行步骤 4，如果找到了则下载到本地仓库中以备将来引用。
* 步骤 3 － 如果远程仓库没有被设置，Maven 将简单的停滞处理并抛出错误（无法找到依赖的文件）。
* 步骤 4 － 在一个或多个远程仓库中搜索依赖的文件，如果找到则下载到本地仓库以备将来引用，否则 Maven 将停止处理并抛出错误（无法找到依赖的文件）。

### 仓库的配置
1. 本地仓库不需要配置：Maven的settings.xml 文件中定义本地仓库的位置
```xml
<settings>
    <localRepository>D:/MyMavenLocalRepository</localRepository>
</settings>
```
2. 中央仓库不需要配置。要浏览中央仓库的内容，maven社区提供了一个URL：http://search.maven.org/#browse  
3. 远程仓库（也成为个别仓库）配置：POM.xml中<repositories>节点定义多个远程仓库  
举例说明，使用下面的 pom.xml，Maven 将从远程仓库中下载该pom.xml 中声明的所依赖的（在中央仓库中获取不到的）文件。
```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.wangxing</groupId>
    <artifactId>MavenProject1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
      <dependency>
         <groupId>com.companyname.common-lib</groupId>
          <artifactId>common-lib</artifactId>
          <version>1.0.0</version>
       </dependency>
    <dependencies>
      <repositories>
         <repository>
            <id>companyname.lib1</id>
            <url>http://download.companyname.org/maven2/lib1</url>
         </repository>
         <repository>
            <id>companyname.lib2</id>
            <url>http://download.companyname.org/maven2/lib2</url>
          </repository>
     </repositories>
</project>
```
### Maven国内镜像（中央中央）的配置
Maven中央仓库默认在国外，国内使用难免很慢，我们可以更换为阿里云的仓库。 中央仓库只能有一个(`<mirrorOf>central</mirrorOf>`)   
可以通过Maven的settings.xml和POM.xml定义国内镜像源  
1. Maven的settings.xml追加<mirror>节点
```xml
<settings>
  <mirrors>
     <mirror>
        <id>alimaven</id>
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        <mirrorOf>central</mirrorOf>
     </mirror>
  </mirrors>
</settings>
```
如果阿里云使用不了，我们可以更换别的镜像：https://blog.csdn.net/Hello_World_QWP/article/details/82459915

### Maven 生命周期
### Maven 创建Springboot服务
参考：https://blog.csdn.net/lom9357bye/article/details/69677120