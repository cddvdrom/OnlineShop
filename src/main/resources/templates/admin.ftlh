<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin page</title>
</head>
<style>
    body{
       display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
<h2>Сптсок товаров:</h2>
<ul>
    <#list products as product>
        <li>${product.name} ${product.price} </li>
    </#list>
</ul>
<р2>Создать новый товар</р2>
<form action="/create" method="post">
    <label for="name">Название</label>
    <input type="text" name="name">
    <br>
    <label for="mark">Марка</label>
    <input type="text" name="mark">
    <br>
    <label for="description">Описание</label>
    <input type="text" name="description">
    <br>
    <label for="price">Цена</label>
    <input type="text" name="price">
    <br>
    <input type="submit" value="сохранить">
</form>
</body>
</html>