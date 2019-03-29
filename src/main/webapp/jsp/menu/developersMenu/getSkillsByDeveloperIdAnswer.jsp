<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Skill"%>
<%@ page import="fromHibernate.entity.Developer"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Інформація про вміння розробника</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/developersMenu/getSkillsByDeveloperId">
                        <button type="submit" style="width:350px;height:30px">Показати інформацію про вміння іншого розробника</button>
                    </form>
                </th>
                <th>
                    <form action="/menu/developersMenu/developersMenu">
                        <button type="submit" style="width:155px;height:30px">Меню розробників</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Інформація про вміння розробника</h1>
            <table border="1">
                <tr height="40">
                    <th width="100">Area</th>
                    <th width="100">Level</th>
                </tr>
                <%
                    StringJoiner result = new StringJoiner("");
                    for (Skill skill : (((Developer) request.getAttribute("developerById")).getSkills())) {
                        result.add("<tr><th>");
                        result.add(skill.getArea());
                        result.add("</th><th>");
                        result.add(skill.getLevel());
                        result.add("</th></tr>");
                    }
                    out.println(result);
                %>
            </table>
    </body>
</html>