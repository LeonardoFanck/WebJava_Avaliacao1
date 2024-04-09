function validarCadastro(operacao) {
    var contador = 0;
    var campos = document.querySelectorAll('#cadastro input[required]');
    campos.forEach(function (campo) {
        if (!campo.value.trim()) {
            campo.style.borderColor = 'red';
            contador++;
        } 
        else {
            campo.style.borderColor = '';
        }
    });

    var senha = document.getElementById('senha').value;
    var confirmarSenha = document.getElementById('confirmarSenha').value;
    if (senha !== confirmarSenha){
        alert("Senhas não conferem!");
        contador++;
    }

    var cep = document.getElementById('cep').value;
    if (cep.length !== 9 && cep.length !== 0){
        alert("CEP inválido!");
        contador++;
    }

    if (contador === 0){
        var id = document.getElementById('id').value;
        var nome = document.getElementById('nome').value;
        var dtNascimento = document.getElementById('dataNascimento').value;
        var email = document.getElementById('email').value;
        var estado = document.getElementById('estado').value;
        var cidade = document.getElementById('cidade').value;
        var bairro = document.getElementById('bairro').value;
        var rua = document.getElementById('rua').value;
        var numero = document.getElementById('numero').value;
        var complemento = document.getElementById('complemento').value;
     
        
        //var form = document.getElementById('cadastro');
        //var dados = new FormData(form);

        if (operacao === 'alterar'){
            post('/Avaliacao1/alterarUsuario', {
                id: id,
                nome: nome,
                dtNascimento: dtNascimento,
                senha: senha,
                email: email,
                cep: cep,
                estado: estado,
                cidade: cidade,
                bairro: bairro,
                rua: rua,
                numero: numero,
                complemento: complemento}
            );
        }
        else if (operacao === 'cadastro'){
            post('/Avaliacao1/cadastrarUsuario', {
                nome: nome,
                dtNascimento: dtNascimento,
                senha: senha,
                email: email,
                cep: cep,
                estado: estado,
                cidade: cidade,
                bairro: bairro,
                rua: rua,
                numero: numero,
                complemento: complemento}
            );
        }
    }
};

function logar(){

    var contador = 0;
    
    var campos = document.querySelectorAll('input[required]');
    campos.forEach(function (campo) {
        if (!campo.value.trim()) {
            campo.style.borderColor = 'red';
            contador++;
        } 
        else {
            campo.style.borderColor = '';
        }
    });

    if (contador === 0){
        var email = document.getElementById('email').value;
        var senha = document.getElementById('senha').value;

        post('/Avaliacao1/login', {
            email: email,
            senha: senha
            }
        );
    }

}

function excluir(id){
    
    var confirmacao = confirm("Confirma a exclusao do usuario " + id + " ?");
    
    if (confirmacao === true) {
        //window.location.href = "excluiContato";
        post('/Avaliacao1/excluirUsuario', {id: id});
    }
    
}

function editar(id){
    
    post('/Avaliacao1/editarUsuario', {id: id});
}

function post(path, params, method = 'post') {

    const form = document.createElement('form');
    form.method = method;
    form.action = path;

    for (const key in params) {
        if (params.hasOwnProperty(key)) {
            const hiddenField = document.createElement('input');
            hiddenField.type = 'hidden';
            hiddenField.name = key;
            hiddenField.value = params[key];

            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}


const handleZipCode = (event) => {
    let input = event.target;
    input.value = zipCodeMask(input.value);
};


const zipCodeMask = (value) => {
  if (!value) return "";
  value = value.replace(/\D/g,'');
  value = value.replace(/(\d{5})(\d)/,'$1-$2');
  return value;
};
