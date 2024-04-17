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
    * Optional: `{"name", "email", "password", "phone", "dateFormat"}`
    * Returns: `{"userId", "email", "phone", "dateFormat"}`
  * `/products`
    * GET
      * Returns: `{"productId", "description", "currentPrice", "totalSold", "totalEarned"}`
    * POST
      * Required: `{"description", "currentPrice"}`
    * `?productId={productId}`
      * GET
      * PUT
  * `/materials`
    * GET
      * Returns: `{"materialId", "brand", "description", "currentQuantity", "units", "currentCost", "totalPurchased", "totalSpent"}`
    * POST
      * Required: `{"brand", "description", "units", "currentCost"}`
    * `?materialId={materialId}`
      * GET
      * PUT
  * `/recipes`
    * GET 
      * Returns: `{"product", "material", "amount"}`
    * `?productId={productId}`
      * GET
      * `&materialId={materialId}`
        * POST
          * Required: `{"amount"}`
        * PUT