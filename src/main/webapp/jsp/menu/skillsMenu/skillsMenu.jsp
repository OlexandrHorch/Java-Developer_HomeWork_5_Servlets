<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню вміннь</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:320px;height:30px">Головне меню</button>
        </form>

        <h1>* Меню вмінь *</h1>

                <form action="/menu/skillsMenu/createSkill">
                    <button type="submit" style="width:320px;height:30px">Додати інформацію про вміння</button>
                </form>
            <br>
                <form action="/menu/skillsMenu/getAllSkills">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про всі вміння</button>
                </form>
            <br>
                <form action="/menu/skillsMenu/updateSkillById">
                    <button type="submit" style="width:320px;height:30px">Оновити інформацію про вміння</button>
                </form>
            <br>
                <form action="/menu/skillsMenu/deleteSkillById">
                    <button type="submit" style="width:320px;height:30px">Видалити інформацію про вміння</button>
                </form>
    </body>
</html>