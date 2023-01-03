FROM openjdk:19
EXPOSE 8070
ARG JAR_FILE=build/libs/ReservationService.jar
COPY ${JAR_FILE} reservation.jar
ENTRYPOINT ["java","-jar","./reservation.jar"]