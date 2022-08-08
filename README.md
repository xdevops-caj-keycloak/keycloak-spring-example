# Keycloak Spring Example

## OAuth2 Authorization Code flow

![oauth2_authorization_code_flow](https://www.baeldung.com/wp-content/uploads/2020/08/AuthCodeFlowSequenceDiagram-1.png)

## 集成方式
测试各种Keycloak与Spring的集成方式：
- Spring提供的集成方式
    - Spring OAuth2 Client: `spring-boot-starter-oauth2-client`
    - Spring OAuth2 Resource Server: `spring-boot-starter-oauth2-resource-server`
- Keycloak提供的集成方式
    - Keycloak Spring Boot adapter: `keycloak-spring-boot-starter`
    - Keycloak Spring Security adapter: `keycloak-spring-security-adapter`

### Spring OAuth2 Resource Server

对应上图的Resoruce Server。

适用于Spring Boot应用作为**资源服务器**，且搭配专门的**授权服务器**（比如Keycloak）的场景。


参见：
- [oauth2-resource-server](./oauth2-resource-server)

### Spring OAuth2 Client

对应上图的Client Application，或Client Application + Resource Server。

参见：
- TBD