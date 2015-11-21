<%-- 
    Document   : register3
    Created on : 19/10/2015, 16:50:25
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User - Step 3</title>
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
                    <p> Selecione o tipo de conta que deseja: </p>
                    <form action="FrontController" method="POST">
                        <fieldset>
                            <p><input type="radio" name="types" value="Diamond" checked="checked"/> Diamond - R$ 40,00 </p>
                            <p><input type="radio" name="types" value="Gold"/> Gold - R$ 30,00 </p>
                            <p><input type="radio" name="types" value="Silver"/> Silver - R$ 20,00 </p>
                            <!-- Colocar aqui os outros campos do seu cadastro 
                                 usar required quando os campos do banco forem not null-->
                            <p> <input type="submit" value="Continue"/></p>
                            <input type="hidden" name="command" value="account.insert"/>
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
