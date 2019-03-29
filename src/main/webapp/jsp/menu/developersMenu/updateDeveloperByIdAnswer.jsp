<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>
<%@ page import="fromHibernate.entity.Company"%>
<%@ page import="fromHibernate.entity.Developer"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Оновлення інформації про розробника</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/developersMenu/updateDeveloperById">
                        <button type="submit" style="width:320px;height:30px">Оновити інформацію про іншого розробника</button>
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

        <h1>Внесіть дані для оновлення інформації про розробника</h1>
            <form action="/menu/developersMenu/updateDeveloperByIdAnswer2">

                <table border="1">
                    <tr>
                        <th>Інформація</th>
                        <th>Ім'я</th>
                        <th>Вік</th>
                        <th>Id та назва компанії</th>
                        <th>Зарплата</th>
                    </tr>

                    <tr>
                        <%
                            StringJoiner result = new StringJoiner("");
                            result.add("<th>");
                            result.add("наявна в базі");
                            result.add("</th><th>");
                            result.add(((Developer) request.getAttribute("developerById")).getFirstName());
                            result.add("</th><th>");
                            result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getAge()));
                            result.add("</th><th>");
                            result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getCompany().getId()));
                            result.add(" " + String.valueOf(((Developer) request.getAttribute("developerById")).getCompany().getName()));
                            result.add("</th><th>");
                            result.add(String.valueOf(((Developer) request.getAttribute("developerById")).getSalary()));
                            result.add("</th>");
                            out.println(result);
                        %>
                    </tr>

                    <tr>
                        <th>
                            для оновлення
                        </th>
                        <th>
                            <input required type="text" name="firstName" placeholder="">
                        </th>
                        <th>
                            <input required type="number" name="age" min="10" max="70" placeholder="">
                        </th>
                        <th>
                            <select required name="idCompany">
                                <option disabled></option>
                                <%
                                    StringJoiner result2 = new StringJoiner("");
                                    CompanyDAO companyDAO = new CompanyDAO();
                                    List<Company> companies = companyDAO.getAllCompanies();
                                    for(Company company: companies) {
                                        result2.add("<option>");
                                        result2.add(String.valueOf(company.getId()));
                                        result2.add(" " + String.valueOf(company.getName()));
                                        result2.add("</option>");
                                    }
                                    out.println(result2);
                                %>
                            </select>
                        </th>
                        <th>
                            <input required type="number" name="salary" placeholder="">
                        </th>
                    </tr>
                </table>

                <p>
                    <button type="submit" style="width:234px;height:30px">Оновити інформацію</button>
                </p>
            </form>
    </body>
</html>