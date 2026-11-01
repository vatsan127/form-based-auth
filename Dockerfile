FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml /app/

COPY src/ /app/src/
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
ENV USER_ID=1002
ENV GROUP_ID=1002
ENV USER=app
ENV APP_HOME=/opt/app

RUN mkdir -p "$APP_HOME"

RUN addgroup --gid ${GROUP_ID} ${USER}
RUN adduser --uid ${USER_ID} --gid ${GROUP_ID} --gecos "" --home /home/${USER} --disabled-password --shell /bin/bash ${USER}

COPY --from=builder /app/target/form-based-auth-*.jar ${APP_HOME}/form-based-auth.jar
RUN chown -R ${USER}:${USER} ${APP_HOME}

USER ${USER}

WORKDIR ${APP_HOME}

EXPOSE 8080

CMD ["java", "-jar", "form-based-auth.jar"]
