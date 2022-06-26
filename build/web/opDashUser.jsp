<%-- 
    Document   : dashboard
    Created on : 03/05/2022, 17:24:56
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistock - Usuário</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <a href="painel.jsp">
                    <img src="img/logotipo-POSITIVA.PNG" class="img-fluid w-50 mx-auto d-block" style="padding: 3%;">
                </a>
            </div>
            <div class="row">
                <div class="col-6">
                    <a href="ListarUsuarios">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3>
                                Listar Usuários
                            </h3>
                        </button>
                    </a>
                </div>
                <div class="col-6">
                    <a href="cadastrarUsuario.jsp">
                        <button type="button" class="btn btn-primary btn-lg w-100" style="padding: 15%; margin-bottom: 3%;">
                            <h3>
                                Cadastrar Usuário
                            </h3>
                        </button>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <a href="painel.jsp">
                            <button type="button" class="btn btn-secondary btn-lg">Voltar</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <br/><br/><br/>
        <footer class="bg-light text-center text-lg-start" style="margin-top: 5%;">
            <div class="text-center p-3">
                Desenvolvido por Guilherme Manuel Pires de Castro e Laysla Araújo Giovanini
            </div>
        </footer>
    </body>
</html>
