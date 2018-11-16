<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ru">
    <head>
        <meta charset="UTF-8"/>
        <title>Авторизация</title>
    </head>
    <body>
        <h1>Регистрация</h1>
        <form:form action="/register" method="POST" modelAttribute="user">
            <form:label path="username">Логин</form:label><br/>
            <form:input path="username"/><br/>
            <form:label path="password">Пароль</form:label><br/>
            <form:password path="password"/><br/>
            <br/>
            <button type="submit">Зарегистрироваться</button>
        </form:form>
        <br/>
        <a href="/login">Войти</a>
    </body>
</html>