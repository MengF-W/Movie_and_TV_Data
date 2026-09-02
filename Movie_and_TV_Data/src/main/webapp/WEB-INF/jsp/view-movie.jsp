<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>The Movie Database(TMDB) Trending Movie</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<div class="title"><h2 >The Movie Database(TMDB) Trending Movies</h2></div>
<table class="styled-table">
    <thead>
    <tr>
        <th style="text-align:center">Language</th>
        <th style="text-align:center">Title</th>
        <th style="text-align:center">Name</th>
        <th style="text-align:center">Movie Poster</th>
        <th style="text-align:center">Movie Trailer</th>
        <th style="text-align:center">Overview</th>
        <th style="text-align:center">Popularity</th>
        <th style="text-align:center">Release Date</th>
        <th style="text-align:center">First Air Date</th>
        <th style="text-align:center">Vote Average</th>
        <th style="text-align:center">Vote Count</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.original_language}</td>
            <td>${movie.title}</td>
            <td>${movie.name}</td>
            <td><img src=${movie.thumbnail_poster} alt="poster"></td>
            <td>
            <c:choose>
                <c:when test="${not empty movie.movie_trailer}">
                    <iframe width="254" height="331" src=${movie.movie_trailer}></iframe>
                </c:when>
                <c:otherwise>
                    Movie trailer is not available
                </c:otherwise>
            </c:choose>
            </td>
            <td>${movie.overview}</td>
            <td>${movie.popularity}</td>
            <td>${movie.release_date}</td>
            <td>${movie.first_air_date}</td>
            <td>${movie.vote_average}</td>
            <td>${movie.vote_count}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>