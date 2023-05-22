<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shoping Cart</title>
</head>
<body>
<table>
    <form action="/addShoppingCart/${product.id}" method="get">
        <tr>
            <th>Название</th>
            <th>Количество</th>
            <th>Цена</th>
            <th>Сумма</th>
        </tr>
    <tr>
        <td>${product.name}</td>
        <td><input type="number" value="${quantity}" name="quantity"></td>
        <td>${product.getPrice()}</td>
        <td>${bucketDetails.getSum()}</td>

        <td>
                <input type="submit" value="Пересчитать">
        </td>
    </tr>
    </form>
    <td>
    <form action="/addBasket" method="post">
        <input type="submit" value="Добавить в корзину">
    </form>
    </td>
</table>
</body>
</html>