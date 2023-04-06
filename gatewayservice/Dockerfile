FROM openjdk:17-alpine

# Set the name of the jar
ENV APP_FILE gatewayservice-0.0.1-SNAPSHOT.jar

# Copy our JAR
COPY target/$APP_FILE /app.jar

# Launch the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar" ]