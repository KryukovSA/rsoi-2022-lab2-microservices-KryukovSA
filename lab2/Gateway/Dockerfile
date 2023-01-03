FROM openjdk:19
RUN mkdir /app
WORKDIR app
EXPOSE 8080
ARG JAR_FILE=build/libs/Gateway.jar
#ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java","-jar","/app/gateway.jar"]