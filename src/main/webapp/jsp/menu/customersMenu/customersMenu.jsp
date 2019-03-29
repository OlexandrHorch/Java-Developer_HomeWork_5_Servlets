<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Меню клієнтів</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <form action="/">
            <button type="submit" style="width:320px;height:30px">Головне меню</button>
        </form>
        <h1>* Меню клієнтів *</h1>
                <form action="/menu/customersMenu/createCustomer">
                    <button type="submit" style="width:320px;height:30px">Створити клієнта</button>
                </form>
            <br>
                <form action="/menu/customersMenu/getAllCustomers">
                    <button type="submit" style="width:320px;height:30px">Показати інформацію про всіх клієнтів</button>
                </form>
            <br>
                <form action="/menu/customersMenu/updateCustomerById">
                    <button type="submit" style="width:320px;height:30px">Оновити інформацію про клієнта</button>
                </form>
            <br>
                <form action="/menu/customersMenu/deleteCustomerById">
                    <button type="submit" style="width:320px;height:30px">Видалити інформацію про клієнта</button>
                </form>
    </body>
</html>