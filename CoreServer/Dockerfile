FROM openjdk
ARG JAR_FILE=target/CoreServer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} AutoDriveNetworkServer.jar
ENTRYPOINT ["java","-jar","/AutoDriveNetworkServer.jar"]