# FOO Example

```bash
# access token
export ACCESS_TOKEN=your_access_token

# curl
curl -v -X GET \
 http://localhost:8081/foos/1 \
 -H "Authorization: Bearer $ACCESS_TOKEN"

# httpie
http http://localhost:8081/foos/1 Authorization:"Bearer $ACCESS_TOKEN"
```