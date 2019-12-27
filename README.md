## 码匠笔记
## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://sprinig.io/guides/gs/serving-web-content/)  
[es](https://elasticsearch.cn/explore)  
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deplay-keys)  
[Bootstrap](https://v3.bootcss.com/getting-started)  
[Github Oauth Documents](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[注册Github oauth App](https://github.com/settings/applications/new)  
[OKHTTP](https://square.github.io/okhttp/)  
[Spring-boot-mybatis](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
[spring-mvc](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web)  
[mabatis-generator](http://mybatis.org/generator/)    
[Markdown 插件](https://pandao.github.io/editor.md/)  


## 工具
[Git](https://git-scm.com/download)  
[Visval Paradigm](https://www.visual-paradigm.com)  
[flyway](https://flywaydb.org/)  
[lombok](https://projectlombok.org/)  
[小图标工具](https://www.iconfont.cn/)
## Spring Boot 注解
@Component  初始化到Spring中，用@AutoWired注入，无需new  
@Value  用于获取Application.properties 中的配置 @Value("${key}")  


## 脚本
``` 备注
logging.level.life.majiang.community.demo.mapper=debug
 打印数据库执行日志 debug 级别
 
 logging.file.max-history=3
 最多纪录三天的日志 与文件超出大小后自动创建的文件数量无关，至于
 日期有关
 
 线上环境
 logging.file.max-size=200MB
 logging.file.max-history=30




```  

```bash
mvn flyway:migrate  
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

```
```备注
markdown 使用图片上传功能需修改 image-dialog.js  
javascript
    var body = (uploadIframe.contentWindow ? uploadIframe.contentWindow : uploadIframe.contentDocument).document.body;
    var jsonContainer = body.getElementsByTagName("pre")[0];
    var json = (jsonContainer.innerText) ? jsonContainer.innerText : ( (jsonContainer.textContent) ? jsonContainer.textContent : null);
```

