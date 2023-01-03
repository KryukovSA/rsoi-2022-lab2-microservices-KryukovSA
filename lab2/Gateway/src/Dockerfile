FROM openjdk:19
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
COPY build/libs/gateway.jar gateway.jar
ENTRYPOINT ["java","-jar","./gateway.jar"]