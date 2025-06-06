FROM openjdk:17-jdk-slim

VOLUME /tmp

COPY target/sbbtraveller-0.0.1-SNAPSHOT.jar sbbtraveller.jar

ENTRYPOINT ["java","-jar","/sbbtraveller.jar"]