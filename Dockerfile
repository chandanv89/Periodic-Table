# Build the Angular project
FROM node:latest AS NODE_BUILD
COPY ./ui /opt/ui
WORKDIR /opt/ui
RUN npm ci
RUN npm run build

# Build the Spring Boot project, with the Angular static files
FROM gradle:8.5-jdk17-alpine AS GRADLE_BUILD
COPY ./api /opt/api
COPY --from=NODE_BUILD /opt/ui/dist/periodic-table /opt/api/src/main/resources/static
WORKDIR /opt/api
RUN ./gradlew build bootJar

# Run the Spring Boot application
FROM openjdk:17-jdk-alpine
COPY --from=GRADLE_BUILD /opt/api/build/libs/*.jar /opt/periodic-table-app.jar
CMD ["/opt/openjdk-17/bin/java", "-jar", "/opt/periodic-table-app.jar"]
EXPOSE 9091