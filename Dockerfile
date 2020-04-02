FROM maven:3.6.3-jdk-8-slim as build
COPY ./ /usr/maven
WORKDIR /usr/maven
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=build /usr/maven/target/kafka-demo-0.0.1-SNAPSHOT.jar /usr/app/kafka-demo-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","kafka-demo-0.0.1-SNAPSHOT.jar"]