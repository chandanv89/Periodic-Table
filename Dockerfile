FROM gradle:8.5-jdk17-alpine AS GRADLE_BUILD
COPY ./api /opt
WORKDIR /opt
RUN /opt/gradlew build bootJar

FROM openjdk:17-jdk-alpine
COPY --from=GRADLE_BUILD /opt/build/libs/*.jar /opt/app.jar
CMD ["/opt/openjdk-17/bin/java", "-jar", "/opt/app.jar"]
EXPOSE 9091