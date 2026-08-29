<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>The Movie Database(TMDB) Trending Movie</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>The Movie Database(TMDB) Trending Movies</h2>
<table>
    <thead>
    <tr>
        <th>Language</th>
        <th>Title</th>
        <th>Name</th>
        <th>Movie Poster</th>
        <th>Movie Trailer</th>
        <th>Overview</th>
        <th>Popularity</th>
        <th>Release Date</th>
        <th>First Air Date</th>
        <th>Vote Average</th>
        <th>Vote Count</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.original_language}</td>
            <td>${movie.title}</td>
            <td>${movie.name}</td>
            <td><img src=${movie.thumbnail_poster} alt="poster"></td>
            <td><iframe width="154" height="231" src="https://www.youtube.com/embed/tgbNymZ7vqY"></iframe></td>
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