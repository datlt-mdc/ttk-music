<%-- 
    Document   : courseManagement
    Created on : Aug 18, 2022, 9:19:39 PM
    Author     : doixu
--%>

<%@page import="datlt.course.CourseDTO"%>
<%@page import="java.util.List"%>
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
        <h1>TTK Piano Music Center</h1>

        <c:if test="${USER == null}">
            <a href="MainController?btnAction=GoToLogin"><button>Login</button></a>
        </c:if>
        <c:if test="${USER != null}">
            <div>Welcome ${USER.name}</div>
            <a href="MainController?btnAction=Logout"><button>Logout</button></a> 
        </c:if>

        <br/>
        <a href="MainController?btnAction=GoToAddNewCourse"><button>Add new course</button></a>    

        <table border="1">
            <c:if test="${AVAILIABLE_COURSES != null or NAME_SEARCH_VALUE != null or CATEGORY_SEARCH_VALUE != null}" >
                <thead>
                <form action="MainController">
                    <tr>
                        <th></th>
                        <th><input type="text" 
                                   placeholder="type name for search" 
                                   name="txtNameSearchValue" 
                                   value="${NAME_SEARCH_VALUE}">
                        </th>
                        <th><input type="text" 
                                   placeholder="type category for search" 
                                   name="txtCategorySearchValue"
                                   value="${CATEGORY_SEARCH_VALUE}">
                        </th>
                        <th><input type="submit" value="Search courses" name="btnAction" /></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
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
                        <th>Update Date</th>
                        <th>Update User</th>
                        <th>Status</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>

                    <c:if test="${ERROR != null}">
                        <tr>
                            <th></th>
                            <th>${EERROR.nameLengthErr}</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th>${ERROR.periodTimeErr}</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>

                        </tr>
                    </c:if>
                </form>
            </thead>
        </c:if>
        <c:if test="${AVAILIABLE_COURSES != null}">
            <tbody>
            <br/>
            <br/>
            <br/>
            ${MESSAGE}
            <c:forEach var="course" varStatus="count" items="${AVAILIABLE_COURSES}">
                <form action="MainController" method="POST">
                    <tr>                            
                        <td>
                            ${count.index+1}
                            <input name="txtCourseID" type="hidden" value="${course.ID}" />
                        </td>
                        <td>
                            <input name="txtCourseName" type="text" value="${course.name}" />
                        </td>
                        <td>
                            <input name="txtCourseCategory" type="text" value="${course.category}" />
                        </td>
                        <td>
                            <input name="txtCourseDescription" type="text" value="${course.description}" />
                        </td>
                        <td>
                            <input name="txtCourseImagePath" type="text" value="${course.imagePath}" />
                            <img src="${course.imagePath}"/>
                        </td>
                        <td>
                            <input type="date" name="startDate" value="${course.startDate}" />
                        </td>
                        <td>
                            <input type="date" name="endDate" value="${course.endDate}" />
                        </td>
                        <td>
                            <input name="txtCourseTuitionFee" type="text" value="${course.tuitionFee}" />
                        </td>
                        <td>
                            <input name="txtCourseQuantity" type="text" value="${course.quantity}" />
                        </td>
                        <td>
                            <c:if test="${course.lastUpdateDate != null}">
                                <fmt:formatDate value="${course.lastUpdateDate}" pattern="MM-dd-yyyy" />
                            </c:if>
                        </td>
                        <td>${course.lastUpdateUsername}</td>
                        <td>
                            <input type="checkbox" name="chkActive" ${course.status == "Active" ? "checked":""}
                        </td>
                        <td>
                            <a href="MainController?btnAction=DeleteCourse&pk=${course.ID}">Delete</a>
                        </td>                            
                        <td>
                            <input name="txtLastSearchValue" type="hidden" value="${course.quantity}" />
                            <input type="submit" value="Update course" name="btnAction" />
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
