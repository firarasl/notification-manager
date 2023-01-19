FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 9990
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]

#docker build --build-arg JAR_FILE=target/*.jar -t bilal/notification-management .