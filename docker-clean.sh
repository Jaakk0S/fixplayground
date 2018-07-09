#!/bin/bash

echo "Warning, this will clean local container store (containerd) AND all running containers!"
read -p "Do you wish to continue? (y/N)" answer
if [[ "y" != $answer ]]; then
	exit 0
fi
docker ps -q|xargs docker rm --force
for repo in \
	750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-initiator \
	750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-acceptor \
	750614674544.dkr.ecr.eu-west-2.amazonaws.com/fixplayground-client\
	; do 
	docker images -q $repo|xargs docker rmi --force
done
