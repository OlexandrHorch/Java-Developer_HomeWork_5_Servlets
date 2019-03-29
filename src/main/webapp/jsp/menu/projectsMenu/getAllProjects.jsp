<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Project"%>
<%@ page import="fromHibernate.dao.ProjectDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Інформація про всі проекти</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/projectsMenu/projectsMenu">
                        <button type="submit" style="width:155px;height:30px">Меню проектів</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Інформація про всі проекти</h1>
        <form action="/menu/projectsMenu/getAllProjects" method="GET">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Назва</th>
                    <th>Компанія виконавець</th>
                    <th>Компанія клієнт</th>
                    <th>Вартість</th>
                </tr>
                    <%
                        StringJoiner result = new StringJoiner("");
                        ProjectDAO projectDAO = new ProjectDAO();
                        List<Project> projects = projectDAO.getAllProjects();
                        for(Project project: projects) {
                            result.add("<tr><th>");
                            result.add(String.valueOf(project.getId()));
                            result.add("</th><th>");
                            result.add(project.getName());
                            result.add("</th><th>");
                            result.add(project.getCompany().getName());
                            result.add("</th><th>");
                            result.add(project.getCustomer().getName());
                            result.add("</th><th>");
                            result.add(String.valueOf(project.getCost()));
                            result.add("</th></tr>");
                        }
                        out.println(result);
                    %>
            </table>
        </form>
    </body>
</html>