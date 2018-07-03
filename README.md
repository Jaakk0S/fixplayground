# fixplayground

A FIX protocol demo with Java+QuickFIX/J+Spring Boot. Jaakko Saaristo 2018

- Creates two local Spring Boot (Tomcat) services for
  - FIX Initiator (investment manager, buyer), and
  - FIX Acceptor (execution broker, seller).
- The services communicate in raw FIX using the local port 12349
- Initiator provides a REST interface to send commands over a REST client

## Prerequisites

- Linux
- Maven 3
- Ports 8080, 8081 free
  - Edit application-x.properties to change port
- Port 12349 free
  - Edit settings-x.properties to change port
 
## Just building

    mvn clean package

Will produce a single jar under target/. Running initiator/acceptor uses Spring profiles.

## Building and running

    ./compile-and-run.sh

This will:
- Build
- Kill the local services if they're already up
- Start the services and wait them to come online

## Using the initiator over REST

    /ping
    /           command=test   send TestReq
    /fieldname  code=CODE      return field name for CODE

## Sniffing the port for raw FIX traffic

Prereq: install 'ngrep'

    sudo ngrep -d any -P '|' port 12349

