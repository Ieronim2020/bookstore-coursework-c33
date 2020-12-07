FROM openjdk:12-jdk-alpine
COPY target/*.jar bookstore-coursework-c33-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "bookstore-coursework-c33-0.0.1-SNAPSHOT.jar"]