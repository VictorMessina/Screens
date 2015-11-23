<%-- 
    Document   : deleteMovie
    Created on : 04/11/2015, 16:43:36
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
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
                background: white;
                border-radius: 6px;
                border: 0;
                color: black;
                cursor: pointer;
                display: inline-block;
                padding: 10px 24px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 17px;
                font-weight: 600;
            }
            a.home {
                background: #d84780;
                color: white;
                border: none;
                display: block;
                outline: 0;
                padding: 16px 16px;
                text-decoration: none;
                text-align: center;
                text-transform: uppercase;
                width: 14%;
                border-radius: 6px;
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
            <a class ="home" href="FrontController?command=adm.functions"><b>Home ADM</b></a>
            <c:if test="${movies.size()==0}">
                <h2><c:out value="ATENÇÃO: A lista de filmes esta vazia"> </c:out></h2>
            </c:if>
            <br><br>
            <section>
                <p> Selecione o filme que deseja excluir: </p>
                <form action="FrontController" method="POST">
                    <select name="idMovie">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="movie" items="${movies}">
                            <option value="${movie.getId_Movie()}"> ${movie.getTitle()} </option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="command" value="movie.delete" />
                    <br><br><p> <input type="submit" value="Delete Movie"/></p>
                </form>
            </section>
        </div>	
    </body>
</html>