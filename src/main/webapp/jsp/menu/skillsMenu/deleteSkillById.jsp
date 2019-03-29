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

        <h1>Виберіть розробника для видалення інформації</h1>
            <form action="/menu/skillsMenu/deleteSkillByIdAnswer">
                <p>
                    <select required style="width:170px;height:30px" name="idSkill">
                    <option disabled>Виберіть вміння</option>
                    <%
                    StringJoiner result = new StringJoiner("");
                    SkillDAO skillDAO = new SkillDAO();
                    List<Skill> skills = skillDAO.getAllSkills();
                    for(Skill skill: skills) {
                        result.add("<option>");
                        result.add(String.valueOf(skill.getId()));
                        result.add(" " + String.valueOf(skill.getArea()));
                        result.add(" " + String.valueOf(skill.getLevel()));
                        result.add("</option>");
                    }
                    out.println(result);
                    %>
                    </select>
                </p>

                <p>
                    <button style="width:170px;height:30px" type="submit">Видалити інформацію</button>
                </p>
            </form>
    </body>
</html>