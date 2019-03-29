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
                    <form action="/menu/otherMenu/sumDevelopersSalaryInProject">
                        <button type="submit" style="width:320px;height:30px">Зарплата всіх розробників іншого проекта</button>
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

        <h1>Зарплата всіх розробників проекта "
            <%
             out.println(((Project) request.getAttribute("projectById")).getName());
            %>
             " складає
            <%
             out.println(request.getAttribute("sumSalary"));
            %>
        </h1>

    </body>
</html>