FROM openjdk:17
EXPOSE 8080
ENV LD_LIBRARY_PATH /usr/lib
ARG JAR_FILE=target/PI-2024-0.0.1-SNAPSHOT.jar
ARG SO_FILE=src/main/java/com/example/pi2024/lib
ADD ${JAR_FILE} ova.jar
COPY ${SO_FILE}/io/libcalculatorcolas.so /usr/lib
COPY ${SO_FILE}/newton/libnewtonraphson.so /usr/lib
VOLUME /tmp
ENTRYPOINT ["java","-jar","/ova.jar"]

