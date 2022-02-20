# Start with base Image containing Java
FROM openjdk:11-slim as build

# Information about who is maintaining
MAINTAINER venkat26naga@gmail.com

# Add Application to the Container
COPY build/libs/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Exceute the application
Entrypoint ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]