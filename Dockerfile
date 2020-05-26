From openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Work directory in container
WORKDIR /usr/share/selenium_docker

#Adding jars to run
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs	libs

#Add suites files
ADD book-flight-module.xml	book-flight-module.xml
ADD search-module.xml	search-module.xml

#Add healthchek.sh file
ADD healthcheck.sh  healthcheck.sh

# Provide Param variable in entrypoint
#BROWSER
#HUB_HOST
#MODULE

ENTRYPOINT sh healthcheck.sh
