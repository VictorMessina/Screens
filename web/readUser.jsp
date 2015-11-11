<%-- 
    Document   : readUser
    Created on : 11/11/2015, 10:53:01
    Author     : 31449530
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
                <c:if test="${users.size()==0}">
                    <c:out value="A lista de usuarios esta vazia" > </c:out>
                </c:if>
                <c:forEach var="user" items="${users}">
                    <c:if test="${user.getUser().getUserType()!= 2}"> 
                        ${user.getUser().getOwner()} <hr>
                    </c:if>
                </c:forEach>
            </section>
            <a href="FrontController?command=adm.functions">Home ADM</a>
        </div>	
    </body>
</html>

