FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/organizationMicroService
ADD organization-Microservice-0.0.1-SNAPSHOT.jar /usr/local/organizationMicroService/
ADD run.sh run.sh
RUN sed -i 's/\r$//' run.sh 
RUN chmod +x run.sh
CMD ./run.sh
