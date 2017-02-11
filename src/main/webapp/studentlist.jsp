<%--
  Created by IntelliJ IDEA.
  User: free
  Date: 17-2-7
  Time: 下午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>birthday</td>
    </tr>
    <c:forEach var="stu" items="${requestScope.list}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/api/stu/editstudent/${stu.id}">${stu.id}</a></td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></td>
        </tr>
    </c:forEach>

</table>

<form action="${pageContext.request.contextPath}/api/stu/getlist" method="post">

    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>birthday</td>
        </tr>
        <c:forEach var="stu" items="${requestScope.list}" varStatus="status">
            <tr>
                <td><input name="studentList[${status.index}].id" value="${stu.id}"/></td>
                <td><input name="studentList[${status.index}].name" value="${stu.name}"/></td>
                <td><input name="studentList[${status.index}].age" value="${stu.age}"/></td>
                <td><input name="studentList[${status.index}].birthday" value="<fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/>"/></td>
            </tr>
        </c:forEach>
    </table>
        <input type="submit" value="submit"/>
</form>

</body>
</html>
