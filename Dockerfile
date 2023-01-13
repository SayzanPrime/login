FROM openjdk:17-alpine AS build

WORKDIR /app

COPY . /app

RUN ./mvnw clean package -Dmaven.test.skip=true

FROM openjdk:17-alpine

COPY --from=build /app/target/spring-demo.jar spring-demo.jar

ENTRYPOINT ["java", "-jar", "/login.jar"]

EXPOSE 8080