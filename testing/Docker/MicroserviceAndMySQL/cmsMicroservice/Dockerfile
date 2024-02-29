FROM openjdk:17
RUN mkdir /cmsApp
COPY target/ /cmsApp
WORKDIR /cmsApp
CMD java -jar cmsMicroservice-0.0.1-SNAPSHOT.jar --spring.config.name-application.properties