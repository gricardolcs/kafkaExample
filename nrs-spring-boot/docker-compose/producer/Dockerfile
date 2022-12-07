FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8088
ARG JAR_FILE=kafka-producer-1.0.0.jar
ADD ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]