/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.account.AccountDTO;
import datlt.course.CourseDAO;
import datlt.course.CourseDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "CourseSearchController", urlPatterns = {"/CourseSearchController"})
public class CourseSearchController extends HttpServlet {

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
    private final String courseManagementPage = "WEB-INF/views/courseManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = indexPage;
        HttpSession session = request.getSession();
        AccountDTO user = (AccountDTO) session.getAttribute("USER");
        String nameSearchValue = request.getParameter("txtNameSearchValue");
        String categorySearchValue = request.getParameter("txtCategorySearchValue");
        try (PrintWriter out = response.getWriter()) {

            CourseDAO dao = new CourseDAO();

            if (!nameSearchValue.trim().isEmpty() && categorySearchValue.trim().isEmpty()) {
                dao.searchByName(nameSearchValue.trim());
            } else {
                if (nameSearchValue.trim().isEmpty() && !categorySearchValue.trim().isEmpty()) {
                    dao.searchByCategory(categorySearchValue.trim());
                } else {
                    dao.searchByNameAndCategory(nameSearchValue.trim(), categorySearchValue.trim());
                }
            }
            List<CourseDTO> result = null;
            
            if (user == null) {
                result = dao.getAvailiableListCourse();

            } else {
                if (user.getRole().equals("Admin") || user.getRole().equals("Admin Manager")) {
                    url = courseManagementPage;
                    result = dao.getListCourse();
                } else {
                    result = dao.getAvailiableListCourse();
                }
            }

            request.setAttribute("AVAILIABLE_COURSES", result);
            request.setAttribute("NAME_SEARCH_VALUE", nameSearchValue);
            request.setAttribute("CATEGORY_SEARCH_VALUE", categorySearchValue);

            request.getRequestDispatcher(url).forward(request, response);
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
