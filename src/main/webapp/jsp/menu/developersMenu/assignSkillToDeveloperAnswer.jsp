<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringJoiner"%>
<%@ page import="fromHibernate.entity.Skill"%>
<%@ page import="fromHibernate.entity.Developer"%>
<%@ page import="fromHibernate.dao.SkillDAO"%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про вміння розробника</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table>
            <tr>
                <th>
                    <form action="/menu/developersMenu/assignSkillToDeveloper">
                        <button type="submit" style="width:330px;height:30px">Додати інформацію про вміння іншого розробника</button>
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

        <h1>
            Виберіть вміння для додавання до переліку вміннь розробника
            <%
                StringJoiner resultDeveloper = new StringJoiner("");
                resultDeveloper.add(((Developer) request.getAttribute("developerById")).getFirstName());
                out.println(resultDeveloper);
            %>
        </h1>

            <form action="/menu/developersMenu/assignSkillToDeveloperAnswer2" method="POST">
                <p>
                    <select required style="width:200px;height:30px" name="idSkill">
                    <option disabled>Виберіть id вміння</option>
                    <%
                        StringJoiner result = new StringJoiner("");
                        SkillDAO skillDAO = new SkillDAO();
                        List<Skill> skills = skillDAO.getAllSkills();
                        for(Skill skill: skills) {
                            result.add("<option>");
                            result.add(String.valueOf(skill.getId()));
                            result.add(" " + skill.getArea());
                            result.add(" " + skill.getLevel());
                            result.add("</option>");
                        }
                        out.println(result);
                    %>
                    </select>
                </p>

                <p>
                    <button style="width:200px;height:30px" type="submit">Додати вміння розробнику</button>
                </p>
            </form>
        <br>
            <table border="1">
                <caption>Перелік наявних вміннь розробника</caption>

                <tr height="40">
                    <th width="50">Id</th>
                    <th width="120">Area</th>
                    <th width="120">Level</th>
                </tr>
                <%
                    StringJoiner resultSkill = new StringJoiner("");
                    for (Skill skill : (((Developer) request.getAttribute("developerById")).getSkills())) {
                        resultSkill.add("<tr><th>");
                        resultSkill.add(String.valueOf(skill.getId()));
                        resultSkill.add("</th><th>");
                        resultSkill.add(skill.getArea());
                        resultSkill.add("</th><th>");
                        resultSkill.add(skill.getLevel());
                        resultSkill.add("</th></tr>");
                    }
                    out.println(resultSkill);
                %>
            </table>
    </body>
</html>