#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests



FROM openjdk:17-alpine
COPY --from=build /target/*.jar /usr/src/app.jar
COPY /src/main/resources/data.json /usr/src/data.json
WORKDIR /usr/src
CMD ["java","-jar","app.jar"]
