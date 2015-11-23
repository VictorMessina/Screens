<%-- 
    Document   : readUser
    Created on : 11/11/2015, 10:53:01
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read User</title>
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
            <section>
                <c:if test="${users.size()==1}">
                    <h2><c:out value="ATENÇÃO: A lista de usuarios comuns esta vazia" > </c:out></h2>
                </c:if>
                <br><br>
                <c:out value="LISTA DE USUARIOS COMUNS" > </c:out>
                    <br>
                <c:forEach var="user" items="${users}">
                    <c:if test="${user.getUser().getUserType()!= 2}"> 
                        ${user.getUser().getOwner()} <br>
                    </c:if>
                </c:forEach>
            </section>
            <hr>
            <section>
                <c:if test="${users.size()==0}">
                    <h2><c:out value="ATENÇÃO: A lista de usuarios com funçoes de administrador esta vazia" > </c:out></h2>
                </c:if>
                <br><br>
                <c:out value="LISTA DE USUARIOS COM FUNÇÕES DE ADMINISTRADOR" > </c:out>
                    <br>
                <c:forEach var="user" items="${users}">
                    <c:if test="${user.getUser().getUserType()== 2}"> 
                        ${user.getUser().getOwner()} <br>
                    </c:if>
                </c:forEach>
            </section>
        </div>	
    </body>
</html>