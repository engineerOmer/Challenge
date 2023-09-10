FROM openjdk:19 AS source
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:19
WORKDIR allianzcase
COPY --from=source target/*.jar allianzcase.jar
ENTRYPOINT ["java", "-jar", "allianzcase.jar"]

