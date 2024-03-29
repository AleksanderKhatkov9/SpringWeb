# SpringWeb

## Building web applications Spring Web
<uL>
  <li>Spring Boot v2.1.3 </li>
  <li>MySQL 8.0</li>
  <li>Hibernate</li>
  <li>Thymeleaf</li>
</ul>

## Connection Spring Boot to MySQL
<p> Add dependency to file <b>application.properties</b> </p>

<ol>
<li>spring.datasource.url=jdbc:mysql://localhost:3306/spring_web?serverTimezone=UTC&characterEncoding=utf-8</li>
<li>spring.datasource.username=root</li>
<li>spring.datasource.password=sa@12345#</li>
<li>>spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect</li>
<li>spring.jpa.hibernate.ddl-auto=update</li>
</ol>

## We write the dependency in the project file


  <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
		http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>net.codejava</groupId>
    <artifactId>ProductManager</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.3.RELEASE</version>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.15</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.19.RELEASE</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

<hr></hr>

![image](https://user-images.githubusercontent.com/74569011/162929385-28f0e468-c511-4501-8fed-6060b2c96c82.png)



 
