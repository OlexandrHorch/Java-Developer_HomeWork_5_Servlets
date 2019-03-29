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

        <h1>Виберіть компанію для оновлення інформації</h1>
            <form action="/menu/companiesMenu/updateCompanyByIdAnswer" method="GET">
                <p>
                    <select required style="width:170px;height:30px" name="idCompany">
                    <option disabled>Виберіть компанію</option>
                    <%
                        StringJoiner result = new StringJoiner("");
                        CompanyDAO companyDAO = new CompanyDAO();
                        List<Company> companies = companyDAO.getAllCompanies();
                        for(Company company: companies) {
                            result.add("<option>");
                            result.add(String.valueOf(company.getId()));
                            result.add(" " + String.valueOf(company.getName()));
                            result.add(" " + String.valueOf(company.getAddress()));
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