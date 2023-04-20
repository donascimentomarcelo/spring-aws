## Overview

An example project to demonstrate:

* how to create a Spring Boot REST API
* how to run Spring Boot in Docker and publish to Docker Hub
* how to deploy the Spring Boot application to AWS with CloudFormation

## Pre-requisites

* JDK 11+
* Docker

## Building

### Testing

`./gradlew test`

### Building (no tests)

`./gradlew assemble`

### Building (with tests)

`./gradlew build`

### Running in Docker

`./gradlew assemble docker dockerRun`

### Stopping Docker container

`./gradlew dockerStop`

### Deploying to AWS

`./gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=<your-subnet-id> -Pregion=<your-region>`

### Deleting AWS deployment

`./gradlew awsCfnDeleteStack awsCfnWaitStackComplete`

## Using API

* get all products - GET [/api/products](http://localhost:8080/product) to get a list of all the products
* get specific product - GET [/api/products/${id}](http://localhost:8080/products/1) to get a specific product

## Need further support?
Contact me if you need help at marcelo.laravel@gmail.com.