<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню розробників</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:320px;height:30px">Головне меню</button>
        </form>

        <h1>* Меню розробників *</h1>
                <form action="/menu/developersMenu/createDeveloper">
                    <button type="submit" style="width:320px;height:30px">Додати інформацію про розробника</button>
                </form>
            <br>
                <form action="/menu/developersMenu/getDeveloperById">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про розробника</button>
                </form>
            <br>
                <form action="/menu/developersMenu/getAllDevelopers">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про всіх розробників</button>
                </form>
            <br>
                <form action="/menu/developersMenu/updateDeveloperById">
                    <button type="submit" style="width:320px;height:30px">Оновити інформацію про розробника</button>
                </form>
            <br>
                <form action="/menu/developersMenu/deleteDeveloperById">
                    <button type="submit" style="width:320px;height:30px">Видалити інформацію про розробника</button>
                </form>
            <br>
                <form action="/menu/developersMenu/getSkillsByDeveloperId">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про вміння розробника</button>
                </form>
            <br>
                <form action="/menu/developersMenu/assignSkillToDeveloper">
                    <button type="submit" style="width:320px;height:30px">Додати інформацію про вміння розробника</button>
                </form>
    </body>
</html>