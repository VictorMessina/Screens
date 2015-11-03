<%-- 
    Document   : admFunctions
    Created on : 28/10/2015, 19:43:39
    Author     : 31449530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADM Functions</title>
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
        <h2>Funções ADM</h2>
            
        <a href="FrontController?command=access.logout">Sair</a>
        
        <div class="container">
            <h1> CRUD para Usuarios </h1>
         
            <h2> Create </h2>
         
            <form action="FrontController"  method="POST" > 
               <p>Nome: <input type = "text" name = "nome_autor"/></p>
                <input type="hidden" name="command" value=""/>
               <p><input type = "submit" value = "inserir"/></p>
           </form>

         <hr>

        <h2> Read </h2>
        <c:forEach var="itens" items="${accessList}">
            ${itens}
            
        </c:forEach> 
   
        <%--  
            
            AccessDAO accessDAO = new AccessDAO();
            List <Access> accesss = accessDAO.read();
            for(Access access : accesss){
                out.print("<p>"+ access.getUserName()+ " - " + access.getAccount().getTypes() + "</p>");
            }
        
        
        --%>

        <hr>

        <h2> Update </h2>
        <form action="Controller" method="POST"> 
            <select name = "select_autor_update">
                
                <option value="0"></option>
                <%-- 
                    
                    for (Autor autor: autores){
                        out.print("<option value='"+autor.getId_autor()+"'>"+autor.getNome()+" </option>");
                    }
                --%>
            </select>
            <input type="hidden" name="command" value="autor.update"/>
            <p>Novo nome: <input type = "text" name = "nome_autor"/></p>
            <p><input type = "submit" value = "ATUALIZAR"/></p>
        </form>

        <hr>

        <h2> Delete </h2>
        <form action="Controller" method="POST"> 
            <select name = "select_autor_delete">
                <option value="0"></option>
                <%-- 
                    
                    for (Autor autor: autores){
                        out.print("<option value='"+autor.getId_autor()+"'>"+autor.getNome()+" </option>");
                    }
                --%>
            </select>
            <input type="hidden" name="command" value="autor.delete"/>
            <p><input type = "submit" value = "DELETAR"/></p>
        </form>

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