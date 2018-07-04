FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
EXPOSE 8081 12349
ENTRYPOINT ["java","-Dspring.profiles.active=initiator:-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
