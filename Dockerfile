FROM openjdk:17-jdk

COPY target/crud-app.jar .

EXPOSE 8082

ENTRYPOINT  ["java", "-jar", "crud-app.jar"]



