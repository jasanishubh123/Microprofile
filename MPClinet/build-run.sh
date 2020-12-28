#!/bin/sh
mvn clean package && docker build -t jasanishubh123/MPClinet .
docker rm -f MPClinet 2>/dev/null || true && docker run -it --name MPClinet -p 8080:8080 -p 4848:4848 -p 8181:8181 --name MPClinet jasanishubh123/MPClinet
