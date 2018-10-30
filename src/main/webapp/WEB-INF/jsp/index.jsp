<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>CRM</title>
    </head>
    <body>
        <h1>Заявки</h1>
        <table>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.description}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>