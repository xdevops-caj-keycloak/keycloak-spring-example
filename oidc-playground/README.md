# OpenID Connect Playgound

## 配置Keycloak
在Keycloak上`myrealm`下配置一个新的client：
- Client ID: `oidc-playground`
- Access Type: `public`
- Root URL: `http://localhost:8000`
- Valid Redirect URIs: `http://localhost:8000/*`
- Web Origins: `+`

## 运行程序
运行程序：
```bash
npm install
npm start
```


## 访问程序
访问程序：http://localhost:8000/
1. 1-Discovery
    - Load OpenID Provider Configuration
2. 2-Authentication
    - Generate Authentication Request
    - Send Authentication Request
3. 3-Token
    - Send Token Request
    - 在页面最后点击"Copy"按钮复制access token

## 访问受保护的服务
访问受保护的服务：
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