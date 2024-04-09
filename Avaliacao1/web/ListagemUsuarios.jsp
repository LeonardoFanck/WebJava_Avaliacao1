<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Listagem de Dados</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="css/Style.css"/>
  <script src="js/Script.js"></script>
  </style>
</head>
<body>
  <div class="container">
    <c:if test="${mensagem != null and mensagem != ''}">
        <h1>Listagem de Usuários   <p class="mensagemLogin">${mensagem}</p></h1>
    </c:if>
    <c:if test="${mensagem == null or mensagem == ''}">
        <h1>Listagem de Usuários</h1>
    </c:if>
    
    <div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Usuario</th>
            <th scope="col">Data de Nascimento</th>
            <th scope="col">Email</th>
            <th scope="col">CEP</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${lista}" var="u">
                <tr>
                    <th scope="row">${u.getId()}</th>
                    <td>${u.getNome()}</td>
                    <td>${u.getDtNascimento()}</td>
                    <td>${u.getEmail()}</td>
                    <td>${u.getCep()}</td>
                    <td>
                      <button type="button" class="btn btn-primary btn-sm" onclick="editar(${u.getId()})">Editar</button>
                      <button type="button" class="btn btn-danger btn-sm" onclick="excluir(${u.getId()})">Excluir</button>
                    </td>
                </tr>
            </c:forEach>
          
        </tbody>
      </table>
    </div>
    <!-- Botão para voltar para a página anterior -->
    <a href="#" onclick="history.go(-1);" class="btn btn-secondary">Voltar</a>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
