<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Project"%>
<%@ page import="fromHibernate.dao.ProjectDAO"%>
<%@ page import="fromHibernate.entity.Company"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>
<%@ page import="fromHibernate.entity.Customer"%>
<%@ page import="fromHibernate.dao.CustomerDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Оновлення інформації про проект</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/projectsMenu/updateProjectById">
                        <button type="submit" style="width:320px;height:30px">Оновити інформацію про інший проект</button>
                    </form>
                </th>
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

        <h1>Внесіть дані для оновлення інформації про проект</h1>
            <form action="/menu/projectsMenu/updateProjectByIdAnswer2">

                <table border="1">
                    <tr>
                        <th>Інформація</th>
                        <th>Назва</th>
                        <th>Компанія виконавець</th>
                        <th>Компанія клієнт</th>
                        <th>Вартість</th>
                    </tr>

                    <tr>
                        <%
                            StringJoiner result = new StringJoiner("");
                            result.add("<th>");
                            result.add("наявна в базі");
                            result.add("</th><th>");
                            result.add(((Project) request.getAttribute("projectById")).getName());
                            result.add("</th><th>");
                            result.add(((Project) request.getAttribute("projectById")).getCompany().getName());
                            result.add("</th><th>");
                            result.add(((Project) request.getAttribute("projectById")).getCustomer().getName());
                            result.add("</th><th>");
                            result.add(String.valueOf(((Project) request.getAttribute("projectById")).getCost()));
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
                            <select required name="idCompany">
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
                        </th>
                        <th>
                            <select required name="idCustomer">
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
                        </th>
                        <th>
                            <input required type="number" name="cost" placeholder="">
                        </th>
                    </tr>
                </table>

                <p>
                    <button type="submit" style="width:234px;height:30px">Оновити інформацію</button>
                </p>
            </form>
    </body>
</html>