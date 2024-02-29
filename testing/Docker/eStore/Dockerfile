# Base Image JDK
FROM openjdk:17

# Lets Create an Argument which specifies the .jar file location
ARG JAR_FILE=target/*.jar

# Copy eStore-0.0.1-SNAPSHOT.jar as estore.jar
COPY ${JAR_FILE} estore.jar

# Execute the .jar file
ENTRYPOINT ["java", "-jar", "/estore.jar"]
