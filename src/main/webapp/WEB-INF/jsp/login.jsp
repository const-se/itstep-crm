<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="ru">
    <head>
        <meta charset="UTF-8"/>
        <title>Авторизация</title>
    </head>
    <body>
        <h1>Вход</h1>
        <form action="/login" method="POST">
            <label for="username">Логин</label><br/>
            <input type="text" id="username" name="username"/><br/>
            <label for="password">Пароль</label><br/>
            <input type="password" id="password" name="password"/><br/>
            <br/>
            <button type="submit">Войти</button>
        </form>
        <br/>
        <a href="/registration">Регистрация</a>
    </body>
</html>