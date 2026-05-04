# Step 1: Use a "Base Image" that already has Java installed
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Create a folder inside the container for our app
WORKDIR /app

# Step 3: Copy the JAR file we created earlier into the container
COPY target/*.jar app.jar

# Step 4: Tell the container to open port 8080 (where our app lives)
EXPOSE 8080

# Step 5: The command to actually start the app inside the container
ENTRYPOINT ["java", "-jar", "app.jar"]