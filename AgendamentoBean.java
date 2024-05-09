import java.util.List;

public class AgendamentoBean {
    private Agendamento agendamento;
    private List<Clinica> clinicas;
    private List<Medico> medicos;

    public void init() {
        // Inicializa as listas de clínicas e médicos
    }
    public AgendamentoBean() {
        this.agendamento = new Agendamento();
    }
    public Agendamento getAgendamento() {
        return agendamento;
    }
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
    public List<Clinica> getClinicas() {
        return clinicas;
    }
    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    public List<Medico> getMedicos() {
        return medicos;
    }
    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    public void cadastrarAgendamento() {
        // Valida se já existe um agendamento para a mesma clínica, data, hora e médico
        // Se não existir, cria um novo agendamento e o salva no banco de dados
        // Se existir, exibe uma mensagem de erro ao usuário
    }
}