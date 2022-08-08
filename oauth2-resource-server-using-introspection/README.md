# Spring OAuth2 Resource Server Using Introspection

本例演示了调用**授权服务器**（比如Keycloak）的introspection endpoint来验签。
本指南只说明差异的部分，其他内容参见[oauth2-resource-server](../oauth2-resource-server)

## 配置资源服务器应用程序
### 引入依赖
在`pom.xml`中引入依赖，除了`spring-boot-starter-oauth2-resource-server`和`spring-boot-starter-security`，还需要引入`oauth2-oidc-sdk`。
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>com.nimbusds</groupId>
  <artifactId>oauth2-oidc-sdk</artifactId>
  <version>8.19</version>
  <scope>runtime</scope>
</dependency>
```

### 指定授权服务器的地址

资源服务器应用程序中配置`client-id`, `client-secret`和`introspection-uri`.
配置示例：
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        opaque-token:
          client-id: mybackend
          client-secret: CLIENT_SECRET
          issuer-uri: http://localhost:8080/realms/myrealm
          introspection-uri: http://localhost:8080/realms/myrealm/protocol/openid-connect/token/introspect
```


## 资源服务器应用程序运行时
资源服务器应用程序根据client id和client secret调用授权服务器的introspection端点（令牌内省）进行验签。

## References

- https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/opaque-token.html

