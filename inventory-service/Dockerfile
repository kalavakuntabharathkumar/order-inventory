FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn -q -DskipTests package
FROM eclipse-temurin:11-jre
COPY --from=build /app/target/inventory-service-1.0.0.jar /app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]
