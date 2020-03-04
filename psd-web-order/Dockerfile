FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/psd-web-order-0.1.0.jar order.jar
EXPOSE 9100
ENTRYPOINT ["java","-jar","order.jar"]

