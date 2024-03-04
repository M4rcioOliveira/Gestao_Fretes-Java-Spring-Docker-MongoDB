FROM maven:latest AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=builder /app/target/adm-shipping-0.0.1-SNAPSHOT.jar /app/adm-shipping-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "adm-shipping-0.0.1-SNAPSHOT.jar"]