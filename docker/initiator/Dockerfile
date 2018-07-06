FROM openjdk:8-jdk-alpine
RUN apk --update add bash curl ngrep
RUN mkdir logs
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=initiator", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
