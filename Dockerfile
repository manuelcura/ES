FROM maven:3.5.2-jdk-8-alpine AS build
COPY project/ /tmp/
WORKDIR /tmp/
RUN ls
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=0 /tmp/target/es-0.0.1-SNAPSHOT.jar es.jar
ENTRYPOINT ["java","-jar","es.jar"]