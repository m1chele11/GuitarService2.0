FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/C322-Homework2-0.0.1-SNAPSHOT.jar Homework2.jar
ENTRYPOINT ["java", "-jar", "Homework2.jar"]
