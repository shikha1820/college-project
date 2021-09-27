FROM adoptopenjdk:11-jre-openj9@sha256:40303450f16a64184534ed3e8f3f80137d05590f38656ba115349266e8fd7e0d
WORKDIR /opt/app
COPY target/PROJECT_ARTIFACT_ID_GOES_HERE`.jar api.jar
CMD [ "java", "-jar", "api.jar" ]