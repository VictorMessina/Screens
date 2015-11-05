<%-- 
    Document   : deleteMovie
    Created on : 04/11/2015, 16:43:36
    Author     : Patricia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Movie</title>
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
            <section>
                <p> Selecione o filme que deseja excluir: </p>

                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> nome Filme</option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="command" value="movie.delete" />
                    <p> <input type="submit" value="Delete Movie"/></p>
                </form>
            </section>
        </div>	
    </div>

    <!-- Rodapé -->
    <div id="footer">
        <div class="container">
            <p>Facebook: <br>Filippi, Letícia, Victor</p>
            <ul class="icons">
                <li><a href="https://www.facebook.com/FilippiLuigi" class="fa fa-facebook"></a></li>
                <li><a href="https://www.facebook.com/letiglow" class="fa fa-facebook"></a></li>
                <li><a href="https://www.facebook.com/victor.messina.7" class="fa fa-facebook"></a></li>
            </ul>
        </div>
    </div>
</body>
</html>