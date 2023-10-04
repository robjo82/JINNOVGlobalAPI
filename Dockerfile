FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace/app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=builder /workspace/app/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
