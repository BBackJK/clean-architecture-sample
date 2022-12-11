FROM adoptopenjdk/openjdk11 AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM adoptopenjdk/openjdk11
COPY --from=builder build/libs/ROOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
