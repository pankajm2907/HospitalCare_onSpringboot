# Use Java image
FROM openjdk:24-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file into container
COPY target/*.jar app.jar

# Expose port
EXPOSE 8084

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
