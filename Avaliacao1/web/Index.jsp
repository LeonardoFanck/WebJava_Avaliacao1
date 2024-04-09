<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Página Inicial</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  
</head>
<body>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-4 offset-md-4">
        <div class="card">
          <div class="card-body">
           
            
            <c:if test="${usuario != null and usuario != ''}">
                <h5 class="card-title text-center">Bem vindo: ${usuario.nome} </h5> 
            </c:if>
            
            <h5 class="card-title text-center">Escolha uma opção:</h5>
            <ul class="list-group text-center">
                         
            <c:if test="${usuario != null}">
                <li class="list-group-item"><a href="CadastroUsuario.jsp">Adicionar Novo Usuário</a></li>
                <li class="list-group-item"><a href="listaUsuarios">Listar Usuários</a></li>
                <li class="list-group-item"><a href="Login.jsp">Sair</a></li>
            </c:if>
                
            <c:if test="${usuario == null}">
                <li class="list-group-item"><a href="Login.jsp">Login</a></li>
            </c:if>
              
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
