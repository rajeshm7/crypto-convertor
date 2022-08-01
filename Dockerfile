FROM openjdk:11
EXPOSE 8081
ADD target/crypto-convertor.jar crypto-convertor.jar
ENTRYPOINT ["java","-jar","/crypto-convertor.jar"]