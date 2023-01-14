FROM maven:latest AS MAVEN_BUILD

WORKDIR /app

COPY . /app

RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-alpine

COPY --from=MAVEN_BUILD /app/target/login.jar login.jar

ENTRYPOINT ["java", "-jar", "/login.jar"]

EXPOSE 8080