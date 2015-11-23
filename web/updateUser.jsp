<%-- 
    Document   : updateUser
    Created on : 20/11/2015, 15:58:53
    Author     : Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User </title>
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
            select {
                background: white;
                border-radius: 6px;
                border: 0;
                color: black;
                cursor: pointer;
                display: inline-block;
                padding: 10px 24px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 17px;
                font-weight: 600;
            }
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
            <c:if test="${users.size()==1}">
                <h2><c:out value="ATENÇÃO: A lista de usuarios esta vazia"></c:out></h2>
            </c:if>
            <br><br>
            <section>
                <p> Mudar Owner do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>                    
                    <br><br><p> Owner: <input type="text" name="owner" placeholder="Owner" maxlength="10" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateOwner" />
                    <p> <input type="submit" value="Mudar Owner"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar Email do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> Email:  <input type="text" name="email" placeholder="Email" maxlength="30" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateEmail" />
                    <p> <input type="submit" value="Mudar Email"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar CPF do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> CPF:  <input type="text" name="cpf" placeholder="CPF" maxlength="11" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateCPF" />
                    <p> <input type="submit" value="Mudar CPF"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar data de nascimento do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> Data de Nascimento<input type="date" name="bday" placeholder="dd/mm/yyyy" required</p>
                    <input type="hidden" name="command" value="userAdm.updateDate" />
                    <p> <input type="submit" value="Mudar data"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar userType do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getUser().getId_User()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> UserType: <input type="text" name="userType" placeholder="userType" maxlength="1" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateUserType" />
                    <p> <input type="submit" value="Mudar userType"/></p>
                </form>
                <p>OBS: usar 1 para usuarios normais e 2 para usuario administrador </p>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar userName do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getId_Access()}"> ${user.getUserName()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> UserName: <input type="text" name="userName" placeholder="userName" maxlength="10" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateUserName" />
                    <p> <input type="submit" value="Mudar userName"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar senha do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getId_Access()}"> ${user.getUserName()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p> Password: <input type="password" name="password"  placeholder="password" maxlength="7" required/></p>
                    <input type="hidden" name="command" value="userAdm.updatePassword" />
                    <p> <input type="submit" value="Mudar senha"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar tipo da conta do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getAccount().getId_Account()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br>
                    <p><input type="radio" name="types" value="Diamond" checked="checked"/> Diamond - R$ 40,00 </p>
                    <p><input type="radio" name="types" value="Gold"/> Gold - R$ 30,00 </p>
                    <p><input type="radio" name="types" value="Silver"/> Silver - R$ 20,00 </p>
                    <input type="hidden" name="command" value="userAdm.updateType" />
                    <p> <input type="submit" value="Mudar Conta"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar numero de cartão do usuario: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getPayment().getId_payment()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <br><br><p>NumberCard: <input type="text" name="numberCard" placeholder="numberCard" maxlength="16" required/></p>
                    <input type="hidden" name="command" value="userAdm.updateNumberCard" />
                    <p> <input type="submit" value="Mudar Nº Cartão"/></p>
                </form>
            </section>

            <br><hr><br>

            <section>
                <p> Mudar status da conta: </p>
                <form action="FrontController" method="POST">
                    <select name="idUser">
                        <option value="-1"> selecionar </option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.getPayment().getId_payment()}"> ${user.getUser().getOwner()} </option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="command" value="userAdm.updateStatus" />
                    <br><br><p> <input type="submit" value="Mudar status"/></p>
                </form>
            </section>

            <hr>
        </div>
    </body>
</html>