FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD gradle-springboot-1.0.jar gradle-springboot-1.0.jar
ENTRYPOINT ["java","-jar","gradle-springboot-1.0.jar"]