FROM gradle:jdk17-alpine
WORKDIR /app
COPY . /app
RUN gradle build -x test --no-daemon

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/build/libs/redis-0.0.1-SNAPSHOT.jar"]