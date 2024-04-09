<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% String mensagemLogin = ""; 
   mensagemLogin = request.getParameter("mensagem");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="js/Script.js"></script>
  <title>Página Inicial</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/Style.css"/>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center">Faça Login</h5>
                        <form>
                            <div class="mb-3">
                                <label for="cpf" class="form-label">Email:</label>
                                <input type="text" class="form-control" id="email" placeholder="Informe seu Email" required>
                            </div>
                            <div class="mb-3">
                                <label for="senha" class="form-label">Senha:</label>
                                <input type="password" class="form-control" id="senha" placeholder="Informe sua senha" required>
                            </div>
                            <button type="button" class="btn btn-primary btn-block" onclick="logar()">Entrar</button>
                            
                            <c:if test="${mensagem != null}">
                                <p class="mensagemLogin"> ${mensagem} </p>
                            </c:if>
                        </form>
                        
                        <div class="text-center mt-3">
                            <a href="CadastroUsuario.jsp">Criar conta</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
