<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.dao.DeveloperDAO"%>
<%@ page import="fromHibernate.entity.Developer"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Видалення інформації про розробників</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/developersMenu/deleteDeveloperById">
                        <button type="submit" style="width:320px;height:30px">Видалити інформацію про іншого розробника</button>
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

        <h1>Інформація про всіх розробників</h1>

        <form action="/menu/developersMenu/getAllDevelopers" method="GET">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>First name</th>
                    <th>Age</th>
                    <th>Id company</th>
                    <th>Salary</th>
                </tr>
                <%
                    StringJoiner result = new StringJoiner("");
                    DeveloperDAO developerDAO = new DeveloperDAO();
                    List<Developer> developers = developerDAO.getAllDevelopers();
                    for(Developer developer: developers) {
                        result.add("<tr><th>");
                        result.add(String.valueOf(developer.getId()));
                        result.add("</th><th>");
                        result.add(developer.getFirstName());
                        result.add("</th><th>");
                        result.add(String.valueOf(developer.getAge()));
                        result.add("</th><th>");
                        result.add(String.valueOf(developer.getCompany().getId()));
                        result.add("</th><th>");
                        result.add(String.valueOf(developer.getSalary()));
                        result.add("</th></tr>");
                    }
                    out.println(result);
                %>
            </table>
        </form>
    </body>
</html>