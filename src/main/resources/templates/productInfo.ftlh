<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
    <meta charset="UTF-8">
    <title>Product Info</title>
</head>
<body>
<table>
    <th>Информация о товаре</th>
    <br>
    <tr>
    <td>Название</td>
    <td>${product.name}</td>
    </tr>
    <tr>
        <td>Описание</td>
    <td>${product.description}</td>
    </tr>
<tr>
    <#list images as image>
    <td><img src="/images/${image.getId()}" alt="image1" height="200px" width="200px"></td>

</#list >
</tr>
    <tr>
        <td>Цена</td>
    <td>${product.price}</td>
    </tr>

    <tr>
        <td>
        <form action="/addShoppingCart/${product.id}" method="get">
            <input type="submit" value="Купить товар">
        </form>
        </td>
    </tr>

</table>

</body>
</html>