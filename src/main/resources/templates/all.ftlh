<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>

    body, html {
        padding: 0px;
        margin: 0px;


    }

    .container {
border: 1px solid red;
        background: rgb(15, 24, 42);
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .header {
        border: 1px solid green;
        display: flex;
        width: 100%;
        flex-direction: column;
        justify-content: center;
        align-items: center;

    }

    .imgTop {
        border: 1px solid brown;
        width: 900px;
        height: 300px;
        margin-bottom: 5px;
        background: url("footer.jpg");
        background-size: cover;
        border-radius: 50px 30px;
    }
    .find{
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
    border: 1px solid red;
    width: 100%;}
    .card{
        border: 1px solid blue;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;;
    }
    .productImage{
        border: 1px solid brown;
        width: 100%;
        height: 200px;
        margin-bottom: 5px;
        background: url("footer.jpg");
        background-size: cover;
    }
    li{margin: 0px;
        background-color: darkgrey;
        height: 50px;
    }
    li:hover{background-color: gray}
    ul{margin: 0px;
        list-style-type: none;
        font-size: 30px;
    }
</style>

<body>
<div class="container">
    <div class="header">
        <div class="imgTop"></div>
        <input class="find" type="text">
    </div>
</div>
<div class="block">
    <div class="left">
        <ul>
<#list categories as category>
    <li>
        <a href="/category/${category.id}">  ${category.name}
        </a></li>
</#list >
        </ul>
    </div>
    <div class="right">

<#list products as product>
    <div class="card">
        <div class="productImage"></div>
        <div>${product.name}</div>
       <div> ${product.price} </div>
        <div><a href="/product/${product.id}"> Информация о товаре</a></div>
    </div>
</#list >
    </div>
</div>

</body>
</html>