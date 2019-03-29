<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Company"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Оновлення інформації про компанію</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/companiesMenu/updateCompanyById">
                        <button type="submit" style="width:320px;height:30px">Оновити інформацію про іншу компанію</button>
                    </form>
                </th>
                <th>
                    <form action="/menu/companiesMenu/companiesMenu">
                        <button type="submit" style="width:155px;height:30px">Меню компаній</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Внесіть дані для оновлення інформації про компанію</h1>
            <form action="/menu/companiesMenu/updateCompanyByIdAnswer2">

                <table border="1">
                    <tr>
                        <th>Інформація</th>
                        <th>Назва</th>
                        <th>Адреса</th>
                    </tr>

                    <tr>
                        <%
                            StringJoiner result = new StringJoiner("");
                            result.add("<th>");
                            result.add("наявна в базі");
                            result.add("</th><th>");
                            result.add(((Company) request.getAttribute("companyById")).getName());
                            result.add("</th><th>");
                            result.add(((Company) request.getAttribute("companyById")).getAddress());
                            result.add("</th>");
                            out.println(result);
                        %>
                    </tr>

                    <tr>
                        <th>
                            для оновлення
                        </th>
                        <th>
                            <input required type="text" name="name" placeholder="">
                        </th>
                        <th>
                            <input required type="text" name="address" placeholder="">
                        </th>
                    </tr>
                </table>

                <p>
                    <button type="submit" style="width:234px;height:30px">Оновити інформацію</button>
                </p>
            </form>
    </body>
</html>