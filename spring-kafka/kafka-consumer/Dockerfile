FROM adoptopenjdk/openjdk11:alpine
ADD build/libs/kafka-consumer-0.0.1-SNAPSHOT.jar app.jar
CMD java $JAVA_OPTS -jar app.jar