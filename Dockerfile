#base image
FROM maven:3.8.1-openjdk-11

#set working directory
WORKDIR /usr/app

#copy files needed for app to run or jar file
# COPY files/* files/
COPY ./target/server-1.0-SNAPSHOT.jar .

#run the application
ENTRYPOINT java -cp server-1.0-SNAPSHOT.jar lvc.cds.App