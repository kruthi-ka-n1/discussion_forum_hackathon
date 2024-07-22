# Stage 1: Build Angular frontend
FROM node:14.17.1-alpine as build-frontend

WORKDIR /app

# Copy frontend source code to container
COPY src/main/frontend .

# Install dependencies and build the Angular app
RUN npm install
RUN npm run build --prod

# Stage 2: Build Spring Boot backend
FROM gradle:6.8.3-jdk8 as build-backend

WORKDIR /app

# Copy the Gradle wrapper and project files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Build backend using Gradle
RUN ./gradlew build -x test

# Stage 3: Combine frontend and backend into a single container
FROM openjdk:8-jre-alpine

WORKDIR /app

# Copy the built JAR file from build-backend
COPY --from=build-backend /app/build/libs/*.jar /app/app.jar

# Copy the built Angular app from build-frontend to serve as static content
COPY --from=build-frontend /app/dist /app/src/main/resources/static

# Expose port 8080 (default for Spring Boot apps)
EXPOSE 8080

# Default command to run: start Spring Boot app
CMD ["java", "-jar", "/app/app.jar"]
