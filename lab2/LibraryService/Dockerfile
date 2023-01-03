FROM openjdk:19
RUN mkdir /app
WORKDIR app
EXPOSE 8060
ARG JAR_FILE=build/libs/LibraryService.jar
#ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} library.jar
ENTRYPOINT ["java","-jar","/app/library.jar"]