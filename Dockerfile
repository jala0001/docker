# Brug en baseimage med Java
FROM openjdk:17-jdk-slim

# Angiv arbejdsmappen i containeren
WORKDIR /app

# Kopier .jar-filen til containeren
COPY target/your-app.jar app.jar

# Eksponér port 8080
EXPOSE 8080

# Start applikationen
CMD ["java", "-jar", "app.jar"]
