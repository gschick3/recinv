# cURL Requests
## General
### Basics
This starts every cURL request
```shell
curl -X [GET|POST|PUT|DELETE] "localhost:8080/[path]" ...
```
### Accepting data
Required any time you expect to receive data
```shell
... -H 'Accept: application/json' ... | jq
```
### Posting data
Required any time you are sending data
```shell
... -H 'Content-type: application/json' ... -d {"fieldName1": "value", ...}
```
### Authentication
Required any time you try to access something under `/users/{userId}`
```shell
... -H "Authorization: Bearer $(echo $RESPONSE | jq -r '.accessToken')" ...
```
### Registration
```shell
... POST ".../auth/register" ... -d '{"name": "your name", "email": "your_email@email.com", "password": "your_password"}' ... 
```
### Login
```shell
RESPONSE=$(curl -s -X POST "localhost:8080/auth/login" -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"email": "johndoe@email.com", "password": "jdpassword"}' | jq)
```
## User
### GET user
```shell
... GET ".../users/$(echo $RESPONSE | jq -r '.userId')" ...
```
## Products
### POST new product
```shell
... POST ".../users/$(echo $RESPONSE | jq -r '.userId')/products/new" [HEADERS] -d '{"description": "product description", "currentPrice": 12}' ...
```
