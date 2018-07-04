FROM openjdk:8-jdk-alpine
RUN apk --update add bash
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
EXPOSE 8081
ENTRYPOINT ["java","-Dspring.profiles.active=initiator", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
