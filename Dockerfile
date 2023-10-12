## ====== Build Image ====== ##
FROM maven:3.6.3-openjdk-17 AS build_image

WORKDIR /app

COPY pom.xml .
RUN mvn -e -B dependency:resolve

COPY src ./src
RUN mvn package -DskipTests

## ====== Unit Tests ====== ##
FROM maven:3.6.3-openjdk-17 as unit_tests

# set the working directory to /app
ENV APP_HOME /app
WORKDIR $APP_HOME

COPY --from=build_image $APP_HOME $APP_HOME

CMD [ "mvn", "test"]

## ====== Deploy Image ====== ##
FROM openjdk:17.0 as release_image

# Workdir creation
WORKDIR /app

COPY --from=build_image /app/target/gameLogger.jar .

# Container entrypoint
CMD [ "java", "-jar", "./gameLogger.jar" ]