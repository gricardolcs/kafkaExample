FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8087
ARG JAR_FILE=kafka-consumer-1.0.0.jar
ADD ${JAR_FILE} consumer.jar
ENTRYPOINT ["java","-jar","/consumer.jar"]
