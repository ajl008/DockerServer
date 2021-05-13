FROM maven:3.8.1-openjdk-11
WORKDIR /usr/app
COPY ./target/server-1.0-SNAPSHOT.jar .
# COPY files/* files/
ENTRYPOINT java -cp server-1.0-SNAPSHOT.jar lvc.cds.App