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

        <script type="text/javascript" src="js/contagemProduto.js"></script>
        <title>Sistock - Cadastrar Contagem</title>
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
                    <form accept-charset="iso-8859-1,utf-8" method="POST" action="CadastrarContagem" id="formulario">
                        <input type="text" name="usuario" value="${nomeUsuario}" style="display:none;" readonly/><br/>
                        <input type="text" name="getProdutoSaldo" id="getProdutoSaldo" value="" style="display:none;" readonly/>


                        <br/>
                        <label class="form-label" for="produto">Selecione o produto</label>
                        <select name="produto" class="form-select" required>
                            <option selected>Escolha algum produto</option>
                            <c:forEach items="${produtos}" var="produto">
                                <option id="prodId" onclick="carregaSaldoProduto(${produto.saldo_estoque})">${produto.codigo} - ${produto.descricao} ${produto.familia}</option>
                            </c:forEach>
                        </select>
                        <label class="form-label" for="dataContagem">Data da contagem</label>
                        <input type="date" class="form-control" name="dataContagem" id="dataContagem" required/>
                        <label class="form-label" for="qtdContagem">Quantidade da contagem (em unidade)</label>
                        <input type="text" class="form-control" name="qtdContagem" required onkeypress="return onlynumber();"/>
                        
                        <div class="d-grid g ap-2 d-md-block" id="botoesForm">
                            <input type="submit" class="btn btn-primary" value="Cadastrar"/>
                            <a href="ListarContagem"><button type="button" class="btn btn-light">Voltar</button></a>
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
