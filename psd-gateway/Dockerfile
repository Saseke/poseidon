FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/psd-gateway-0.1.0.jar gateway.jar
EXPOSE 8769
ENTRYPOINT ["java","-jar","gateway.jar"]