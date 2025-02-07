/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.cart.CartObj;
import datlt.course.CourseDAO;
import datlt.course.CourseDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "CourseViewCartController", urlPatterns = {"/CourseViewCartController"})
public class CourseViewCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String courseViewCartPage = "WEB-INF/views/viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String error;
        try {
            String url = courseViewCartPage;
            HttpSession session = request.getSession(false);
            if (session != null) {
                CartObj cartObj = (CartObj) session.getAttribute("CART_OBJECT");
                if (cartObj == null) {
                    error = "No items in cart";
                    request.setAttribute("CART_ERROR", error);
                } else {
                    if (cartObj.getItems() != null) {
                        CourseDAO dao = new CourseDAO();
                        Map<Integer, Integer> itemsInCart = cartObj.getItems();
                        List<CourseDTO> cart = new ArrayList<>();
                        int totalPrice = 0;

                        for (Map.Entry mapItem : itemsInCart.entrySet()) {
                            dao.searchByID(Integer.parseInt(mapItem.getKey().toString()));
                            CourseDTO item = dao.getCourse();
                            item.setBookedQuantity(Integer.parseInt(mapItem.getValue().toString()));

                            if (item.getStatus().equals("Active")) {
                                cart.add(item);
                                totalPrice += item.getTuitionFee() * item.getBookedQuantity();
                            }
                        }
                        request.setAttribute("TOTAL_PRICE", totalPrice);
                        request.setAttribute("CART", cart);
                    } else {
                        error = "No items in cart";
                        request.setAttribute("CART_ERROR", error);
                    }
                }
            } else {
                error = "No items in cart";
                request.setAttribute("CART_ERROR", error);
            }

            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
