FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD book_manager-0.0.1-SNAPSHOT.jar book_manager.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/book_manager.jar"]