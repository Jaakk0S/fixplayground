#!/bin/bash

echo "Warning, this will clean local container store (containerd) AND all running containers!"
read -p "Do you wish to continue? (y/N)" answer
if [[ "y" != $answer ]]; then
	exit 0
fi
docker ps -a -q|xargs docker rm --force
docker images -a | grep "fixplayground\|<none>" | awk '{print $3}' | xargs docker rmi 
