<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin page</title>
</head>
<style>
    body, html {
        padding: 0px;
        margin: 0px;


    }

    .container {

        width: 100%;
        display: flex;
        flex-direction: row;

        justify-content: center;

    }

    .left {
        flex-direction: column;
        width: 100%;
        display: flex;
        align-items: center;
    }

    .right {

        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: left;
    }

    td {
        border: 1px solid black;
    }

    table {
        width: 100%;
    }

    input {
        width: 100%
    }

    td {
        width: 200px;
    }

    th {
        width: 200px
    }
</style>
<body>
<div class="container">
    <div class="left">
        <div>
            <h3>Cписок товаров :</h3>
        </div>
        <div>
            <table>

                <th>Название</th>
                <th>Марка</th>
                <th>Цена</th>
                <th></th>

                <br>
                <#list products as product>

                    <tr>
                        <form action="/edit/${product.id}" method="get">
                            <td><input type="text" value="${product.name}" name="name"></td>
                            <td><input type="text" value="${product.mark}" name="mark"></td>
                            <td><input type="number" value="${product.price}" name="price"></td>
                            <td><a href="/delete/${product.id}">удалить товар</a></td>
                            <td><input type="submit" value="сохранить изменения"></td>
                        </form>
                    </tr>
                </#list>
            </table>
        </div>


        <div>
            <h3>Cписок пользователей:</h3>
        </div>
        <div>
            <table>
<tr>
                <th>Имя</th>
                <th>Почта</th>
                <th>Пароль</th>
                <th>Активен</th>
                <th>Роль</th>
</tr>
                <#list users as user>

                    <tr>
                            <td><${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>
                        <td>${user.getActive()}</td>
                        <td>${user.getRole()}</td>

                    </tr>
                </#list>
            </table>
        </div>

    </div>
    <div class="right">
        <table>
            <th>Создать новый товар</th>
            <form action="/create" method="post" enctype="multipart/form-data">
                <tr>
                    <td>
                        Название
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Марка
                    </td>
                    <td>
                        <input type="text" name="mark">
                    </td>
                </tr>
                <tr>
                    <td>
                        Описание
                    </td>
                    <td><input type="text" name="description"></td>
                </tr>
                <tr>
                    <td>Цена</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>Категория</td>
                    <td><select name="category" id="category">
                            <#list categories as cat>
                                <option value="${cat.id}">${cat.name}</option>
                            </#list>
                        </select></td>
                </tr>
                <tr>

                    <td>Изображение 1</td>
                    <td><input type="file" name="file1"></td>
                </tr>
                <tr>
                    <td>Изображение 2</td>
                    <td><input type="file" name="file2"></td>
                </tr>
                <tr>

                    <td>Изображение 3</td>
                    <td><input type="file" name="file3"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Записать товар"></td>
                </tr>

            </form>
        </table>
    </div>
</div>
</body>
</html>