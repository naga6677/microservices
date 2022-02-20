# Start with base Image containing Java
FROM openjdk:11-slim as build

# Information about who is maintaining
MAINTAINER venkat26naga@gmail.com

# Add Application to the Container
COPY build/libs/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

# Exceute the application
Entrypoint ["java","-jar","/loans-0.0.1-SNAPSHOT.jar"]