<%-- 
    Document   : perfil
    Created on : 14/10/2015, 17:42:19
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
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
        <c:if test="${access==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>
        <!-- Site -->
        <div class="site">

            <!-- Header -->
            <div id="header" class="skel-panels-fixed">
                <div id="logo">
                    <h1><a href="FrontController?command=access.homepage">SCREENS</a></h1>
                </div>
                <nav id="nav">
                    <ul>
                        <li><a href="FrontController?command=access.perfil">Perfil</a></li>
                        <li><a href="FrontController?command=access.homepage">Home</a></li>
                        <li><a href="grupo.jsp">Sobre Nós</a></li>
                        <li><a href="FrontController?command=access.logout">Sair</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Banner -->
            <div id="banner" class="container">
                <section>
                    <p> Bem vindo(a) ${access.getUser().getOwner()} à sua página de perfil no <strong>SCREENS</strong>!</p>
                    <p> Confira abaixo seus dados: </p>
                    <p></p>
                    <p> Owner:<h2>${access.getUser().getOwner()}</h2> </p>
                    <p> E-mail: <h2>${access.getUser().getEmail()}</h2></p>
                    <p> CPF: <h2>${access.getUser().getCpf()}</h2></p>
                    <p> Tipo de conta: <h2>${access.getAccount().getTypes()}</h2></p>
                    <p> NumberCard: <h2> ${access.getPayment().getNumberCard()}</h2></p>
                    <p> Status do Pagamento: <h2> ${access.getPayment().getStatus()}</h2></p>
                    <p> Código de Pagamento: <h2> ${access.getPayment().getId_payment()}</h2></p>

                    <form action="FrontController" method="POST">
                        <input type="text" name="idPayment" placeholder="codigo" maxlength="1" required />
                        <br>
                        <input type="hidden" name="command" value="access.pagar" />
                        <p> <input type="submit" value="Pagar conta"/></p>
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