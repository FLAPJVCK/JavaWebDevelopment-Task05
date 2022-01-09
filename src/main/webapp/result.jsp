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
    <title>List of banks</title>
</head>
<body>
<section>
    <table>
        <tr>
            <th style="padding-left: 30px;padding-right: 30px;">Bank's name</th>
            <th style="padding-left: 30px;padding-right: 30px;">Country of registration</th>
            <th style="padding-left: 30px;padding-right: 30px;">Deposit type</th>
            <th style="padding-left: 30px;padding-right: 30px;">Depositor's name</th>
            <th style="padding-left: 30px;padding-right: 30px;">Account number</th>
            <th style="padding-left: 30px;padding-right: 30px;">Deposit amount</th>
            <th style="padding-left: 30px;padding-right: 30px;">Annual Percentage</th>
            <th style="padding-left: 30px;padding-right: 30px;">Deposit term</th>
        </tr>
        <c:forEach var="item" items="${banks}">
            <tr style="text-align: center;">
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getCountry()}"/></td>
                <td><c:out value="${item.getType()}"/></td>
                <td><c:out value="${item.getDepositor()}"/></td>
                <td><c:out value="${item.getAccountId()}"/></td>
                <td><c:out value="${item.getAmountOnDeposit()}"/></td>
                <td><c:out value="${item.getProfitability()}"/></td>
                <td><c:out value="${item.getTimeConstrains()}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
