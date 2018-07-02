#!/bin/bash
echo "Force killing server processes"
ps -Aef|grep java.*fixtest|cut -c 10-15|xargs kill -9
