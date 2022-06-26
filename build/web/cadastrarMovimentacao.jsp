<%-- 
    Document   : cadastrarProduto
    Created on : 10/05/2022, 10:57:56
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        
        <script type="text/javascript" src="js/saldoProduto.js"></script>
        <title>Sistock - Cadastrar Movimentação</title>
    </head>
    <body>
        <nav class="navbar" id="menuForm">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="img/negative-logo.png" class="img-fluid w-25 mx-auto d-block" style="padding: 1%;"/>
                </a>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form accept-charset="iso-8859-1,utf-8" method="POST" action="CadastrarMovimentacao" id="formulario">
                        <h2>Cadastrar Movimentação</h2>

                        <input type="text" name="produtoId" id="produtoId" value="" readonly style="display: none"/><br/>
                        <input type="text" name="getProdutoSaldo" id="getProdutoSaldo" value="" readonly style="display: none"/>
                        
                        <input type="text" name="usuario" value="${nomeUsuario}" readonly style="display: none"/><br/>
                        <label class="form-label" for="produto">Produto:</label>
                        <select name="produto" class="form-select" required>
                            <option selected>Escolha algum produto</option>
                            <c:forEach items="${produtos}" var="produto">
                                <option id="prodId" onclick="carregaIdProduto(${produto.id}); carregaSaldoProduto(${produto.saldo_estoque})">${produto.codigo} - ${produto.descricao} ${produto.familia}</option>
                            </c:forEach>
                        </select>
                        <label class="form-label" for="romaneio">Romaneio</label>
                        <input type="text" class="form-control" name="romaneio" required onkeypress="return onlynumber();"/>
                        <label class="form-label" for="movimento">Tipo de movimento</label>
                        <select name="movimento" class="form-select" required>
                            <option value="Entrada">Entrada</option>
                            <option value="Saída">Saída</option>
                        </select>
                        <label class="form-label" for="motivo">Motivo</label>
                        <input type="text" class="form-control" name="motivo" required/>
                        <label class="form-label" for="qtdPac">Qtd Pacote</label>
                        <input type="text" class="form-control" name="qtdPac" required onkeypress="return onlynumber();"/>
                        <label class="form-label" for="qtdUnd">Qtd Unidade</label>
                        <input type="text" class="form-control" name="qtdUnd" required onkeypress="return onlynumber();"/>
                        <label class="form-label" for="lblData">Data</label>
                        <input type="date" class="form-control" name="lblData" required/>
                        <div class="d-grid gap-2 d-md-block" id="botoesForm">
                            <input type="submit" class="btn btn-primary" value="Cadastrar"/>
                            <a href="ListarMovimentacao"><button type="button" class="btn btn-light">Voltar</button></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <br/><br/><br/><br/><br/><br/>
        <footer class="bg-light text-center text-lg-start" style="margin-top: 5%;">
            <div class="text-center p-3">
                Desenvolvido por Guilherme Manuel Pires de Castro e Laysla Araújo Giovanini
            </div>
        </footer>
    </body>
</html>
