<%-- 
    Document   : listaUsuarios
    Created on : 10/05/2022, 10:12:35
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <title>Sistock - Lista de Produtos</title>
    </head>
    <body>
        <nav class="navbar" id="menuForm">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="img/negative-logo.png" width="280" height="80">
                </a>
                <nav class="nav">
                    <li class="nav-item">
                        <a href="opDashProd.jsp"><button type="button" class="btn btn-outline-warning"><i class="bi bi-box-arrow-left"></i> Voltar</button></a>
                    </li>
                </nav>
            </div>
        </nav>
        <div class="container-fluid" id="containerListar">
            <h2 style="padding-bottom: 1.5%; padding-top: 1.5%; text-align: center;">Produtos</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Descrição</th>
                        <th scope="col">Família</th>
                        <th scope="col">Código</th>
                        <th scope="col"></th>
                    </tr>
                <tbody>
                    <c:forEach items="${produtos}" var="produto">
                        <tr>
                            <td>${produto.descricao}</td>
                            <td>${produto.familia}</td>
                            <td>${produto.codigo}</td>
                            <td>
                                <ul style="padding-top: 5%;">
                                    <a href="CarregarProduto?codigo=${produto.id}">
                                        <button type="button" class="btn btn-primary"><i class="bi bi-pencil-fill"></i> Editar</button>
                                    </a>
                                    <a href="ExcluirProduto?codigo=${produto.id}">
                                        <button type="button" class="btn btn-danger"><i class="bi bi-trash-fill"></i> Excluir</button>
                                    </a>
                                </ul> 
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
    </body>
</html>
