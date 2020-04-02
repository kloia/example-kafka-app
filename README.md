# Example Spring Boot app with PostgreSQL DB and Kafka 

### Requirements

docker

docker-compose


## How to use?

Simply,

`docker-compose up`

This command will build source code and run postgres and kafka. You can call:
 
 `/addBook?book=example` endpoint to add books,
 
 `/sendBook?book=example` endpoint to send and recieve books through kafka.
 
All books will be written to Postgres and all "send" calls reads books from DB and send and receive book object through kafka.

## Deployment

You can build image with:

`docker build . -t kafka-demo`

<br/>

#### Application will look for Postgres with config:

address: "postgres:5432"

user: "postgres"

password: "password"

<br/>

#### Application expects Kafka with config:

address: "kafka:9092"

topic: "book" (If auto-create enabled, application will create topic for you)
 