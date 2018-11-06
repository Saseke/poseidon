FROM java:8-jdk-alpine
VOLUME /tmp
ADD build/libs/poseidon-eureka-server-0.1.0.jar poseidon-eureka-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/poseidon-eureka-server.jar"]
