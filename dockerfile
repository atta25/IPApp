FROM openjdk:8-jdk-alpine

WORKDIR /opt/app

ARG JAR_FILE=target/spring-boot-crud-exec.jar
# cp spring-boot-crud-exec.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]