FROM eclipse-temurin:17-jdk-alpine

# Copy the generated JAR into the container root directory
COPY target/booking-Service-0.0.1-SNAPSHOT.jar /bookingservice.jar

# Run the service using absolute path to ensure correct startup
ENTRYPOINT ["java", "-jar", "/bookingservice.jar"]
