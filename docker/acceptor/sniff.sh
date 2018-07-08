#!/bin/bash

ngrep -d any -c 1000 -P '|' port 12348 or port 12349
