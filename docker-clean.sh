#!/bin/bash
echo "Warning, this will clean local container store (containerd) AND all running containers!"
read -p "Do you wish to continue? (y/N)" answer
if [[ "y" != $answer ]]; then
	exit 0
fi
docker ps -q|xargs docker rm --force
docker images -q|xargs docker rmi --force
