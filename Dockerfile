FROM openjdk:17-alpine
COPY target/*.jar /usr/src/app.jar
COPY /src/main/resources/data.json /usr/src/data.json
WORKDIR /usr/src
CMD ["java","-jar","app.jar"]