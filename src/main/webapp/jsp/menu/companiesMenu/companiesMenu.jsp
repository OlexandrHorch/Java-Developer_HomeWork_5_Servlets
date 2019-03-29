<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню компаній</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:320px;height:30px">Головне меню</button>
        </form>

        <h1>* Меню компаній *</h1>
                <form action="/menu/companiesMenu/createCompany">
                    <button type="submit" style="width:320px;height:30px">Створити компанію</button>
                </form>
            <br>
                <form action="/menu/companiesMenu/getAllCompanies">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про всі компанії</button>
                </form>
            <br>
                <form action="/menu/companiesMenu/updateCompanyById">
                    <button type="submit" style="width:320px;height:30px">Оновити інформацію про компанію</button>
                </form>
            <br>
                <form action="/menu/companiesMenu/deleteCompanyById">
                    <button type="submit" style="width:320px;height:30px">Видалити інформацію про компанію</button>
                </form>
    </body>
</html>