<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Project"%>
<%@ page import="fromHibernate.dao.ProjectDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Зарплата всіх розробників окремого проекта</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
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

        <h1>Виберіть проект</h1>
            <form action="/menu/otherMenu/sumDevelopersSalaryInProjectAnswer">
                <p>
                    <select required style="width:320px;height:30px" name="idProject">
                    <option disabled>Виберіть проект</option>
                    <%
                        StringJoiner result = new StringJoiner("");
                        ProjectDAO projectDAO = new ProjectDAO();
                        List<Project> projects = projectDAO.getAllProjects();
                        for(Project project: projects) {
                            result.add("<option>");
                            result.add(String.valueOf(project.getId()));
                            result.add(" " + String.valueOf(project.getName()));
                            result.add("</option>");
                        }
                        out.println(result);
                    %>
                    </select>
                </p>

                <p>
                    <button style="width:320px;height:30px" type="submit">Отримати суму зарплат розробників</button>
                </p>
            </form>
    </body>
</html>