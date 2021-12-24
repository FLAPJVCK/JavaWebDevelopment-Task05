<%--
  Created by IntelliJ IDEA.
  User: vaske
  Date: 10.12.2021
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of medicines</title>
</head>
<body>
<section>
    <table>
        <tr>
            <th>Название</th>
            <th>Производитель</th>
            <th>Группа</th>
            <th>Аналоги</th>
            <th>Вариации</th>
            <th>Сертификат</th>
            <th>Упаковка</th>
            <th>Дозировка</th>
        </tr>
        <c:forEach var="item" items="${medicines}">
            <tr>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getPharm()}"/></td>
                <td><c:out value="${item.getGroup()}"/></td>
                <td><c:out value="${item.getAnalogs()}"/>
                    <c:forEach var="item" items="${item.getAnalogs()}">
                        ${item},
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
