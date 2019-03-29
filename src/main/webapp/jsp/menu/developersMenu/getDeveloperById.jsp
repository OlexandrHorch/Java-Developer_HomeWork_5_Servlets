<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.dao.DeveloperDAO"%>
<%@ page import="fromHibernate.entity.Developer"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Інформація про розробника</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
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

        <h1>Виберіть розробника для отримання інформації</h1>
            <form action="/menu/developersMenu/getDeveloperByIdAnswer" method="GET">
                <p>
                    <select required style="width:170px;height:30px" name="idDeveloper">
                    <option disabled>Виберіть id розробника</option>
                    <%
                    StringJoiner result = new StringJoiner("");
                    DeveloperDAO developerDAO = new DeveloperDAO();
                    List<Developer> developers = developerDAO.getAllDevelopers();
                    for(Developer developer: developers) {
                        result.add("<option>");
                        result.add(String.valueOf(developer.getId()));
                        result.add(" " + String.valueOf(developer.getFirstName()));
                        result.add("</option>");
                    }
                    out.println(result);
                    %>
                    </select>
                </p>

                <p>
                    <button style="width:170px;height:30px" type="submit">Показати інформацію</button>
                </p>
            </form>
    </body>
</html>