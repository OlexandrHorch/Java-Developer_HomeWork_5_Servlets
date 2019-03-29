<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.util.StringJoiner"%>
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
                    <form action="/menu/developersMenu/getDeveloperById">
                        <button type="submit" style="width:320px;height:30px">Показати інформацію про іншого розробника</button>
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

        <h1>Інформація про розробника</h1>
            <table border="1">
                <tr height="40">
                    <th width="70">Id</th>
                    <th>First name</th>
                    <th width="70">Age</th>
                    <th width="70">Id company</th>
                    <th width="70">Salary</th>
                </tr>
                <%
                    StringJoiner result = new StringJoiner("");
                    result.add("<tr><th>");
                    result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getId()));
                    result.add("</th><th>");
                    result.add(((Developer) request.getAttribute("developerById")).getFirstName());
                    result.add("</th><th>");
                    result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getAge()));
                    result.add("</th><th>");
                    result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getCompany().getId()));
                    result.add("</th><th>");
                    result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getSalary()));
                    result.add("</th></tr>");
                    out.println(result);
                %>
            </table>
    </body>
</html>