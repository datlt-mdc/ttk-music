<%-- 
    Document   : viewCart
    Created on : Aug 22, 2022, 2:35:18 PM
    Author     : doixu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><a href="MainController" style="text-decoration: none; color: black ">TTK Piano Music Center</a></h1>

        <c:if test="${USER == null}">
            <a href="MainController?btnAction=GoToLogin"><button>Login</button></a>
        </c:if>
        <c:if test="${USER != null}">
            <div>Welcome ${USER.name}</div>
            <a href="MainController?btnAction=Logout"><button>Logout</button></a> 
        </c:if>
        <a href="MainController"><button>Add more item</button></a> 
        <br/>

        ${CART_ERROR}
        ${CART_MESSAGE}
        <c:if test="${CART != null}" >
            <table border="1">

                <thead>

                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Tuition Fee</th>
                        <th>Quantity</th>
                        <th>Selected Quantity</th>
                        <th>Total price</th>
                        <th></th>
                        <th><%--Add to cart column--%></th>
                    </tr>

                </thead>

                <tbody>
                    <c:forEach var="item" varStatus="count" items="${CART}">
                    <form action="MainController">
                        <tr>                            
                            <td>${count.index+1}</td>
                            <td>${item.name}</td>
                            <td>${item.category}</td>
                            <td>
                                ${item.description != null ? item.description : "N/A"}
                            </td>
                            <td>
                                <c:if test="${item.startDate != null}">
                            <fmt:formatDate value="${item.startDate}" pattern="MM-dd-yyyy" />
                        </c:if>
                        </td>
                        <td>
                            <c:if test="${item.endDate != null}">
                            <fmt:formatDate value="${item.endDate}" pattern="MM-dd-yyyy" />
                        </c:if>
                        </td>
                        <td>${item.tuitionFee}</td>
                        <td>
                            ${item.quantity}
                        </td>
                        <td>
                            <input type="text" name="txtCourseBookedQuantity" value="${item.bookedQuantity}"/>
                        </td>
                        <td>${item.tuitionFee * item.bookedQuantity}</td>
                        <td>
                            <input type="hidden" name="txtCourseID" value="${item.ID}"/>
                            <a href="MainController?btnAction=RemoveFromCart&pk=${item.ID}">Remove from cart</a>
                        </td>
                        <td>
                            <input type="submit" value="Update quantity" name="btnAction" />
                        </td>
                        </tr>
                    </form>
                </c:forEach>

            </tbody> 
        </table>  
                        <h1>Total price ${TOTAL_PRICE}</h1>
    </c:if>        
</body>
</html>
