<%-- 
    Document   : register
    Created on : 01/10/2015, 07:49:03
    Author     : 31449530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
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
                    <p> Insira seus dados pessoais: </p>
                    <form action="FrontController" method="POST">
                        <fieldset>
                            <p> Owner:  <input type="text" name="owner" placeholder="Owner" maxlength="10" required/></p>
                            <p> Email: <input type="email" name="email"  placeholder="email" maxlength="30" required/></p>
                            <p> CPF: <input type="text" name="cpf"  placeholder="CPF" maxlength="11" required/></p>            
                            <!-- Colocar aqui os outros campos do seu cadastro 
                                 usar required quando os campos do banco forem not null-->
                            <input type="hidden" name="command" value="user.insert" />
                            <p> <input type="submit" value="Continue"/></p>
                        </fieldset>
                    </form>
                    <p> OBS: Não é preciso separar os numeros do cpf com pontos e traços </p>
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