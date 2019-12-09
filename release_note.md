1. pom.xml 中 exclusions 标签排除掉内置tomcat。引入javax.servlet-api依赖
2. application.yml 要配置使用 application.prod
3. mvn clean package 打包
4. blog-0.0.1-SNAPSHOT.war 改名为 blog.war。上传到 /usr/local/workspace_java/apache-tomcat-8.5.49/webapps
5. localhost:8080/blog/download 访问服务

TODO:
1. 怎么配置在开发环境就不用内置tomcat
2. 怎样在mvn打包时，自动采用prod，而开发是自动选用dev
3. 配置线上tomcat，使用虚拟路径。指定某个端口、路由（ip:port/a）访问 blog-0.0.1-SNAPSHOT.war 里面的服务