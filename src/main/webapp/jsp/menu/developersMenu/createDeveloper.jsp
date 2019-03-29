<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>
<%@ page import="fromHibernate.entity.Company"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про розробників</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
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

        <h1>Заповніть інформацію про розробника</h1>

            <form action="/menu/developersMenu/createDeveloperAnswer" method="POST">
                <p>
                    <input required style="width:230px;height:20px" type="text" name="firstName" placeholder="ім'я">
                </p>

                <p>
                    <input required style="width:230px;height:20px" type="number" min="10" max="70" name="age" placeholder="вік">
                </p>

                <p>
                    <select required style="width:234px;height:28px" name="idCompany">
                    <option disabled>Виберіть місце праці (idCompany)</option>
                    <%
                        StringJoiner result = new StringJoiner("");
                        CompanyDAO companyDAO = new CompanyDAO();
                        List<Company> companies = companyDAO.getAllCompanies();
                        for(Company company: companies) {
                            result.add("<option>");
                            result.add(String.valueOf(company.getId()));
                            result.add(" " + String.valueOf(company.getName()));
                            result.add("</option>");
                        }
                        out.println(result);
                    %>
                    </select>
                </p>

                <p>
                    <input required style="width:230px;height:20px" type="number" name="salary" placeholder="зарплата">
                </p>

                <p>
                    <button type="submit" style="width:234px;height:30px">Додати інформацію</button>
                </p>
            </form>
    </body>
</html>