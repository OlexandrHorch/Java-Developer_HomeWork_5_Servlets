<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню проектів</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:320px;height:30px">Головне меню</button>
        </form>

        <h1>* Меню проектів *</h1>
                <form action="/menu/projectsMenu/createProject">
                    <button type="submit" style="width:320px;height:30px">Створити проект</button>
                </form>
            <br>
                <form action="/menu/projectsMenu/getAllProjects">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про всі проекти</button>
                </form>
            <br>
                <form action="/menu/projectsMenu/updateProjectById">
                    <button type="submit" style="width:320px;height:30px">Оновити інформацію про проект</button>
                </form>
            <br>
                <form action="/menu/projectsMenu/deleteProjectById">
                    <button type="submit" style="width:320px;height:30px">Видалити інформацію про проект</button>
                </form>
    </body>
</html>