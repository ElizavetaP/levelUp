FROM openjdk:17-slim

COPY ./target/homework2-1.0.0.jar /app/
WORKDIR /app

CMD ["java", "-jar", "homework2-1.0.0.jar"]

