FROM alpine/java:21-jre
EXPOSE 8080

WORKDIR /application/movie_and_TV_Data/
COPY build/libs/*.war /application/movie_and_TV_Data/movie_and_TV_Data.war
CMD ["java", "-jar", "/application/movie_and_TV_Data/movie_and_TV_Data.war"]