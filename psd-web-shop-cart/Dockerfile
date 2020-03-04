FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/psd-web-shop-cart-0.1.0.jar cart.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","cart.jar"]