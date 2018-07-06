FROM openjdk:8-jdk-alpine
RUN apk --update add bash curl ngrep
RUN mkdir logs
RUN wget https://github.com/joewalnes/websocketd/releases/download/v0.3.0/websocketd-0.3.0-linux_386.zip
RUN unzip websocketd-0.3.0-linux_386.zip -d bin
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
COPY sniff.sh sniff.sh
COPY wrapper.sh wrapper.sh
EXPOSE 8080 12345 12348 12349
ENTRYPOINT ["./wrapper.sh"]
