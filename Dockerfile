FROM openjdk:17
EXPOSE 8080
ENV LD_LIBRARY_PATH /usr/lib
ARG JAR_FILE=target/PI-2024-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ova.jar
COPY libcalculatorcolas.so /usr/lib
COPY libnewtonraphson.so /usr/lib
VOLUME /tmp
ENTRYPOINT ["java","-jar","/ova.jar"]

