#!/bin/bash

ipaddress=`docker run -p 8080:8080 -p 12349:12349 -d 750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-acceptor:latest|xargs docker inspect|grep IPAddress|grep -o "[0-9]*\.[0-9]*\.[0-9]*\.[0-9]*"|head -n 1`
docker run -p 8081:8080 -e "ACCEPTOR_IP=$ipaddress" -d 750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-initiator:latest
docker exec -it `docker ps|grep acceptor|cut -c -12` /bin/bash
