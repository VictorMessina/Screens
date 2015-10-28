<%-- 
    Document   : home
    Created on : 30/09/2015, 09:47:26
    Author     : 31449530
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dropotron.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>
        <noscript>
        <link rel="stylesheet" href="css/skel.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        </noscript>
    </head>
    <body>
        <c:if test="${access==null}">
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
                        <li> <h1>Welcome ${access.getUser().getOwner()} </h1></li>
                        <li><a href="FrontController?command=access.perfil">Perfil</a></li>
                        <li><a href="FrontController?command=access.homepage">Home</a></li>
                        <li><a href="grupo.jsp">Sobre Nós</a></li>
                        <li><a href="FrontController?command=access.logout">Sair</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Quadros dos filmes (extra) -->
            <div class="container">
                <div class="row no-collapse-1">

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                            <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                    <section class="4u"> <a href="#" class="image featured"><img src="images/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Informações do Filme</p>
                            <form action="#">
                                <input type="submit" value="Assistir">
                            </form>
                        </div>
                    </section>

                </div>
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