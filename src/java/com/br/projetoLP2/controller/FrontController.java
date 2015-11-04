package com.br.projetoLP2.controller;

import com.br.projetoLP2.business.UserManager;
import com.br.projetoLP2.business.AccountManager;
import com.br.projetoLP2.business.AccessManager;
import com.br.projetoLP2.business.PaymentManager;
import com.br.projetoLP2.model.Access;
import com.br.projetoLP2.model.DAO.MovieDAO;
import com.br.projetoLP2.model.Payment;
import com.br.projetoLP2.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31449530
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private String command;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //todas as operações do usuario
            RequestDispatcher rd;
            if (command.startsWith("user")) {
                int code = 0;
                if (command.endsWith("insert")) { // insert - insere um novo usuario no banco de dados
                    
                    if(!UserManager.validaCPF(request.getParameter("cpf"))){
                        rd = request.getRequestDispatcher("/register.jsp");
                        rd.forward(request, response);
                    }
                    
                    else{

                        String owner = request.getParameter("owner");
                        String email = request.getParameter("email");
                        String cpf = request.getParameter("cpf");
                        String bday = request.getParameter("bday");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date bday2 = null;
                        try {
                            bday2 = formatter.parse(bday);
                        } catch (ParseException ex) {
                            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        User user = new User();

                        user.setOwner(owner);
                        user.setEmail(email);
                        user.setCpf(cpf);
                        user.setBday(bday2);
                        user.setUserType(1);

                        code = UserManager.insert(user);
                        //request.getSession().setAttribute("owner",owner);
                    }
                }

                if (code == 1) {
                    rd = request.getRequestDispatcher("/register2.jsp");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("/erroLogin.jsp");
                    String mensagem = "";
                    switch (code) {
                        case -3:
                            mensagem = "Owner already exist";
                            break;
                        case -5:
                            mensagem = "ERROR on data base. try again";
                            break;
                    }
                    request.getSession().setAttribute("code", mensagem);
                    rd.forward(request, response);
                    //response.sendRedirect("erroLogin.jsp"); // pode substituir a linha de cima mas nao mantem todas as informações na session
                }
            }// FIM DO IF DO USER...

            if (command.startsWith("access")) {
                int code = 0;
                //Login
                if (command.endsWith("login")) { // valida o login com os dado da tabela Access
                    String userName = request.getParameter("userName");
                    String password = request.getParameter("password");
                    code = AccessManager.authorize(userName, password);
                    request.getSession().setAttribute("access", AccessManager.getAccess());
                    request.getSession().setAttribute("movies", new MovieDAO().read());
                    // substitui as duas linhas comentada abaixo
                    //request.getSession().setAttribute("password",password); // substitui as duas linhas comentada abaixo

                } else if (command.endsWith("insert")) { // insert login - insere um novo login de usuario no banco de dados
                    String userName = request.getParameter("userName");
                    String pwd = request.getParameter("password");
                    String pwd2 = request.getParameter("password2");

                    Access access = new Access(userName, pwd);

                    access.setUserName(userName);
                    access.setPassword(pwd);

                    code = AccessManager.insert(access, pwd2);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/register3.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/register2.jsp");
                        rd.forward(request, response);
                    }
                } 
                else if (command.endsWith("logout")) {
                    request.getSession().invalidate(); // destroi a sessão
                    rd = request.getRequestDispatcher("/index.jsp"); // redireciona para pagina index
                    rd.forward(request, response);
                } 
                else if (command.endsWith("perfil")) {
                        request.getSession().setAttribute("access", AccessManager.getAccess());
                        rd = request.getRequestDispatcher("/perfil.jsp"); // redireciona para pagina perfil
                        rd.forward(request, response);
                }
                else if (command.endsWith("homepage")) {
                        request.getSession().setAttribute("access", AccessManager.getAccess());
                        rd = request.getRequestDispatcher("/homepage.jsp"); // redireciona para pagina perfil
                        rd.forward(request, response);
                }
                
                if (code == 1) {
                    String userName = "";

                    if (request.getParameter("lembrar") != null) {
                        userName = AccessManager.getAccess().getUserName();
                    }
                    Cookie cookie = new Cookie("user", userName); // nome do cookie
                    cookie.setMaxAge(60 * 60 * 24 * 7); //tempo de permanencia do cookie no navegador
                    response.addCookie(cookie); // adiciona cookie

                    rd = request.getRequestDispatcher("/homepage.jsp");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("/erroLogin.jsp");
                    String mensagem = "";
                    switch (code) {
                        case -1:
                            mensagem = "User not found";
                            break;
                        case -2:
                            mensagem = "Wrong Password";
                            break;
                        case -3:
                            mensagem = "User already exist";
                            break;
                        case -4:
                            mensagem = "Password doesn't macth";
                            break;
                        case -5:
                            mensagem = "ERROR on data base. try again";
                            break;
                    }
                    request.getSession().setAttribute("code", mensagem);
                    rd.forward(request, response);
                    //response.sendRedirect("erroLogin.jsp"); // pode substituir a linha de cima mas nao mantem todas as informações na session
                }
            }//FIM DO IF ACCESS...

            if (command.startsWith("account")) {
                int code = 0;
                if (command.endsWith("insert")) { // insert - insere um tipo de conta no banco de dados

                    String types = request.getParameter("types");

                    code = AccountManager.insert(types);
                    
                    if (code != -1) {
                        rd = request.getRequestDispatcher("/register4.jsp");
                        request.getSession().setAttribute("valorConta", code);
                        rd.forward(request, response);
                    }else {
                        rd = request.getRequestDispatcher("/register3.jsp");
                        rd.forward(request, response);
                    }
                }
            }//FIM IF ACCOUNT
            
            if (command.startsWith("payment")) {
                int code = 0;
                if (command.endsWith("insert")) { // insert - insere um novo pagamento no banco de dados

                    if(!PaymentManager.validaNumberCard(request.getParameter("numberCard"))){
                        rd = request.getRequestDispatcher("/register4.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        
                        String numberCard = request.getParameter("numberCard");
                        
                        int total = (int) request.getSession().getAttribute("valorConta");

                        Date paymentDate = new Date();

                        String status = "Em aberto";
                        
                        Payment payment = new Payment ();
                        
                        payment.setNumberCard(numberCard);
                        payment.setTotal(total);
                        payment.setPaymentDate(paymentDate);
                        payment.setStatus(status);
                        
                        code = PaymentManager.insert(payment);
                    }
                }

                if (code == 1) {
                    rd = request.getRequestDispatcher("/homepage.jsp");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("/erroLogin.jsp");
                    String mensagem = "";
                    switch (code) {
                        case -5:
                            mensagem = "ERROR on data base. try again";
                            break;
                    }
                    request.getSession().setAttribute("code", mensagem);
                    rd.forward(request, response);
                }
            } //FIM DO IF PAYMENT
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        command = request.getParameter("command");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        command = request.getParameter("command");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}