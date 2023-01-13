FROM openjdk:17-slim AS build

WORKDIR /app

COPY . /app

RUN ./mvnw clean package

FROM openjdk:17-slim

COPY --from=build /app/target/login.jar login.jar

ENTRYPOINT ["java", "-jar", "/login.jar"]

EXPOSE 8080
