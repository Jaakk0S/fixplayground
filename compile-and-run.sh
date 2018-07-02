#!/bin/bash

function ping {
	pollsecs=30
	port=$1
	for i in `seq 1 ${pollsecs}`; do
		echo "Pinging $port..."
		curl "http://localhost:"$port"/ping" >/dev/null 2>/dev/null && echo "Server up!" && break
		sleep 1
	done
}

mvn clean package || exit 1
. kill.sh
echo "Kicking up server"
java -Dspring.profiles.active=server -jar target/fixtest-1.0-SNAPSHOT.jar >/dev/null&
echo "Kicking up client"
java -Dspring.profiles.active=client -jar target/fixtest-1.0-SNAPSHOT.jar >/dev/null&
echo "Polling server"
ping 8080
echo "Polling client"
ping 8081



