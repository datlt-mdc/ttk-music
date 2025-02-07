/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.account.AccountDTO;
import datlt.course.CourseDAO;
import datlt.course.CourseDTO;
import datlt.course.CourseError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CourseUpdateController", urlPatterns = {"/CourseUpdateController"})
public class CourseUpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String courseManagementPage = "WEB-INF/views/courseManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = courseManagementPage;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("txtCourseID"));
            String courseName = request.getParameter("txtCourseName");
            String courseCategory = request.getParameter("txtCourseCategory");
            String courseDescription = request.getParameter("txtCourseDescription");
            String courseImagePath = request.getParameter("txtCourseImagePath");
            String dateString = request.getParameter("startDate");
            Date startDate = null;
            if (!dateString.isEmpty()) {
                startDate = new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
            }
            dateString = request.getParameter("endDate");
            Date endDate = null;
            if (!dateString.isEmpty()) {
                endDate = new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
            }
            int tuitionFee = Integer.parseInt(request.getParameter("txtCourseTuitionFee"));
            int quantity = Integer.parseInt(request.getParameter("txtCourseQuantity"));
            Date lastUpdateDate = new Date();

            AccountDTO user = null;
            user = (AccountDTO) session.getAttribute("USER");
            String lastUpdateUsername = user.getUsername();
            String status = request.getParameter("chkActive") != null ? "Active" : "Disabled";

            //check error
            boolean foundError = false;
            CourseError errors = new CourseError();

            if (courseName.trim().length() < 3 || courseName.trim().length() > 50) {
                foundError = true;
                errors.setNameLengthErr("Course name is required 3 to 50 characters");
            }
            if (startDate != null
                    && endDate != null
                    && startDate.after(endDate)) {
                foundError = true;
                errors.setPeriodTimeErr("Start date must be before end date");
            }
            CourseDAO dao = new CourseDAO();
            
            if (foundError) {
                //send error to user
                request.setAttribute("ERROR", errors);
            } else {
                CourseDTO dto = new CourseDTO(id, courseName, courseImagePath, courseDescription,
                        tuitionFee, startDate, endDate, courseCategory,
                        quantity, lastUpdateDate, lastUpdateUsername, status);
                dao.update(dto);
            }
            dao.getAllCourse();
            request.setAttribute("AVAILIABLE_COURSES", dao.getListCourse());
            request.setAttribute("MESSAGE", "Update course success");

            request.getRequestDispatcher(url).forward(request, response);

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CourseUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
