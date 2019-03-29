<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Project"%>
<%@ page import="fromHibernate.dao.ProjectDAO"%>
<%@ page import="fromHibernate.entity.Developer"%>
<%@ page import="fromHibernate.dao.DeveloperDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Список розробників окремого проекта</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/otherMenu/getDevelopersInProject">
                        <button type="submit" style="width:250px;height:30px">Список розробників іншого проекта</button>
                    </form>
                </th>
                <th>
                    <form action="/menu/otherMenu/otherMenu">
                        <button type="submit" style="width:155px;height:30px">Меню інших запитів</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Список розробників проекта "
            <%
             out.println(((Project) request.getAttribute("projectById")).getName());
            %>
             "
        </h1>

        <form action="/menu/otherMenu/getDevelopersInProjectAnswer" method="GET">
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
                    for (Developer developer : (((Project) request.getAttribute("projectById")).getDevelopers())) {
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