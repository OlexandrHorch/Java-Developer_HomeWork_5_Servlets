<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Skill"%>
<%@ page import="fromHibernate.dao.SkillDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Видалення інформації про вміння</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/skillsMenu/deleteSkillById">
                        <button type="submit" style="width:320px;height:30px">Видалити інформацію про інше вміння</button>
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

        <h1>Інформація про всіх розробників</h1>

        <form action="/menu/skillsMenu/getAllSkills" method="GET">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th width="100">Area</th>
                    <th width="100">Level</th>
                </tr>
                <%
                StringJoiner result = new StringJoiner("");
                SkillDAO skillDAO = new SkillDAO();
                List<Skill> skills = skillDAO.getAllSkills();
                for(Skill skill: skills) {
                    result.add("<tr><th>");
                    result.add(String.valueOf(skill.getId()));
                    result.add("</th><th>");
                    result.add(skill.getArea());
                    result.add("</th><th>");
                    result.add(skill.getLevel());
                    result.add("</th></tr>");
                }
                out.println(result);
                %>
            </table>
        </form>
    </body>
</html>