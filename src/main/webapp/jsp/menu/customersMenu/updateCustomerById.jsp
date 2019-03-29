<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
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

        <h1>Виберіть клієнта для оновлення інформації</h1>
            <form action="/menu/customersMenu/updateCustomerByIdAnswer" method="GET">
                <p>
                    <select required style="width:170px;height:30px" name="idCustomer">
                    <option disabled>Виберіть клієнта</option>
                        <%
                            StringJoiner result = new StringJoiner("");
                            CustomerDAO customerDAO = new CustomerDAO();
                            List<Customer> customers = customerDAO.getAllCustomers();
                            for(Customer customer: customers) {
                                result.add("<option>");
                                result.add(String.valueOf(customer.getId()));
                                result.add(" " + String.valueOf(customer.getName()));
                                result.add("</option>");
                            }
                            out.println(result);
                        %>
                    </select>
                </p>

                <p>
                    <button style="width:170px;height:30px" type="submit">Перейти до оновлення</button>
                </p>
            </form>
    </body>
</html>