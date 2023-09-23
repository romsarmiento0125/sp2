FROM openjdk:20

WORKDIR /app

COPY pom.xml .

RUN mvn clean install

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]