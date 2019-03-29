<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Додавання інформації про компанію</title>
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

        <h1>Заповніть інформацію про компанію</h1>

            <form action="/menu/companiesMenu/createCompanyAnswer" method="POST">
                <p>
                    <input required style="width:230px;height:20px" type="text" name="name" placeholder="назва">
                </p>

                <p>
                    <input required style="width:230px;height:20px" type="text" name="address" placeholder="адреса">
                </p>

                <p>
                    <button type="submit" style="width:234px;height:30px">Додати інформацію</button>
                </p>
            </form>
    </body>
</html>