#!/bin/bash

echo "Starting acceptor"

ipaddress=`docker run -p 8080:8080 -p 12345:12345 -p 12348:12348 -p 12349:12349 -d 750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-acceptor:latest|xargs docker inspect|grep IPAddress|grep -o "[0-9]*\.[0-9]*\.[0-9]*\.[0-9]*"|head -n 1`

echo "Starting initiator 1"

docker run -p 8081:8080 \
-e "FIXSESSION.BeginString=FIX.4.3" \
-e "FIXSESSION.SenderCompID=Client1" \
-e "FIXSESSION.TargetCompID=ECN-Server-Company" \
-e "FIXSESSION.HeartBtInt=12" \
-e "FIXSESSION.SocketConnectHost=$ipaddress" \
-e "FIXSESSION.SocketConnectPort=12348" \
-d 750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-initiator:latest

echo "Starting initiator 2"

docker run -p 8082:8080 \
-e "FIXSESSION.BeginString=FIX.4.2" \
-e "FIXSESSION.SenderCompID=Client2" \
-e "FIXSESSION.TargetCompID=ECN-Server-Company" \
-e "FIXSESSION.HeartBtInt=15" \
-e "FIXSESSION.SocketConnectHost=$ipaddress" \
-e "FIXSESSION.SocketConnectPort=12349" \
-d 750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-initiator:latest
