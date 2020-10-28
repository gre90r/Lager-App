#!/bin/sh

##################
# for production #
##################
mvn clean package
java -jar target/LagerApp-1.0-SNAPSHOT.jar

###################
# for development #
###################
#mvn spring-boot:run

## alternatively this one:
#mvn install
#java -jar target/LagerApp-1.0-SNAPSHOT.jar