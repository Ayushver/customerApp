# Start with a base image containing Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Add Maintainer Info
LABEL maintainer="developer@example.com"

# Make port 8082 available to the world outside this container
EXPOSE 8082

# Set application's JAR file
ARG JAR_FILE=target/customer-app.jar

# Add the application's JAR to the container
COPY ${JAR_FILE} app.jar

# Add Kafka properties if needed for connecting from Docker
ENV KAFKA_HOST=kafka:9092

# Run the jar file with the specified server port
ENTRYPOINT ["java","-jar","-Dserver.port=8082","/app.jar"]