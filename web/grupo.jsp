<%-- 
    Document   : grupo
    Created on : 14/10/2015, 16:17:42
    Author     : 31438938
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sobre Nós</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dropotron.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>
        <noscript>
        <link rel="stylesheet" href="css/skel.css" />
        <link rel="stylesheet" href="css/style.css" />
        </noscript>
    </head>
    <body>
        <c:if test="${userName==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>
        <!-- Site -->
        <div class="site">

            <!-- Header -->
            <div id="header" class="skel-panels-fixed">
                <div id="logo">
                    <h1><a href="grupo.jsp">SCREENS</a></h1>
                </div>
                <nav id="nav">
                    <ul>
                        <li><a href="FrontController?command=access.perfil">Perfil</a></li>
                        <li><a href="homepage.jsp">Home</a></li>
                        <li><a href="grupo.jsp">Sobre Nós</a></li>
                        <li><a href="FrontController?command=access.logout">Sair</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Banner -->
            <div id="banner" class="container">
                <section>
                    <p>Prazer te conhecer, somos <strong>SCREENS</strong>, seu site preferido para ver filmes!</p>
                    <p> Venha nos visitar no Mackenzie, </p>
                    <p> procure por Filippi, Letícia ou Victor </p>
                    <br>
                    <p> Ou, também, pelos nossos facebooks, </p>
                    <p> que podem ser encontrados nos botões no final da página </p>
                    <br>
                    <p> Não deixe de nos encontrar ;) </p>
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