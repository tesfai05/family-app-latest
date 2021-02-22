FROM openjdk:8
EXPOSE 8080
ADD target/family-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]