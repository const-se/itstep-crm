<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ru">
    <head>
        <meta charset="UTF-8"/>
        <title>Регистрация</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container p-5">
            <h1>Регистрация</h1>
            <form:form action="/register" method="POST" modelAttribute="user" class="w-50 my-5">
                <div class="form-group">
                    <form:label path="username">Логин</form:label>
                    <form:input path="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Пароль</form:label>
                    <form:password path="password" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-success">Зарегистрироваться</button>
                <a href="/login" class="btn btn-secondary">Войти</a>
            </form:form>
        </div>
        <script src="/js/bootstrap.min.js"></script>
    </body>
</html>