<%-- 
    Document   : index
    Created on : 30/09/2015, 07:49:19
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to SCREENS!</title>
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
            </div>

            <!-- Banner -->
            <div id="banner" class="container">
                <section>
                    <p> Bem vindo(a) ao <strong>SCREENS</strong>!</p>
                    <p> Usuário novo? Cadastre-se no nosso site </p>
                    <form action="register.jsp">
                        <p> <input type="submit" value="SING UP"/></p>
                    </form>
                    <p> Já possui conta? Entre e fique a vontade </p>
                    <form action="FrontController" method="POST">
                        <p> UserName: <input type="text" name="userName" placeholder="userName" value="${cookie.user.value}" required/></p>
                        <p> Password: <input type="password" name="password" placeholder="password" required/></p>
                        <p> <input type="checkbox" name="lembrar"> lembrar dados? </p>
                        <p><input type="submit" value="Login" </p>
                        <input type="hidden" name="command" value="access.login"/>
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
