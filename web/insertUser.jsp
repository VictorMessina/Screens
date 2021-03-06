<%-- 
    Document   : insertUser
    Created on : 11/11/2015, 11:29:05
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New User </title>
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
            a.home {
                background: #d84780;
                color: white;
                border: none;
                display: block;
                outline: 0;
                padding: 16px 16px;
                text-decoration: none;
                text-align: center;
                text-transform: uppercase;
                width: 14%;
                border-radius: 6px;
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
            <a class ="home" href="FrontController?command=adm.functions"><b>Home ADM</b></a>
            <section>
                <p> Insira os dados do novo Usuário: </p>
                <form action="FrontController" method="POST">
                    <fieldset>
                        <p> Owner:  <input type="text" name="owner" placeholder="Owner" maxlength="10" required/></p>
                        <p> Email: <input type="email" name="email"  placeholder="email" maxlength="30" required/></p>
                        <p> CPF: <input type="text" name="cpf"  placeholder="CPF" maxlength="11" required/></p>            
                        <p> Data de Nascimento<input type="date" name="bday" placeholder="dd/mm/yyyy" required</p>
                        <br><hr><br>
                        <p> UserName: <input type="text" name="userName" placeholder="userName" maxlength="10" required/></p>
                        <p> Password: <input type="password" name="password"  placeholder="password" maxlength="7" required/></p>
                        <p> Confirme password: <input type="password" name="password2"  placeholder="confirm password" maxlength="7" required/></p>
                        <br><hr><br>
                        <p><input type="radio" name="types" value="Diamond" checked="checked"/> Diamond - R$ 40,00 </p>
                        <p><input type="radio" name="types" value="Gold"/> Gold - R$ 30,00 </p>
                        <p><input type="radio" name="types" value="Silver"/> Silver - R$ 20,00 </p>
                        <br><hr><br>
                        <p>NumberCard: <input type="text" name="numberCard" placeholder="numberCard" maxlength="16" required/></p>
                        <!-- Colocar aqui os outros campos do seu cadastro 
                             usar required quando os campos do banco forem not null-->
                        <input type="hidden" name="command" value="userAdm.insertUser" />
                        <p> <input type="submit" value="Register User"/></p>
                </form>
                <p> OBS: No campo CPF não é preciso separar os numeros com pontos e traços </p>
            </section>
        </div>	
    </body>
</html>