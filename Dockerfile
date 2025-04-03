FROM openjdk:21-jdk-slim

COPY target/provisioning.jar provisioning.jar

RUN apt-get update \
    && apt-get install -y jq

ENTRYPOINT ["java", "-jar", "provisioning.jar"]

HEALTHCHECK --start-period=60s --interval=10s --timeout=10s --retries=3 \
    CMD curl --silent --fail --request GET http://localhost:8085/actuator/health/readiness \
        | jq --exit-status '.status == "UP"' || exit 1