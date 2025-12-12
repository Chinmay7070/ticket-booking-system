FROM eclipse-temurin:17-jdk-alpine

# Copy the generated JAR into the container root directory
COPY target/movie-services-registry-0.0.1-SNAPSHOT.jar /registry.jar

# Run the service using absolute path to ensure correct startup
ENTRYPOINT ["java", "-jar", "/registry.jar"]
