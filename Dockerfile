FROM openjdk:21-jdk-slim

COPY target/provisioning.jar provisioning.jar

ENTRYPOINT ["java", "-jar", "provisioning.jar"]