FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/psd-web-member-0.1.0.jar member.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","member.jar"]



