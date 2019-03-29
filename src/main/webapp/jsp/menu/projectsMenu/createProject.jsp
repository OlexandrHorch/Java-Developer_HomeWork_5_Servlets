<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Company"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>
<%@ page import="fromHibernate.entity.Customer"%>
<%@ page import="fromHibernate.dao.CustomerDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про проект</title>
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

        <h1>Заповніть інформацію про проект</h1>

            <form action="/menu/projectsMenu/createProjectAnswer" method="POST">
                <p>
                    <input required style="width:230px;height:20px" type="text" name="name" placeholder="назва">
                </p>

                <p>
                    <select required style="width:234px;height:28px" name="idCompany">
                    <option disabled>Виберіть компанію виконавця</option>
                    <%
                        StringJoiner resultCompany = new StringJoiner("");
                        CompanyDAO companyDAO = new CompanyDAO();
                        List<Company> companies = companyDAO.getAllCompanies();
                        for(Company company: companies) {
                            resultCompany.add("<option>");
                            resultCompany.add(String.valueOf(company.getId()));
                            resultCompany.add(" " + String.valueOf(company.getName()));
                            resultCompany.add("</option>");
                        }
                        out.println(resultCompany);
                    %>
                    </select>
                </p>

                <p>
                    <select required style="width:234px;height:28px" name="idCustomer">
                    <option disabled>Виберіть компанію клієнта</option>
                    <%
                        StringJoiner resultCustomer = new StringJoiner("");
                        CustomerDAO customerDAO = new CustomerDAO();
                        List<Customer> customers = customerDAO.getAllCustomers();
                        for(Customer customer: customers) {
                            resultCustomer.add("<option>");
                            resultCustomer.add(String.valueOf(customer.getId()));
                            resultCustomer.add(" " + String.valueOf(customer.getName()));
                            resultCustomer.add("</option>");
                        }
                        out.println(resultCustomer);
                    %>
                    </select>
                </p>

                <p>
                    <input required style="width:230px;height:20px" type="number" min="1" name="cost" placeholder="вартість">
                </p>

                <p>
                    <button type="submit" style="width:234px;height:30px">Додати інформацію</button>
                </p>
            </form>
    </body>
</html>