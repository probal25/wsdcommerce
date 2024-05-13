FROM openjdk:17-jdk-slim

MAINTAINER Probal <probal25@hotmail.com>

VOLUME /tmp

ADD app.jar app.jar

ADD entrypoint.sh entrypoint.sh

RUN sh -c 'touch /app.jar'

ENTRYPOINT [ "sh", "./entrypoint.sh" ]
