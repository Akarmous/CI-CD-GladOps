FROM openjdk:8-jre-alpine
ADD target/achat.jar achat.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "achat.jar"]
