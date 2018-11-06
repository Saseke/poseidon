FROM java:8-jdk-alpine
VOLUME /tmp
ADD build/libs/gs-spring-boot-docker-0.1.0.jar /opt/jar/
ENTRYPOINT ["java","-jar","/opt/jar/gs-spring-boot-docker-0.1.0.jar"]