<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню інших запитів</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:350px;height:30px">Головне меню</button>
        </form>

        <h1>* Меню інших запитів *</h1>
                <form action="/menu/otherMenu/sumDevelopersSalaryInProject">
                    <button type="submit" style="width:350px;height:30px">Зарплата всіх розробників окремого проекта</button>
                </form>
            <br>
                <form action="/menu/otherMenu/getDevelopersInProject">
                    <button type="submit" style="width:350px;height:30px">Список розробників окремого проекта</button>
                </form>
    </body>
</html>