<%-- 
    Document   : register2
    Created on : 19/10/2015, 16:49:37
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User - Step 2</title>
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
            </div>

            <!-- Banner -->
            <div id="banner" class="container">
                <section>
                    <p> Insira os dados da sua conta: </p>
                    <form action="FrontController" method="POST">
                        <fieldset>
                            <p> UserName: <input type="text" name="userName" placeholder="userName" maxlength="10" required/></p>
                            <p> Password: <input type="password" name="password"  placeholder="password" maxlength="7" required/></p>
                            <p> Confirme password: <input type="password" name="password2"  placeholder="confirm password" maxlength="7" required/></p>      
                            <!-- Colocar aqui os outros campos do seu cadastro 
                                 usar required quando os campos do banco forem not null-->
                            <p> <input type="submit" value="Continue"/></p>
                            <input type="hidden" name="command" value="access.insert"/>

                        </fieldset>
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