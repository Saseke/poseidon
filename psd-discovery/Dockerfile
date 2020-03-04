FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/poseidon-eureka-server-0.1.0.jar eureka.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka.jar"]