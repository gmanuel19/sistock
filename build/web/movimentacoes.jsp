<%-- 
    Document   : dashboard
    Created on : 03/05/2022, 17:24:56
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
        <title>Sistock - Movimentações</title>
    </head>
    <body>
        <nav class="navbar" id="menuForm">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="img/negative-logo.png" width="280" height="80">
                </a>
                <nav class="nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="ListarMovimentacao" role="button" style="color: #ffffff">Movimentações Gerais</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link" href="ListarEntrada" role="button" style="color: #ffffff">Entradas</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link" href="ListarSaida" role="button" style="color: #ffffff">Saídas</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link" href="ProdutosMovimentacao" role="button" style="color: #ffffff">Nova Movimentação</a>
                    </li>



                    <li class="nav-item">
                        <a href="painel.jsp"><button type="button" class="btn btn-outline-warning"><i class="bi bi-box-arrow-left"></i> Voltar</button></a>
                    </li>
                </nav>
            </div>
        </nav>

        <div class="container-fluid" id="containerListar">
            <form class="d-flex" action="FiltroMovimentacaoData" role="search" style="padding-bottom: 1.5%; padding-top: 1.5%;">

                <label for="dataInicial" class="form-label">Filtrar p/ data</label>
                <input class="form-control me-2" name="dataInicial" type="date">
                <input type="submit" class="btn btn-primary btn-sm" value="Aplicar Filtro"/>
            </form>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Movimentação</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Motivo</th>
                        <th scope="col">Qtde Pacote</th>
                        <th scope="col">Qtde Unidade</th>
                        <th scope="col">Usuário</th>
                        <th scope="col">Data</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${movimento}" var="movi">
                        <tr>
                            <td>${movi.tipo_movimentacao}</td>
                            <td>${movi.produto}</td>
                            <td>${movi.motivo}</td>
                            <td>${movi.qtd_pacote}</td>
                            <td>${movi.qtd_unidade}
                            <td>${movi.usuario}</td>
                            <td>${movi.data_string}</td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
    </body>
</html>
