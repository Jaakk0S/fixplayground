#!/bin/bash
echo "Force killing server processes"
ps -Aef|grep java.*fixplayground|grep -v 'grep'|cut -c 10-15|xargs kill -9
