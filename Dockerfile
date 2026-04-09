# Option 1: Construir dentro de docker

FROM maven:3.9-eclipse-temurin-21-alpine
# Usa una imagen base que ya incluye Maven y Java 21 (ligera por ser Alpine)

WORKDIR /app
# Define el directorio de trabajo dentro del contenedor como /app

COPY pom.xml .
# Copia el archivo pom.xml desde tu máquina al contenedor (ruta actual /app)

COPY src ./src
# Copia el código fuente (carpeta src) al contenedor dentro de /app/src

RUN mvn clean package -DskipTests

ENTRYPOINT ["java", "-jar", "target/WalmartApi-0.0.1-SNAPSHOT.jar"]
# Define el comando que se ejecutará al iniciar el contenedor (ejecuta el JAR)
