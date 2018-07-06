# fixplayground

A FIX protocol demo with Java+QuickFIX/J+Spring Boot+Docker+React. Jaakko Saaristo 2018

- Simulates FIX by creating an Acceptor (execution broker, seller) and Initiator (investment manager, buyer) services
- The services communicate in raw FIX
- The services are Spring Boot applications running in Docker containers
- Acceptor actively outputs the traffic in its FIX ports to a websocket
- Initiator provides a REST interface to send commands over a REST client
- React GUI

## Prerequisites

- Linux
- Maven 3
- Docker
- Node
- NPM
 
## Building Spring Boot jar

    mvn clean package

Will produce a single jar under target/. Running initiator/acceptor uses Spring profiles.

## Building Docker containers

    ./docker-package.sh

This will build and produce 2 docker containers

## Running Docker containers

    ./docker-run.sh

This will start 3 containers with the respective environment. They will be bound to
- 8080: acceptor
- 8081: initiator1
- 8082: initiator2

The initiators have different settings.

## Using the initiator over REST

    /ping
    /           command=test   send TestReq
    /fieldname  code=CODE      return field name for CODE

## Configuring

Check the files

    core/src/main/resources/*.properties 
    docker-run.sh

The FIX session settings (in settings-[acceptor|initiator].properties) can be overridden by passing the container environment variables FIXSETTING.name=value.
