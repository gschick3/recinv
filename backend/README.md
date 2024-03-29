# Recinven Backend

## Table of Contents
<!-- TOC -->
* [Recinven Backend](#recinven-backend)
  * [Table of Contents](#table-of-contents)
  * [Application Properties](#application-properties)
  * [Setup](#setup)
    * [Environmental Variables](#environmental-variables)
  * [Example Requests](#example-requests)
  * [API Endpoints](#api-endpoints)
<!-- TOC -->

## Application Properties
* host: `localhost`
* port: `8080`

## Setup
### Environmental Variables
* `RECINVEN_DB_USERNAME`: Neon DB username
* `RECINVEN_DB_PASSWORD`: Neon DB password

## Example Requests
> **NOTE:** These examples are using `cURL`, a simple command line tool for making requests
1. Register under new `email` (with optional phone number)
    ```shell
    curl -X POST localhost:8080/auth/register -H 'Content-Type:application/json' -d '{"name": "john doe", "email": "johndoe@email.com", "password": "jdpassword"}' | jq
    ```
2. Login with `email` and `password`, and store the response data that is sent back
    ```shell
    RESPONSE=$(curl -s -X POST localhost:8080/auth/login -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"email": "johndoe@email.com", "password": "jdpassword"}' | jq)
    ```
3. Use returned `userId` along with `accessToken` to grab user data
    ```shell
    curl -X GET "localhost:8080/users/$(echo $RESPONSE | jq -r '.userId')" -H "Authorization: Bearer $(echo $RESPONSE | jq -r '.accessToken')" -H 'Accept: application/json' | jq
    ```
4. Example: Change `password`
    ```shell
    curl -X PUT "localhost:8080/users/$(echo $RESPONSE | jq -r '.userId')" -H "Authorization: Bearer $(echo $RESPONSE | jq -r '.accessToken')" -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"password": "jdpassword_new"}' | jq
    ```

## API Endpoints
* `/auth`
  * `/login`
    * Expects: `{"email", "password"}`
    * Returns: `{"userId", "accessToken"}`
  * `/register`
    * Expects:
      * Required: `{"name", "email", "password"}`
      * Optional: `{"phone", "dateFormat"}`
    * Returns: `{"userId", "email", "phone", "dateFormat"}`
* `/users/{userId}`
  * GET
    * Returns: `{"userId", "email", "phone", "dateFormat"}`
  * PUT
    * Expects:
      * Optional: `{"name", "email", "password", "phone", "dateFormat"}`
    * Returns:
      * `{"userId", "email", "phone", "dateFormat"}`