FROM maven:3.8.2-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-alpine
COPY --from=build /target/*.jar /usr/src/app.jar
COPY /src/main/resources/data.json /usr/src/data.json
COPY /src/main/resources/user.json /usr/src/user.json
WORKDIR /usr/src
CMD ["java","-jar","app.jar"]
