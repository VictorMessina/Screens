<%-- 
    Document   : erroLogin
    Created on : 30/09/2015, 09:47:45
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro Login</title>
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
                    <h1><a href="index.jsp">SCREENS</a></h1>
                </div>
                <nav id="nav">
                    <ul>
                        <li><a href="index.jsp"> Back </a></li>
                    </ul>
                </nav>
            </div>

            <!-- Banner -->
            <div id="banner" class="container">
                <section>
                    <h1><% out.print("ERRO: " + request.getSession().getAttribute("code").toString());%></h1>
                </section>
            </div>
        </div>
    </body>
</html>