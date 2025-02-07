/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.account.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String nullController = "NullController";
    private final String loginController = "LoginController";
    private final String loginPage = "WEB-INF/views/login.jsp";
    private final String logoutController = "LogoutController";

    private final String courseSearchController = "CourseSearchController";
    private final String courseDeleteController = "CourseDeleteController";
    private final String courseUpdateController = "CourseUpdateController";
    private final String courseCreateController = "CourseCreateController";

    private final String courseAddToCartController = "CourseAddToCartController";
    private final String courseRemoveFromCartController = "CourseRemoveFromCartController";
    private final String courseViewCartController = "CourseViewCartController";
    private final String courseUpdateCartItemController = "CourseUpdateCartItemController";
    private final String addNewCoursePage = "WEB-INF/views/createCourse.jsp";
    private final String courseViewCartPage = "WEB-INF/views/viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("btnAction");
        String url = loginPage;

        HttpSession session = request.getSession();
        AccountDTO user = (AccountDTO) session.getAttribute("USER");
        if (user == null) {
            user = new AccountDTO();
            user.setRole("None");
        }

        //Get user info from cookie, then login to get role
        try (PrintWriter out = response.getWriter();) {
            if (action == null) {
                url = nullController;
            } else if (action.equals("Login")) {
                url = loginController;
            } else if (action.equals("Logout")) {
                url = logoutController;
            } else if (action.equals("DeleteCourse")) {
                if (user.getRole().contains("Admin")) {
                    url = courseDeleteController;
                } else {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                }
            } else if (action.equals("Update course")) {
                if (user.getRole().contains("Admin")) {
                    url = courseUpdateController;
                } else {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                }
            } else if (action.equals("Add new course")) {
                if (user.getRole().contains("Admin")) {
                    url = courseCreateController;
                } else {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                }
            } else if (action.equals("Search courses")) {
                url = courseSearchController;
            } else if (action.equals("Add course to cart")) {
                if (user.getRole().contains("Admin")) {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                } else {
                    url = courseAddToCartController;
                }
            } else if (action.equals("RemoveFromCart")) {
                if (user.getRole().contains("Admin")) {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                } else {
                    url = courseRemoveFromCartController;
                }
            } else if (action.equals("Update quantity")) {                
                if (user.getRole().contains("Admin")) {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                } else {
                    url = courseUpdateCartItemController;
                }
            } else if (action.equals("GoToLogin")) {
                url = loginPage;
            } else if (action.equals("GoToAddNewCourse")) {                
                if (user.getRole().contains("Admin")) {
                    url = addNewCoursePage;
                } else {
                    url = loginPage;
                    request.setAttribute("MESSAGE", "You need to be login to perform this action");
                }
            } else if (action.equals("GoToViewCart")) {                
                if (user.getRole().contains("Admin")) {
                    url = loginPage;
                    session.setAttribute("MESSAGE", "You need to be login to perform this action");
                } else {
                    url = courseViewCartController;
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
