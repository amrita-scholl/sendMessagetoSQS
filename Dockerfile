# Use an official OpenJDK base image with a specific version
FROM openjdk:17

FROM maven:3.8.3-openjdk-17 as MAVEN

# Set the working directory in the container
WORKDIR /app

CMD ["mvn clean install"]

# Copy the JAR file of your Java application to the container
COPY target/sendMessagetoSQS-0.0.1-SNAPSHOT.jar .

# Expose the port on which your application listens (if applicable)
EXPOSE 8080

# Define the command to run your Java application
CMD ["java", "-jar", "sendMessagetoSQS-0.0.1-SNAPSHOT.jar"]
