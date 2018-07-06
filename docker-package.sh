#!/bin/bash
mvn clean package && mvn dockerfile:build -pl docker/acceptor,docker/initiator

