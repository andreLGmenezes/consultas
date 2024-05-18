const formularioConsulta = document.getElementById('formulario-consulta');
const tabelaConsultas = document.getElementById('tabela-consultas');
// Função para obter as clínicas e médicos do servidor
function obterClinicasEDoctores() {
    // Implemente a lógica para obter as clínicas e médicos do servidor
}
// Função para adicionar uma consulta à tabela
function adicionarConsultaATabela(consulta) {
    const linha = document.createElement('tr');
    linha.innerHTML = `
        <td>${consulta.nomePaciente}</td>
        <td>${consulta.email}</td>
        <td>${consulta.clinica}</td>
        <td>${consulta.medico}</td>
        <td>${consulta.data}</td>
        <td>${consulta.hora}</td>
        <td>${consulta.status}</td>
        <td>
            <button class="botao-excluir" data-id="${consulta.id}">Excluir</button>
        </td>
    `;
    tabelaConsultas.querySelector('tbody').appendChild(linha);
}
// Função para excluir uma consulta
function excluirConsulta(id) {
    // Implemente a lógica para excluir uma consulta do servidor
}
// Adicione um event listener ao formulário de consulta
formularioConsulta.addEventListener('submit', async event => {
    event.preventDefault();
    const nomePaciente = document.getElementById('nome-paciente').value;
    const email = document.getElementById('email').value;
    const clinica = document.getElementById('clinica').value;
    const medico = document.getElementById('medico').value;
    const data = document.getElementById('data').value;
    const hora = document.getElementById('hora').value;
    const consulta = {
        nomePaciente,
        email,
        clinica,
        medico,
        data,
        hora
    };
    // Envie a consulta para o servidor
    const response = await fetch('http://127.0.0.1:5501/src/java/entidades/Agendamento.java', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(consulta)
    });
    if (response.ok) {
        const novaConsulta = await response.json();
        adicionarConsultaATabela(novaConsulta);
        formularioConsulta.reset();
    } else {
        alert('Falha ao agendar consulta');
    }
});
// Adicione um event listener à tabela de consultas
tabelaConsultas.addEventListener('click', event => {
    if (event.target.classList.contains('botao-excluir')) {
        const id = event.target.dataset.id;
        excluirConsulta(id);
        event.target.parentElement.parentElement.remove();
    }
});
// Chame a função para obter as clínicas e médicos do servidor
obterClinicasEDoctores();
async function obterClinicasEDoctores() {
    try {
    const clinicasResponse = await fetch('http://127.0.0.1:5501/src/java/entidades/Clinica.java');
    const clinicasData = await clinicasResponse.json();
    const medicosResponse = await fetch('http://127.0.0.1:5501/src/java/entidades/Medico.java');
    const medicosData = await medicosResponse.json();
      // Preencha as listas de clínicas e médicos no DOM aqui
    } catch (error) {
    console.error('Erro ao obter as clínicas e médicos:', error);
    }
}
function adicionarConsultaATabela(consulta) {
    const tbody = document.querySelector('#tabela-consultas tbody');
    const linha = document.createElement('tr');
    linha.innerHTML = `
    <td>${consulta.nomePaciente}</td>
    <td>${consulta.email}</td>
    <td>${consulta.clinica}</td>
    <td>${consulta.medico}</td>
    <td>${consulta.data}</td>
    <td>${consulta.hora}</td>
    <td>${consulta.status}</td>
    `;
    tbody.appendChild(linha);
}
function excluirConsulta(id) {
    // Selecione a linha da tabela com o ID fornecido
    const linha = document.querySelector(`#tabela-consultas tr[data-id="${id}"]`);
    if (linha) {
      // Remova a linha da tabela
    linha.remove();
      // Envie uma solicitação DELETE para a API do servidor Javafetch('https://seu-servidor.com/api/consultas/${id}', {
        method: 'DELETE'
    }
    then(response => {
        if (!response.ok) {
        throw new Error('Erro ao excluir a consulta');
        }
    })
    .catch(error => {
        console.error(error);
        // Adicione a linha de volta à tabela se a exclusão falhar no servidor
        tbody.appendChild(linha);
    });
    }