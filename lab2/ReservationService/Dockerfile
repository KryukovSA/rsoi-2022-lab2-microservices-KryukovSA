FROM openjdk:19
RUN mkdir /app
WORKDIR app
EXPOSE 8070
ARG JAR_FILE=build/libs/ReservationService.jar
COPY ${JAR_FILE} reservation.jar
ENTRYPOINT ["java","-jar","/app/reservation.jar"]