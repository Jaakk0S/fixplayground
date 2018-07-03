#!/bin/bash

function ping {
	pollsecs=30
	port=$1
	for i in `seq 1 ${pollsecs}`; do
		echo "Pinging $port..."
		curl "http://localhost:"$port"/ping" >/dev/null 2>/dev/null && echo "Service up!" && break
		sleep 1
	done
}

mvn clean package || exit 1
. kill.sh
echo "Starting acceptor"
java -Dspring.profiles.active=acceptor -jar target/fixplayground-1.0-SNAPSHOT.jar >log/acceptor.log&
echo "Starting initiator"
java -Dspring.profiles.active=initiator -jar target/fixplayground-1.0-SNAPSHOT.jar >log/initiator.log&
echo "Polling acceptor"
ping 8080
echo "Polling initiator"
ping 8081



