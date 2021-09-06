FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/*.jar /opt/app/guiness.jar
CMD ["java", "-jar","opt/app/guiness.jar"]