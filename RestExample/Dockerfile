FROM maven:latest as build
COPY . .
RUN mvn clean isntall -DskipTests=true


FROM openjdk:latest
COPY --from=build /target/RestExample-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "RestExample-0.0.1-SNAPSHOT.jar"]

