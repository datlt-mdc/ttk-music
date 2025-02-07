<%-- 
    Document   : index
    Created on : Aug 18, 2022, 3:10:46 PM
    Author     : doixu
--%>

<%@page import="java.util.List"%>
<%@page import="datlt.course.CourseDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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

        <c:if test="${USER.role == 'Customer' or USER.role == null}">
            <a href="MainController?btnAction=GoToViewCart"><button>View Cart</button></a> 
        </c:if>
        
        <br/>
        ${CART_MESSAGE}
        <table border="1">
            <c:if test="${AVAILIABLE_COURSES != null or NAME_SEARCH_VALUE != null or CATEGORY_SEARCH_VALUE != null}" >
                <thead>
                <form action="MainController">
                    <tr>
                        <th></th>
                        <th>
                            <input type="text" 
                                   placeholder="type name for search" 
                                   name="txtNameSearchValue"
                                   value="${NAME_SEARCH_VALUE}">
                        </th>
                        <th>
                            <input type="text" 
                                   placeholder="type category for search" 
                                   name="txtCategorySearchValue"
                                   value="${CATEGORY_SEARCH_VALUE}">
                        </th>
                        <th><input type="submit" value="Search courses" name="btnAction" /></th>
                        <th><a href="MainController"><button>Cancel search</button></a></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </form>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Tuition Fee</th>
                    <th>Quantity</th>
                    <th>Select Quantity</th>
                    <th><%--Add to cart column--%></th>
                </tr>

            </thead>
        </c:if>

        <c:if test="${AVAILIABLE_COURSES != null}">
            <tbody>
                <c:forEach var="course" varStatus="count" items="${AVAILIABLE_COURSES}">
                <form action="MainController">
                    <tr>                            
                        <td>${count.index+1}</td>
                        <td>${course.name}</td>
                        <td>${course.category}</td>
                        <td>
                            ${course.description != null ? course.description : "N/A"}
                        </td>
                        <td>
                            <img src="${course.imagePath}"/>
                        </td>
                        <td>
                            <c:if test="${course.startDate != null}">
                                <fmt:formatDate value="${course.startDate}" pattern="MM-dd-yyyy" />
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${course.endDate != null}">
                                <fmt:formatDate value="${course.endDate}" pattern="MM-dd-yyyy" />
                            </c:if>
                        </td>
                        <td>${course.tuitionFee}</td>
                        <td>
                            ${course.quantity}
                            <input type="hidden" name="txtCourseRemainingQuantity" value="${course.quantity}"/>
                        </td>
                        <td>
                            <input type="number" name="txtCourseQuantity" min="1" required=""/>
                        </td>
                        <td>
                            <input type="hidden" name="txtCourseID" value="${course.ID}"/>
                            <input type="submit" value="Add course to cart" name="btnAction" />
                        </td>
                    </tr>
                </form>
            </c:forEach>

        </tbody> 
    </c:if>                            
</table>  


<br/>
</body>
</html>