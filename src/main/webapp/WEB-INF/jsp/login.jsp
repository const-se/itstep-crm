<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="ru">
    <head>
        <meta charset="UTF-8"/>
        <title>Вход</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container p-5">
            <h1>Вход</h1>
            <form action="/login" method="POST" class="w-50 my-5">
                <div class="form-group">
                    <label for="username">Логин</label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-success">Войти</button>
                <a href="/registration" class="btn btn-secondary">Регистрация</a>
            </form>
        </div>
        <script src="/js/bootstrap.min.js"></script>
    </body>
</html>