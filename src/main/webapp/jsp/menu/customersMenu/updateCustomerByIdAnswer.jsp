<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Customer"%>
<%@ page import="fromHibernate.dao.CustomerDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Оновлення інформації про клієнта</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/customersMenu/updateCustomerById">
                        <button type="submit" style="width:320px;height:30px">Оновити інформацію про іншого клієнта</button>
                    </form>
                </th>
                <th>
                    <form action="/menu/customersMenu/customersMenu">
                        <button type="submit" style="width:155px;height:30px">Меню клієнтів</button>
                    </form>
                </th>
                <th>
                   <form action="/">
                        <button type="submit" style="width:155px;height:30px">Головне меню</button>
                    </form>
                </th>
            </tr>
        </table>

        <h1>Внесіть дані для оновлення інформації про клієнта</h1>
            <form action="/menu/customersMenu/updateCustomerByIdAnswer2">

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
                            result.add(((Customer) request.getAttribute("customerById")).getName());
                            result.add("</th><th>");
                            result.add(((Customer) request.getAttribute("customerById")).getAddress());
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