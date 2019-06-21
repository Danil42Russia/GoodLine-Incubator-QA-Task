FROM gradle:5.4.1-jdk8

ENV APP_HOME=/home/test

RUN mkdir -p $APP_HOME
COPY . $APP_HOME
WORKDIR $APP_HOME

USER root
RUN chown -R gradle $APP_HOME
USER gradle
RUN ./gradlew test