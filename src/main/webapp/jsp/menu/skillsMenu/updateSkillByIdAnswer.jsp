<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Skill"%>
<%@ page import="fromHibernate.dao.SkillDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Оновлення інформації про розробника</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/skillsMenu/updateSkillById">
                        <button type="submit" style="width:320px;height:30px">Оновити інформацію про інше вміння</button>
                    </form>
                </th>
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

        <h1>Внесіть дані для оновлення інформації про розробника</h1>
            <form action="/menu/skillsMenu/updateSkillByIdAnswer2">

                <table border="1">
                    <tr>
                        <th>Інформація</th>
                        <th>Назва</th>
                        <th>Рівень</th>
                    </tr>

                    <tr>
                        <%
                            StringJoiner result = new StringJoiner("");
                            result.add("<th>");
                            result.add("наявна в базі");
                            result.add("</th><th>");
                            result.add(((Skill) request.getAttribute("skillById")).getArea());
                            result.add("</th><th>");
                            result.add(((Skill) request.getAttribute("skillById")).getLevel());
                            result.add("</th>");
                            out.println(result);
                        %>
                    </tr>

                    <tr>
                        <th>
                            для оновлення
                        </th>
                        <th>
                            <input required type="text" name="area" placeholder="">
                        </th>
                        <th>
                            <select required name="level">
                                <option disabled>Виберіть рівень</option>
                                <option>junior</option>
                                <option>middle</option>
                                <option>senior</option>
                            </select>
                        </th>
                    </tr>
                </table>

                <p>
                    <button type="submit" style="width:234px;height:30px">Оновити інформацію</button>
                </p>
            </form>
    </body>
</html>