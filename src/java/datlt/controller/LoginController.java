/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.account.AccountDAO;
import datlt.account.AccountDTO;
import datlt.course.CourseDAO;
import datlt.course.CourseDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author doixu
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String indexPage = "WEB-INF/views/index.jsp";
    private final String loginPage = "WEB-INF/views/login.jsp";
    private final String courseManagementPage = "WEB-INF/views/courseManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = loginPage;
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.checkLogin(username, password);
            AccountDTO account = accountDAO.getAccount();

            HttpSession session = request.getSession();

            if (account == null) {
                request.setAttribute("USERNAME", username);
                request.setAttribute("MESSAGE", "User ID or Password is incorrect!");

            } else {
                if (account.getStatus().equals("Active")) {
                    List<CourseDTO> courseList = null;
                    session.setAttribute("USER", account);

                    CourseDAO coursesDAO = new CourseDAO();
                    coursesDAO.getAllCourse();

                    if (account.getRole().equals("Customer")) {
                        courseList = coursesDAO.getAvailiableListCourse();
                        url = indexPage;
                    } else {
                        courseList = coursesDAO.getListCourse();
                        url = courseManagementPage;
                    }


                    //save to session
                    request.setAttribute("AVAILIABLE_COURSES", courseList);
                } else {
                    request.setAttribute("MESSAGE", "This account is disabled!");
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
