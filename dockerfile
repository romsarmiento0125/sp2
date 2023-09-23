FROM maven:3.8.5

WORKDIR /app

COPY pom.xml .

RUN mvn clean install

EXPOSE 8080

CMD ["mvn", "jetty:run"]