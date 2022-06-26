<%-- 
    Document   : contagem
    Created on : 25/05/2022, 13:42:37
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

        <script type="text/javascript" src="js/contagemProduto.js"></script>

        <title>Sistock - Contagem de estoque</title>
    </head>
    <body>
        <nav class="navbar sticky-top static-top" id="menuForm">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="img/negative-logo.png" width="280" height="80">
                </a>
                <nav class="nav">
                    <ul>
                        <a href="painel.jsp"><button type="button" class="btn btn-outline-warning"><i class="bi bi-box-arrow-left"></i> Voltar</button></a>
                        <a href="ProdutosContagem"><button type="button" class="btn btn-primary">Adicionar Contagem</button></a>
                    </ul>
                </nav>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row" style="padding: 1%;">
                <div class="col-4 w-25" style="border: solid 1px #bebdbd; border-radius: 10px; padding: 2%;">
                    <form action="FiltroData">
                        <h5>Filtro por data:</h5>
                        <label for="dataInicial" class="form-label">Data</label>
                        <input type="date" class="form-control" name="dataInicial" required/>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end" id="botoesForm">
                            <input type="submit" class="btn btn-primary btn-sm" value="Aplicar Filtro"/>
                        </div> 
                    </form>
                    <hr>
                    <form action="FiltroProduto">
                        <h5>Filtro por produto:</h5>
                        <label for="lblProd" class="form-label">Nome do produto</label>
                        <input type="text" class="form-control" name="lblProd" required/>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end" id="botoesForm">
                            <input type="submit" class="btn btn-primary btn-sm" value="Aplicar Filtro"/>
                        </div> 
                    </form>
                </div>
                <!--Campo de contagem-->
                <div class="col-8 w-75" style="padding: 2%;">
                    <center>
                        <h3 style="font-size: 22px;">
                            Contagem do Estoque
                        </h3>
                        <br/>
                    </center>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Cod</th>
                                <th scope="col">Produto</th>
                                <th scope="col">Data</th>
                                <th scope="col">Tipo de movimentação</th>
                                <th scope="col">Qtd Movimentação</th>
                                <th scope="col">Saldo no Estoque</th>
                                <th scope="col">Contagem</th>
                                <th scope="col">Diferença</th>
                                <th scope="col">Usuário</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${contagens}" var="conta">
                                <tr>
                                    <td>${conta.id}</td>
                                    <td>${conta.produto}</td>
                                    <td>${conta.data_string}</td> 
                                    <td>${conta.tipo_movimentacao}</td>
                                    <td>${conta.qtd_movimentacao}</td>
                                    <td>${conta.saldo}</td>
                                    <td>${conta.contagem}</td>
                                    <td>${conta.diferenca}</td>
                                    <td>${conta.usuario}</td>
                                    </tr>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cadastrar Contagem</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
