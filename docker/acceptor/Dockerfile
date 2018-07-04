#FROM localhost:5000/fixplayground-core
EXPOSE 8080 12349
ENTRYPOINT ["java","-Dspring.profiles.active=acceptor:-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
