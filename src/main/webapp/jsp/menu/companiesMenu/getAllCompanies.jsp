<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Company"%>
<%@ page import="fromHibernate.dao.CompanyDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Інформація про всі компанії</title>
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

        <h1>Інформація про всі компанії</h1>
        <form action="/menu/companiesMenu/getAllCompanies" method="GET">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Address</th>
                </tr>
                <%
                    StringJoiner result = new StringJoiner("");
                    CompanyDAO companyDAO = new CompanyDAO();
                    List<Company> companies = companyDAO.getAllCompanies();
                    for(Company company: companies) {
                        result.add("<tr><th>");
                        result.add(String.valueOf(company.getId()));
                        result.add("</th><th>");
                        result.add(company.getName());
                        result.add("</th><th>");
                        result.add(company.getAddress());
                        result.add("</th></tr>");
                    }
                    out.println(result);
                %>
            </table>
        </form>
    </body>
</html>