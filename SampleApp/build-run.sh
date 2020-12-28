#!/bin/sh
mvn clean package && docker build -t jasanishubh123/SampleApp .
docker rm -f SampleApp 2>/dev/null || true && docker run -it --name SampleApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name SampleApp jasanishubh123/SampleApp
