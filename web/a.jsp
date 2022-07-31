<%-- 
    Document   : editImageRoom
    Created on : Jul 31, 2022, 6:04:41 AM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Image Room Page</title>
    </head>
    <body>

        <form action="MainController" method="get">
            EXTRA IMAGE </br>
            ROOM   ${param.txtRoomId}
            <input type="hidden" name="txtRoomId" value="${param.txtRoomId}" />
            <input type="hidden" name="btn" value="Display Image Room" />
        </form>
        </br>

        <c:if test = "${not empty requestScope.GET_IMAGE_ROOM}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Extra Image</th>
                        <th>Save</th>
                    </tr>
                </thead>


                <tbody>

                    <c:forEach var="dto" items="${requestScope.GET_IMAGE_ROOM}" >

                        <tr>
                    <form action="MainController" method="get">
                        <td>
                            <img style="width: 370.75px; height: 247.36px;" src="images/${dto.imageTmp}" class="card-img-top" alt="...">
                            <input type="hidden" name="txtImageOld" value="${dto.imageTmp}" />
                            <input type="file" name="txtImage" value="${dto.imageTmp}" />
                        </td>

                        <td>
                            <input type="hidden" name="txtRoomId1" value="${param.txtRoomId}" />
                            <input type="hidden" name="txtId" value="${dto.id}" />
                            <input type="submit" value="Save Image" name="btn" />
                        </td>

                        <td>
                            <input type="hidden" name="txtRoomIdTmp" value="${param.txtRoomId}" />
                            <input type="hidden" name="txtIdTmp" value="${dto.id}" />
                            <input type="submit" value="Delete Image" name="btn" />
                        </td>
                    </form>

                </tr>

            </c:forEach> 
        </tbody>
    </table>
</c:if>



<c:if test = "${ empty requestScope.GET_IMAGE_ROOM}">Dont have extra photo , please add new photo</c:if>  </br>
    <form action="MainController" method="get">
        <input type="hidden" name="txtRoomId2" value="${param.txtRoomId}" />
    <input type="file" name="txtImageExtra" value="">
    <input type="submit" name="btn" value="Add New Image" />
</form>
</br>

</br>

<a href="MainController?txtSearchValue=&btn=SEARCH+ROOM"">Click here to back</a> 
</body>  
</html>