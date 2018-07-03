#!/bin/bash

logdir=`find src -name settings-acceptor.properties|xargs grep FileLogPath|cut -d '=' -f 2`
jarfile=`find target/ -name "fixplayground*jar"|head -n 1`
if [ ! -d $logdir ]; then
	mkdir $logdir
fi

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
java -Dspring.profiles.active=acceptor -jar $jarfile >$logdir/acceptor.log&
echo "Starting initiator"
java -Dspring.profiles.active=initiator -jar $jarfile >$logdir/initiator.log&
echo "Polling acceptor"
ping 8080
echo "Polling initiator"
ping 8081



