#!/bin/sh
#deploy="false"
deploy="true"

image=SampleApp
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t jasanishubh123/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push jasanishubh123/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag jasanishubh123/${image}:1.0-SNAPSHOT jasanishubh123/${image}:latest
        docker push jasanishubh123/${image}:latest
    fi
fi