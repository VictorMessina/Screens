<%-- 
    Document   : admFunctions
    Created on : 28/10/2015, 19:43:39
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADM Functions</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dropotron.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>
        <noscript>
        <link rel="stylesheet" href="css/skel.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        </noscript>
    </head>
    
    <body>
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

            <div class="container">
                <h3> Menu do CRUD de Usuarios </h3>
                <%@include file="menu_adm_functionsUser.jspf" %>
                <hr>
                <br>
                <h3> Menu do CRUD de Filmes</h3>
                <%@include file="menu_adm_functionsMovies.jspf" %> 
            </div>
    </body>
</html>