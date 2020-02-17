FROM oraclelinux:7-slim as oracleImg

COPY . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon 

EXPOSE 8080

RUN mkdir /app

COPY --from=oracleImg /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
