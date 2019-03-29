<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>
<%@ page import="fromHibernate.entity.Company"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про розробників</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/skillsMenu/skillsMenu">
                        <button type="submit" style="width:155px;height:30px">Меню вмінь</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Заповніть інформацію про вміння</h1>

            <form action="/menu/skillsMenu/createSkillAnswer" method="POST">
                <p>
                    <input required style="width:230px;height:20px" type="text" name="area" placeholder="назва">
                </p>

                <p>
                    <select required style="width:234px;height:28px" name="level">
                    <option disabled>Виберіть рівень</option>
                    <option>junior</option>
                    <option>middle</option>
                    <option>senior</option>
                    </select>
                </p>

                <p>
                    <button type="submit" style="width:234px;height:30px">Додати інформацію</button>
                </p>
            </form>
    </body>
</html>