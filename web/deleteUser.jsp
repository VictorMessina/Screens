<%-- 
    Document   : deleteUser
    Created on : 11/11/2015, 09:23:21
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User</title>
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
            <c:if test="${users.size()==1}">
                <c:out value="A lista de usuarios esta vazia"> </c:out>
            </c:if>
            <section>
                <p> Selecione o usuário que deseja excluir: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> nome Usuario</option>
                        <c:forEach var="user" items="${users}">
                            <c:if test="${user.getUser().getUserType()!= 2}">
                                <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="command" value="userAdm.delete" />
                    <p> <input type="submit" value="Delete User"/></p>
                </form>
            </section>
            <a href="FrontController?command=adm.functions">Home ADM</a>
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