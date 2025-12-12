FROM eclipse-temurin:17-jdk-alpine

# Copy the generated JAR into the container root directory
COPY target/payment_sservice-0.0.1-SNAPSHOT.jar /paymentservice.jar

# Run the service using absolute path to avoid class loading errors
ENTRYPOINT ["java", "-jar", "/paymentservice.jar"]
