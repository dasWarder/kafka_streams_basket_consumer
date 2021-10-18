FROM maven:3.8.3-openjdk-11-slim
COPY ./ ./home/mvn
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV URL=mongodb+srv://m220student:m220password@mflix.mhcbz.mongodb.net/myFirstDatabase?retryWrites=true&w=majority&serverSelectionTimeoutMS=2000&connectTimeoutMS=2000
ARG PACKAGE=/target/*.jar
COPY $PACKAGE /consumer_basket.jar

ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=${URL}", "/consumer_basket.jar"]