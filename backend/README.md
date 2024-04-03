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
_See [CURLS.md](./CURLS.md)_

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
  * `/products`
    * GET
      * Returns: `{"user", "description", "currentPrice", "totalSold", "totalEarned"}`
    * POST
      * Expects:
        * Required: `{"description", "currentPrice"}`
        * Optional: `{"totalSold", "totalEarned"}`
    * `/{productId}`
      * GET
      * PUT