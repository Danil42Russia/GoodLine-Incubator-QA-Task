FROM ubuntu

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV APP_HOME=/home/test
RUN mkdir -p $APP_HOME

WORKDIR $APP_HOME

COPY gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY build.gradle $APP_HOME

ADD src $APP_HOME/src
RUN ./gradlew test