## Pre-requisite
Start the MySQL Docker to Docker Desktop
Run OpenZipkin

## URL
Currency Exchange Service
http://localhost:8000/v1/currency-exchange/from/USD/to/PHP

Currency Conversion Service
http://localhost:8000/v1/currency-exchange/from/USD/to/PHP/quantity/10

### Response Structure
{
    "id":10001,
    "from":"USD",
    "to":"INR",
    "conversionMultiple":65.00,
    "environment":"8000 instance-id"
}

## Swagger / API documentation
http://localhost:8000/swagger-ui/index.html

## DB
http://localhost:8000/h2-console

## Eureka Repo
https://github.com/princessLaion/naming-server
http://localhost:8761

# Distributed Tracing
Pre requisite, open/run the docker
https://hub.docker.com/r/openzipkin/zipkin
command: docker run -d -p 9411:9411 openzipkin/zipkin
Download the docker image zipkin

Distributed Tracing Client
http://localhost:9411/zipkin/






