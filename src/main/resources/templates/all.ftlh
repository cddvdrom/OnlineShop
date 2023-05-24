<!DOCTYPE html>
<html lang="en" xmlns:sec="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="UTF-8">
    <title>Магазин товаров для спорта</title>
</head>
<style>

    body, html {
        padding: 0px;
        margin: 0px;


    }

    .container {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .header {

        display: flex;
        width: 100%;
        flex-direction: column;
        justify-content: center;
        align-items: center;

    }

    .imgTop {

        width: 900px;
        height: 300px;
        margin-bottom: 5px;
        background: url("static/images/footer.jpg");
        background-size: cover;
        border-radius: 50px 30px;
    }
    .find{
        background-color: #dddddd;
        width: 600px;
        height: 20px;
    }
    .block{
        display: flex;
        flex-direction: row;
    }
    .left{width: 400px;}
    .right{display: grid;
    grid-template-columns: repeat(3,1fr);

    width: 100%;}
    .card{
        border: 1px solid ghostwhite;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;;
    }
    .productImage{

    }
    li{ background:gainsboro;
        border: 1px solid #ddd;
        padding: 5px;
        margin: 5px;
        width: 200px;
        list-style-type: none;
    }
    .menu li {
        cursor: pointer;
    }

    .menu li > a {
        display: block;
        text-decoration: none;
    }
    li:hover{background-color: ghostwhite}
    ul{margin: 0px;
        list-style-type: none;
        font-size: 30px;
    }
</style>

<body>
<div class="container">
    <div class="block">

        <form action="/admin">
            <input type="submit" value="Админ">
        </form>

        <form action="/new">
        <input type="submit" value="Зарегистрироваться">
        </form>
        <form action="/auth/login">
            <input type="submit" value="Войти">
        </form>
        <form action="/">
            <input type="submit" value="Корзина покупок">
        </form>
        <form action="/logout">
            <input type="submit" value="Logout">
        </form>
    </div>
    <div class="header">
        <div>
            <img src="../static/images/footer.jpg" alt="" height="300px" width="800px">
        </div>
        <input class="find" type="text">
    </div>
</div>
<div class="block">
    <div class="left">
        <ul class="menu">
<#list categories as category>
    <li>
        <a href="/category/${category.id}">  ${category.name}</a>
        </li>
</#list >
        </ul>
    </div>
    <div class="right">

<#list products as product>
    <div class="card">
        <div class="productImage">
            <img src="/images/${product.getPreviewId()}" alt="preview_image" height="200px" width="200px" alt="">
        </div>
        <div>${product.name}</div>
       <div> ${product.price} </div>
        <div><a href="/product/${product.id}"> Информация о товаре</a></div>
    </div>
</#list >
    </div>
</div>

</body>
</html>