# Spring OAuth2 Resource Server

## 配置资源服务器应用程序
### 引入依赖
在`pom.xml`中引入依赖：
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### 指定授权服务器的地址

在`application.yaml`中指定授权服务器的地址。

最小的配置只需要指定`spring.security.oauth2.resourceserver.jwt.issuer-uri`

## 在授权服务器中配置

### 在Keycloak中配置
在授权服务器（Keycloak）中配置示例：
1. 创建一个realm: `myrealm`
2. 在`myrealm`下创建一个client：
   - Client ID: `mybackend`
   - Root URL: `http://localhost:8081`
   - Valid redirect URIs: `http://localhost:8081/*`
   - Web origins: `+`
   - Access Type: `Confidential`
   - Authentication flow: `Standard flow`
3. 在在`myrealm`下创建一个User

访问<http://localhost:8080/realms/myrealm/.well-known/openid-configuration>来获取Keycloak endpoints。

其中上面的授权服务器的`issuer-uri`为`http://localhost:8080/realms/myrealm`。


## 资源服务器应用程序启动时
资源服务器应用程序启动时自动：
1. 访问授权服务器（Keycloak）的`jwks_url` (对应Keycloak的`jwks_uri` endpoint: `http://localhost:8080/realms/myrealm/protocol/openid-connect/certs`)
2. 查询所支持的算法
3. 配置验证策略对应找到的算法的有效JWT公钥
4. 配置验证策略以验证公钥颁发者

## 资源服务器应用程序运行时
资源服务器应用程序运行时处理任何包含`Authorization: Bearer access_token`的请求，并使用JWT公钥对access_token直接验签。

资源服务器应用程序也可以调用授权服务器的introspection端点（令牌内省）进行验签，此时还需要在资源服务器应用程序中配置`client-id`, `client-secret`和`introspection-uri`.
配置示例：
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        opaquetoken:
          client-id: mybackend
          client-secret: CLIENT_SECRET
          issuer-uri: http://localhost:8080/realms/myrealm
          introspection-uri: http://localhost:8080/realms/myrealm/protocol/openid-connect/token/introspect
```

## 应用测试

运行资源服务器应用程序：
```bash
mvn spring-boot:run
```

测试访问资源服务器的服务：
1. 使用[oidc-playground](../oidc-playground)工具获取access token
2. 带着access token访问受保护的服务

访问受保护的服务
```bash
# access token
export ACCESS_TOKEN=your_access_token

# curl
curl -v -X GET \
 http://localhost:8081 \
 -H "Authorization: Bearer "$ACCESS_TOKEN

# httpie
http http://localhost:8081 Authorization:"Bearer $ACCESS_TOKEN"

```

## 应用单元测试

TBD

## 应用安全配置

TBD



## References
- https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html