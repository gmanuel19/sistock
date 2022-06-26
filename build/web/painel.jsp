<%-- 
    Document   : dashboard
    Created on : 03/05/2022, 17:24:56
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistock - Gerenciamento de Estoque</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/logotipo-POSITIVA.PNG" class="img-fluid w-50 mx-auto d-block" style="padding: 3%;">
            </div>
            <div class="row">
                <div class="col-6">
                    <a href="ListarMovimentacao">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3>
                                <i class="bi bi-box-arrow-in-up-right"></i>
                                Movimentações
                            </h3>
                        </button>
                    </a>
                </div>
                <div class="col-6">
                    <a href="opDashProd.jsp">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3 style="color: white;">
                                <i class="bi bi-box"></i>
                                Produtos
                            </h3>
                        </button>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <a href="ListarContagem">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3>
                                <i class="bi bi-bar-chart-fill"></i>
                                Contagem
                            </h3>
                        </button>
                    </a>
                </div>
                <div class="col-6">
                    <a href="opDashUser.jsp">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3 style="color: white;">
                                <i class="bi bi-people-fill"></i>
                                Usuários
                            </h3>
                        </button>
                    </a>
                </div>
            </div>
        </div>
        <footer class="bg-light text-center text-lg-start" style="margin-top: 5%;">
            <div class="text-center p-3">
                Desenvolvido por Guilherme Manuel Pires de Castro e Laysla Araújo Giovanini
            </div>
        </footer>
    </body>
</html>
