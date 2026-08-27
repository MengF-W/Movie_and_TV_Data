FROM alpine/java:21-jre
EXPOSE 8080

WORKDIR /application/movie_and_TV_Data/
COPY target/*.jar /application/movie_and_TV_Data/movie_and_TV_Data.jar
CMD ["java", "-jar", "/application/movie_and_TV_Data/movie_and_TV_Data.jar"]