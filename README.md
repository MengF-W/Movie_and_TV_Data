# movie_and_TV_Data
The [Movie Database (TMDB)](https://www.themoviedb.org/) is a collaborative movie and TV database, which it is editable by user. 
It also provide the [API](https://developer.themoviedb.org/docs/getting-started) service for those people interested in using TMDB's movie, TV show or actor images and/or data in application. The currently available methods contain variety data for movie, tv, actor and image API. It support JSON as the only response format.

This web appilcation provides a Java-wrapper around the JSON API provided by TMDb. At the moment the wrapper only implements the ["Trending Movies" JSON API](https://developer.themoviedb.org/reference/trending-movies). The response is displayed in a web browser. More different JSON API wrapper will be added in this web application in later stage. 

# Libraries used
* Spring Boot
* Spring Data JPA
* Spring Web
* PostgreSQL JDBC Driver
* Gson
* Jakarta Standard Tag Library Implementation

# Usage
To register for a TMDb API key, click the [TMDb API link](https://www.themoviedb.org/settings/api) from within your account settings page. There are two types of API keys currently provided by TMDb, please ensure you are using the API Key.

With this you can use it in application.properties

<img width="178" height="25" alt="image" src="https://github.com/user-attachments/assets/dfefe75d-4fd8-4113-a266-b62b9e5dc117" />

# Packaging Command
`gradle clean build` - To clean and create JAR

# Docker Image Command
`docker build -t movie_and_TV_Data`    -To build the docker image

# Docker Container Command
`docker-compose up -d`      -To start the docker container from the docker image with the docker compose file configuration  

# Running the Web Application
Enter the URL 'http://localhost:8080/view-movie' in a web browser. The result is then displayed in the web browser

<img width="1894" height="1027" alt="image" src="https://github.com/user-attachments/assets/966f80c0-c721-4061-9eb5-afc5507ac221" />



