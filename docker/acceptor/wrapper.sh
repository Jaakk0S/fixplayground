#!/bin/bash

websocketd --port 12345 ./sniff.sh >logs/websocketd.log &
java -Dspring.profiles.active=acceptor -Djava.security.egd=file:/dev/./urandom -jar /app.jar
