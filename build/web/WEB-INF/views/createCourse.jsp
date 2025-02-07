<%-- 
    Document   : createCourse
    Created on : Aug 20, 2022, 11:11:29 AM
    Author     : doixu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TTK Piano Music Center</h1>
        <a href="MainController"><button>Back to list</button></a>    
        <h2>Create new course</h2>

        <table>
            <form action="MainController"
                  <tr>
                    <td>Name*</td>
                    <td>
                        <input name="txtCourseName" type="text" value="${INPUT_VALUE.name}" required/>
                        ${ERROR.nameLengthErr}
                    </td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td><input name="txtCourseCategory" type="text" value="${INPUT_VALUE.category}"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input name="txtCourseDescription" type="text" value="${INPUT_VALUE.description}"/></td>
                </tr>
                <tr>
                    <td>Image Path</td>
                    <td><input name="txtCourseImagePath" type="text" value="${INPUT_VALUE.imagePath}"/></td>
                </tr>
                <tr>
                    <td>Start Date</td>
                    <td><input type="date" name="startDate" value="${INPUT_VALUE.startDate}"/></td>
                </tr>
                <tr>
                    <td>End Date</td>
                    <td>
                        <input type="date" name="endDate" value="${INPUT_VALUE.endDate}"/>
                        ${ERROR.periodTimeErr}
                    </td>
                </tr>
                <tr>
                    <td>Tuition Fee*</td>
                    <td><input type="number" name="txtCourseTuitionFee" value="${INPUT_VALUE.tuitionFee}" required/></td>
                </tr>
                <tr>
                    <td>Quantity*</td>
                    <td><input type="number" name="txtCourseQuantity" value="${INPUT_VALUE.quantity}" required/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add new course" name="btnAction" /></td>
                </tr>
            </form>
        </table>

    </body>
</html>
