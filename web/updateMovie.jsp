<%-- 
    Document   : updateMovie
    Created on : 04/11/2015, 18:16:44
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Movie </title>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dropotron.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>
        <noscript>
        <link rel="stylesheet" href="css/skel.css" />
        <link rel="stylesheet" href="css/style.css" />
        </noscript>
        <style>
            select {
                color: #000;
                font-family: 'Raleway', sans-serif;
                font-size: 12pt;
                font-weight: 300;
                line-height: 26px;
            }
        </style>
    </head>
    <body>
        <!-- Site -->
        <div class="site">

            <!-- Header -->
            <div id="header" class="skel-panels-fixed">
                <div id="logo">
                    <h1>SCREENS</h1>
                </div>
                <nav id="nav">
                    <ul>
                        <li><a href="FrontController?command=access.logout">Sair</a></li>
                    </ul>
                </nav>
            </div>
        </div>

        <!-- Banner -->
        <div id="banner" class="container">
            <c:if test="${movies.size()==0}">
                <c:out value="A lista de filmes esta vazia"> </c:out>
            </c:if>
            <section>
                <a href="FrontController?command=adm.functions">Home ADM</a>
                <p> Mudar titulo do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>
                    <p> Title:  <input type="text" name="title" placeholder="Title" maxlength="50" required/></p>
                    <input type="hidden" name="command" value="movie.updateTitle" />
                    <p> <input type="submit" value="Mudar Titulo"/></p>
                </form>
            </section>

            <hr>

            <section>
                <p> Mudar ano do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>                    
                    <p> Year: <input type="text" name="years"  placeholder="Year" maxlength="4" required/></p>
                    <input type="hidden" name="command" value="movie.updateYear" />
                    <p> <input type="submit" value="Mudar Ano"/></p>
                </form>
                <p> OBS: No campo Year é usado numero </p>
            </section>

            <hr>

            <section>
                <p> Mudar diretor do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>                    
                    <p> Director: <input type="text" name="director"  placeholder="Director" maxlength="20" required/></p>
                    <input type="hidden" name="command" value="movie.updateDirector" />
                    <p> <input type="submit" value="Mudar Diretor"/></p>
                </form>
            </section>

            <hr>

            <section>
                <p> Mudar classificação do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>                    
                    <p> Classification: <input type="text" name="classification" placeholder="Classification" required/></p>
                    <input type="hidden" name="command" value="movie.updateClassification" />
                    <p> <input type="submit" value="Mudar Classificação"/></p>
                </form>
                <p> OBS: No campo Classification é usado numero </p>
            </section>

            <hr>

            <section>
                <p> Mudar genero do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>
                    <p> Genre: <input type="text" name="genre" placeholder="Genre" maxlength="20" required/></p>
                    <input type="hidden" name="command" value="movie.updateGenre" />
                    <p> <input type="submit" value="Mudar Genero"/></p>
                </form>
            </section>

            <hr>

            <section>
                <p> Mudar url do filme: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>
                    <p> URL: <input type="text" name="url" placeholder="URL" maxlength="50" required/></p>
                    <input type="hidden" name="command" value="movie.updateUrl" />
                    <p> <input type="submit" value="Mudar URL"/></p>
                </form>
            </section>
        </div>
    </body>
</html>
