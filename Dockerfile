
FROM openjdk:8-alpine
RUN apk --update add openjdk8-jre
COPY build/libs/dockergradle-1.2.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
