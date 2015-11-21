<%-- 
    Document   : insertMovie
    Created on : 04/11/2015, 15:51:07
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Movie</title>
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
                <p> Insira os dados do novo Filme: </p>
                <form action="FrontController" method="POST">
                    <fieldset>
                        <p> Title:  <input type="text" name="title" placeholder="Title" maxlength="50" required/></p>
                        <p> Year: <input type="text" name="years"  placeholder="Year" maxlength="4" required/></p>
                        <p> Director: <input type="text" name="director"  placeholder="Director" maxlength="20" required/></p>            
                        <p> Classification: <input type="text" name="classification" placeholder="Classification" required/></p>
                        <p> Genre: <input type="text" name="genre" placeholder="Genre" maxlength="20" required/></p>
                        <p> URL: <input type="text" name="url" placeholder="URL" maxlength="50" required/></p>
                        <!-- Colocar aqui os outros campos do seu cadastro 
                             usar required quando os campos do banco forem not null-->
                        <input type="hidden" name="command" value="movie.insert" />
                        <p> <input type="submit" value="Register Movie"/></p>
                    </fieldset>
                </form>
                <p> OBS: Nos campos Classification e Year são usados numeros </p>
            </section>
            <a href="FrontController?command=adm.functions">Home ADM</a>
        </div>	
    </body>
</html>
