FROM openjdk:19
RUN mkdir /app
WORKDIR app
EXPOSE 8050
ARG JAR_FILE=build/libs/RatingService.jar
#ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rating.jar
ENTRYPOINT ["java","-jar","/app/rating.jar"]