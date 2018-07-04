#!/bin/bash
echo "Warning, this will clean local container store (containerd) AND all running containers!"
read -p "Do you wish to continue? (y/N)" answer
if [[ "y" != $answer ]]; then
	exit 0
fi
docker ps|cut -c -12|grep -v CONTAINER|xargs docker rm --force
docker images|cut -c 41-53|grep -v IMAGE|xargs docker rmi --force
