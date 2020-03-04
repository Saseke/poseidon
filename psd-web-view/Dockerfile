FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/psd-web-view-0.1.0.jar view.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","view.jar"]