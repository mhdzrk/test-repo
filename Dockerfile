FROM openjdk:11-jre-alpine

EXPOSE 8080

COPY ./build/libs/session-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "session-0.0.1-SNAPSHOT.jar"]
