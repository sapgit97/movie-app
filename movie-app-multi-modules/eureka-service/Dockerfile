FROM openjdk:11
ADD ./target/eureka-service-0.0.1-SNAPSHOT.jar /usr/src/eureka-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]