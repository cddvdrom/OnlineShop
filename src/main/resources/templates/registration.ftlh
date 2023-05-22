<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

    <table>
        <form action="/new" method="post">
        <tr>
            <td>Введите имя :</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Введите email :</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>Введите пароль еще раз:</td>
            <td><input type="password" name="matchPassword"></td>
        </tr>
        <tr><td>

            <input type="submit" value="Зарегистрироваться">

            </td>
        </tr>
        </form>
    </table>

</body>
</html>