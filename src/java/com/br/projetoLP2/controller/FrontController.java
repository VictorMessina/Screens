package com.br.projetoLP2.controller;

import com.br.projetoLP2.business.UserManager;
import com.br.projetoLP2.business.AccountManager;
import com.br.projetoLP2.business.AccessManager;
import com.br.projetoLP2.business.MovieManager;
import com.br.projetoLP2.business.PaymentManager;
import com.br.projetoLP2.model.Access;
import com.br.projetoLP2.model.DAO.AccessDAO;
import com.br.projetoLP2.model.DAO.MovieDAO;
import com.br.projetoLP2.model.Movie;
import com.br.projetoLP2.model.Payment;
import com.br.projetoLP2.model.User;
import com.br.projetoLP2.model.exception.OwnerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
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

                    if (!UserManager.validaCPF(request.getParameter("cpf"))) {
                        rd = request.getRequestDispatcher("/register.jsp");
                        rd.forward(request, response);
                    } else {

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
                    if (code == 1) {
                        rd = request.getRequestDispatcher("/register2.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/erroLogin.jsp");
                        String mensagem = "";
                        switch (code) {
                            case -3:
                                mensagem = new OwnerException().getMessage();
                                break;
                            case -5:
                                mensagem = "ERROR on data base. try again";
                                break;
                        }
                        request.getSession().setAttribute("code", mensagem);
                        rd.forward(request, response);
                        //response.sendRedirect("erroLogin.jsp"); // pode substituir a linha de cima mas nao mantem todas as informações na session
                    }
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

                    if (code == 1) {
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
                } else if (command.endsWith("logout")) {
                    request.getSession().invalidate(); // destroi a sessão
                    rd = request.getRequestDispatcher("/index.jsp"); // redireciona para pagina index
                    rd.forward(request, response);
                } else if (command.endsWith("perfil")) {
                    request.getSession().setAttribute("access", AccessManager.getAccess());
                    rd = request.getRequestDispatcher("/perfil.jsp"); // redireciona para pagina perfil
                    rd.forward(request, response);
                } else if (command.endsWith("homepage")) {
                    request.getSession().setAttribute("access", AccessManager.getAccess());
                    rd = request.getRequestDispatcher("/homepage.jsp"); // redireciona para pagina home
                    rd.forward(request, response);
                } else if (command.endsWith("pagar")) {
                    int idPayment = Integer.parseInt(request.getParameter("idPayment"));
                    int codeP = PaymentManager.updateStatusUser(idPayment);
                    if (codeP == 1) {
                        response.sendRedirect("homepage.jsp");
                    } else {
                        response.sendRedirect("erroLogin");
                    }
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
                    } else {
                        rd = request.getRequestDispatcher("/register3.jsp");
                        rd.forward(request, response);
                    }
                }
            }//FIM IF ACCOUNT

            if (command.startsWith("payment")) {
                int code = 0;
                if (command.endsWith("insert")) { // insert - insere um novo pagamento no banco de dados

                    if (!PaymentManager.validaNumberCard(request.getParameter("numberCard"))) {
                        rd = request.getRequestDispatcher("/register4.jsp");
                        rd.forward(request, response);
                    } else {

                        String numberCard = request.getParameter("numberCard");

                        int total = (int) request.getSession().getAttribute("valorConta");

                        Date paymentDate = new Date();

                        String status = "Em aberto";

                        Payment payment = new Payment();

                        payment.setNumberCard(numberCard);
                        payment.setTotal(total);
                        payment.setPaymentDate(paymentDate);
                        payment.setStatus(status);

                        code = PaymentManager.insert(payment);
                    }
                    if (code == 1) {
                        rd = request.getRequestDispatcher("/homepage.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/register4.jsp");
                        rd.forward(request, response);
                    }
                }

            } //FIM DO IF PAYMENT

            if (command.startsWith("adm")) {
                MovieDAO movieDAO = new MovieDAO();
                List<Movie> listaFilme;

                AccessDAO accessDAO = new AccessDAO();
                List<Access> listaUsuarios;

                if (command.endsWith("insertMovie")) {
                    rd = request.getRequestDispatcher("/insertMovie.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("readMovie")) {
                    listaFilme = movieDAO.read();
                    request.getSession().setAttribute("movies", listaFilme);
                    rd = request.getRequestDispatcher("/readMovie.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("updateMovie")) {
                    listaFilme = movieDAO.read();
                    request.getSession().setAttribute("movies", listaFilme);
                    rd = request.getRequestDispatcher("/updateMovie.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("deleteMovie")) {
                    listaFilme = movieDAO.read();
                    request.getSession().setAttribute("movies", listaFilme);
                    rd = request.getRequestDispatcher("/deleteMovie.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("readUser")) {
                    listaUsuarios = accessDAO.read();
                    request.getSession().setAttribute("users", listaUsuarios);
                    rd = request.getRequestDispatcher("/readUser.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("insertUser")) {
                    rd = request.getRequestDispatcher("/insertUser.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("deleteUser")) {
                    listaUsuarios = accessDAO.read();
                    request.getSession().setAttribute("users", listaUsuarios);
                    rd = request.getRequestDispatcher("/deleteUser.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("updateUser")) {
                    listaUsuarios = accessDAO.read();
                    request.getSession().setAttribute("users", listaUsuarios);
                    rd = request.getRequestDispatcher("/updateUser.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("functions")) {
                    rd = request.getRequestDispatcher("/admFunctions.jsp");
                    rd.forward(request, response);
                }

            }//FIM IF ADM

            if (command.startsWith("movie")) {
                int code = 0;
                MovieDAO movieDAO = new MovieDAO();
                if (command.endsWith("insert")) {

                    String title = request.getParameter("title");
                    int years = Integer.parseInt(request.getParameter("years"));
                    String director = request.getParameter("director");
                    int classification = Integer.parseInt(request.getParameter("classification"));
                    String genre = request.getParameter("genre");
                    String url = request.getParameter("url");

                    Movie movie = new Movie(title, years, director, classification, genre, url);

                    code = MovieManager.insert(movie);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/insertMovie.jsp");
                        rd.forward(request, response);
                    }
                }

                if (command.endsWith("delete")) {
                    int id = Integer.parseInt(request.getParameter("idMovie"));

                    code = MovieManager.delete(id);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/deleteMovie.jsp");
                        rd.forward(request, response);
                    }
                }

                if (command.endsWith("updateTitle")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    String title = request.getParameter("title");

                    code = MovieManager.updateTitle(idMovie, title);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }

                } else if (command.endsWith("updateYear")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    int year = Integer.parseInt(request.getParameter("years"));

                    code = MovieManager.updateYear(idMovie, year);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }
                } else if (command.endsWith("updateDirector")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    String director = request.getParameter("director");

                    code = MovieManager.updateDirector(idMovie, director);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }
                } else if (command.endsWith("updateClassification")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    int classification = Integer.parseInt(request.getParameter("classification"));

                    code = MovieManager.updateClassification(idMovie, classification);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }
                } else if (command.endsWith("updateGenre")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    String genre = request.getParameter("genre");

                    code = MovieManager.updateGenre(idMovie, genre);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }
                } else if (command.endsWith("updateUrl")) {

                    int idMovie = Integer.parseInt(request.getParameter("idMovie"));

                    String url = request.getParameter("url");

                    code = MovieManager.updateUrl(idMovie, url);

                    if (code == 1) {
                        rd = request.getRequestDispatcher("/admFunctions.jsp");
                        rd.forward(request, response);
                    } else {
                        rd = request.getRequestDispatcher("/updateMovie.jsp");
                        rd.forward(request, response);
                    }
                }
            }//FIM DO IF MOVIE

            if (command.startsWith("userAdm")) {
                int code = 0;
                int userNum = 0;
                int accessNum = 0;
                int accountNum = 0;
                int paymentNum = 0;

                if (command.endsWith("insertUser")) {

                    if (!UserManager.validaCPF(request.getParameter("cpf"))) {
                        rd = request.getRequestDispatcher("/insertUser.jsp");
                        rd.forward(request, response);
                    } else {

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

                        userNum = UserManager.insert(user);

                        if (userNum != 1) {
                            rd = request.getRequestDispatcher("/insertUser");
                            rd.forward(request, response);
                        } else {

                            String userName = request.getParameter("userName");
                            String pwd = request.getParameter("password");
                            String pwd2 = request.getParameter("password2");

                            Access access = new Access(userName, pwd);

                            access.setUserName(userName);
                            access.setPassword(pwd);

                            accessNum = AccessManager.insert(access, pwd2);

                            if (accessNum != 1) {
                                rd = request.getRequestDispatcher("/insertUser.jsp");
                                rd.forward(request, response);
                            } else {
                                String types = request.getParameter("types");
                                accountNum = AccountManager.insert(types);
                            }
                            if (accountNum == -1) {
                                rd = request.getRequestDispatcher("/insertUser.jsp");
                                rd.forward(request, response);
                            } else {

                                request.getSession().setAttribute("valorConta", accountNum);

                                if (!PaymentManager.validaNumberCard(request.getParameter("numberCard"))) {
                                    rd = request.getRequestDispatcher("/insertUser.jsp");
                                    rd.forward(request, response);
                                } else {

                                    String numberCard = request.getParameter("numberCard");

                                    int total = (int) request.getSession().getAttribute("valorConta");

                                    Date paymentDate = new Date();

                                    String status = "Em aberto";

                                    Payment payment = new Payment();

                                    payment.setNumberCard(numberCard);
                                    payment.setTotal(total);
                                    payment.setPaymentDate(paymentDate);
                                    payment.setStatus(status);

                                    paymentNum = PaymentManager.insert(payment);
                                }

                                if (paymentNum != -1) {
                                    code = 1;
                                }
                            }
                        }

                        if (code == 1) {
                            rd = request.getRequestDispatcher("/admFunctions.jsp");
                            rd.forward(request, response);
                        } else {
                            rd = request.getRequestDispatcher("/insertUser.jsp");
                            rd.forward(request, response);
                        }
                    }
                }

                if (command.endsWith("delete")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    code = UserManager.deleteUser(id);

                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("deleteUser.jsp");
                    }
                }

                if (command.endsWith("updateOwner")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String owner = request.getParameter("owner");

                    code = UserManager.updateOwner(id, owner);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateEmail")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String email = request.getParameter("email");

                    code = UserManager.updateEmail(id, email);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateCPF")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String cpf = request.getParameter("cpf");

                    code = UserManager.updateCPF(id, cpf);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateDate")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String bday = request.getParameter("bday");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date bday2 = null;
                    try {
                        bday2 = formatter.parse(bday);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    code = UserManager.updateDate(id, bday2);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }

                if (command.endsWith("updateUserType")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    int userType = Integer.parseInt(request.getParameter("userType"));

                    code = UserManager.updateUserType(id, userType);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateUserName")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String userName = request.getParameter("userName");

                    code = AccessManager.updateUserName(id, userName);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updatePassword")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String password = request.getParameter("password");

                    code = AccessManager.updatePassword(id, password);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateType")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String types = request.getParameter("types");

                    code = AccountManager.updateAccount(id, types);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
                if (command.endsWith("updateNumberCard")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    String numberCard = request.getParameter("numberCard");

                    code = PaymentManager.updateNumberCard(id, numberCard);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }

                if (command.endsWith("updateStatus")) {
                    int id = Integer.parseInt(request.getParameter("idUser"));

                    code = PaymentManager.updateStatus(id);
                    if (code == 1) {
                        response.sendRedirect("admFunctions.jsp");
                    } else {
                        response.sendRedirect("updateUser.jsp");
                    }
                }
            }//FIM DO IF USER ADM
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
