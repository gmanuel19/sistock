<%-- 
    Document   : cadastrarProduto
    Created on : 10/05/2022, 10:57:56
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
        <title>Sistock - Editar Usuário</title>
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
                    <form accept-charset="iso-8859-1,utf-8" method="POST" action="EditarUsuario" id="formulario">
                        <h2>Editar Usuário</h2>
                        <input type="text" name="id" value="${usuario.id}" readonly="readonly" style="display: none;"/>
                        <br/>
                        <label for="nome" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}" required />
                        <label for="cargo" class="form-label">Cargo</label>
                        <input type="text" class="form-control" id="cargo" name="cargo" value="${usuario.cargo}" required />
                        <label for="cpf" class="form-label">CPF</label>
                        <input type="text" class="form-control" id="cpf" name="cpf" value="${usuario.cpf}" required />
                        <label for="usuario" class="form-label">Usuário</label>
                        <input type="text" class="form-control" id="usuario" name="usuario" value="${usuario.usuario}" required />
                        <label for="email" class="form-label">E-mail</label>
                        <input type="email" class="form-control" id="email" name="email" value="${usuario.email}" aria-describedby="emailHelp" required />
                        <label for="senha" class="form-label">Senha</label>
                        <input type="password" class="form-control" id="senha" name="senha" required />
                        <div class="d-grid gap-2 d-md-block" id="botoesForm">
                            <input type="submit" class="btn btn-primary" value="Editar">
                            <a href="ListarUsuarios"><button type="button" class="btn btn-light">Voltar</button></a>
                        </div>
                    </form>
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
