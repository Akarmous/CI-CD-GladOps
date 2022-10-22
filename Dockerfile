FROM openjdk:8-jre-alpine
ADD target/achat.jar achat.jar

ENTRYPOINT ["java", "-jar", "achat.jar"]
