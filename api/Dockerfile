## This Dockerfile is used to build the Spring Boot application
## without the Angular static files. This is useful if you want to
## develop and run the Angular application locally or in a separate container.

# Build the Spring Boot project, without the Angular static files
FROM gradle:8.5-jdk17-alpine AS GRADLE_BUILD
COPY . /opt/api
WORKDIR /opt/api
RUN ./gradlew build bootJar

# Run the Spring Boot application
FROM openjdk:17-jdk-alpine
COPY --from=GRADLE_BUILD /opt/api/build/libs/*.jar /opt/periodic-table-api.jar
CMD ["/opt/openjdk-17/bin/java", "-jar", "/opt/periodic-table-api.jar"]
EXPOSE 9091