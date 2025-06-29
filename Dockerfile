FROM openjdk:17-jdk-slim

VOLUME /tmp

EXPOSE 8080

COPY target/sbbtraveller-1.0-SNAPSHOT.jar sbbtraveller.jar

ENTRYPOINT ["java","-jar","sbbtraveller.jar"]