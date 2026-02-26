FROM eclipse-temurin:17
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /demo-0.0.1-SNAPSHOT.jar"]
