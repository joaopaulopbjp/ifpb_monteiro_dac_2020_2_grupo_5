FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -DskipTests

FROM openjdk:11-jre
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/api-books-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "api-books-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/merchant-api-1.0.0-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]