<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Customer"%>
<%@ page import="fromHibernate.dao.CustomerDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про клієнта</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/customersMenu/createCustomer">
                        <button type="submit" style="width:320px;height:30px">Додати інформацію про іншого клієнта</button>
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

        <h1>Інформація про всіх клієнтів</h1>
        <form action="/menu/customersMenu/getAllCustomers" method="GET">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Назва</th>
                    <th>Адреса</th>
                </tr>
                <%
                    StringJoiner result = new StringJoiner("");
                    CustomerDAO customerDAO = new CustomerDAO();
                    List<Customer> customers = customerDAO.getAllCustomers();
                    for(Customer customer: customers) {
                        result.add("<tr><th>");
                        result.add(String.valueOf(customer.getId()));
                        result.add("</th><th>");
                        result.add(customer.getName());
                        result.add("</th><th>");
                        result.add(customer.getAddress());
                        result.add("</th></tr>");
                    }
                    out.println(result);
                %>
            </table>
        </form>
    </body>
</html>