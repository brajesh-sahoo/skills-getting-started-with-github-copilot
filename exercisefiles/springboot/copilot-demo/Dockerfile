# Build a java application image based on Alpine Linux with JRE 17 for minimal memory footprint
FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xmx128m","-Xms64m","-XX:+UseSerialGC","-XX:ActiveProcessorCount=1","-jar","/app.jar"]
