FROM openjdk:17-slim as build

COPY target/login.jar login.jar

ENTRYPOINT ["java", "-jar", "/login.jar"]

EXPOSE 8080
