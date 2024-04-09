<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="js/Script.js"></script>
  <title>Cadastro de Usuários</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center">Cadastro de Usuário</h5>
            <form id="cadastro">
              <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" class="form-control" id="nome" maxlength="100" placeholder="Informe seu nome" required>
              </div>
              <div class="mb-3">
                <label for="dataNascimento" class="form-label">Data de Nascimento:</label>
                <input type="date" class="form-control" maxlength="8" id="dataNascimento" required>
              </div>
              <div class="mb-3">
                <label for="senha" class="form-label">Senha:</label>
                <input type="password" class="form-control" id="senha" maxlength="20" placeholder="Informe sua senha" required>
              </div>
                <div class="mb-3">
                    <label for="confirmarSenha" class="form-label">Senha:</label>
                    <input type="password" class="form-control" id="confirmarSenha" maxlength="20" placeholder="Informe novamente sua senha" required>
              </div>
              <div class="mb-3">
                <label for="email" class="form-label">E-mail:</label>
                <input type="email" class="form-control" id="email" maxlength="100" placeholder="Informe seu e-mail" required>
              </div>
              <div class="row">
                <div class="col-md-4 mb-3">
                  <label for="cep" class="form-label">CEP:</label>
                  <input type="text" class="form-control" id="cep" maxlength="9" onkeyup="handleZipCode(event)" placeholder="Informe seu CEP" required>
                </div>
                <div class="col-md-4 mb-3">
                  <label for="estado" class="form-label">Estado:</label>
                  <input type="text" class="form-control" id="estado" maxlength="100" placeholder="Informe seu estado" required>
                </div>
                <div class="col-md-4 mb-3">
                  <label for="cidade" class="form-label">Cidade:</label>
                  <input type="text" class="form-control" id="cidade" maxlength="100" placeholder="Informe sua cidade" required>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="bairro" class="form-label">Bairro:</label>
                  <input type="text" class="form-control" id="bairro" maxlength="50" placeholder="Informe seu bairro" required>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="rua" class="form-label">Rua:</label>
                  <input type="text" class="form-control" id="rua" maxlength="100" placeholder="Informe sua rua" required>
                </div>
              </div>
              <div class="row">
                <div class="col-md-2 mb-3">
                  <label for="numero" class="form-label">Número:</label>
                  <input type="text" class="form-control" id="numero" maxlength="5" placeholder="Nº" required>
                </div>
                <div class="col-md-10 mb-3">
                  <label for="complemento" class="form-label">Complemento:</label>
                  <input type="text" class="form-control" id="complemento" maxlength="100" placeholder="Complemento">
                </div>
              </div>
                <button type="button" class="btn btn-primary btn-block" onclick="validarCadastro('cadastro')">Cadastrar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.5/jquery.inputmask.min.js"></script>
</body>
</html>
