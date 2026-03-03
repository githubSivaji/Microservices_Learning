# Start with a base image containing Java Runtime
FROM eclipse-temurin:17-jre-jammy

LABEL maintainer="sivaji.com"

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]
