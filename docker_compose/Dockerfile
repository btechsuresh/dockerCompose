FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#workspace and also add modules 
WORKDIR /a/b/c

#ADD/COPY .jar under target from host
#into this image

ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

#ADD suite files
ADD book-flight-module.xml              book-flight-module.xml
ADD searchmodule.xml                    searchmodule.xml

#COPYING and RUNNING HEALTHCHECK
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh healthcheck.sh