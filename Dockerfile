FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Paytm-Payment-Gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Paytm-Payment-Gateway-0.0.1-SNAPSHOT.jar"]
