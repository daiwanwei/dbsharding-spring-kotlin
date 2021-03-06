FROM gradle:jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jdk-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/dbsharding-spring-kotlin-0.0.1-SNAPSHOT.jar
CMD exec java $JAVA_OPTS -jar /app/dbsharding-spring-kotlin-0.0.1-SNAPSHOT.jar


