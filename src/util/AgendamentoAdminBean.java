import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Agendamento;

public class AgendamentoAdminBean {
    private Agendamento agendamento;
    private List<Agendamento> agendamentos;
    public void init() {
        // Inicializa a lista de agendamentos
    }
    public AgendamentoAdminBean() {
        this.agendamento = new Agendamento();
    }
    public Agendamento getAgendamento() {
        return agendamento;
    }
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
    public void cancelarAgendamento(Agendamento agendamento) {
        // Altera o status doagendamento para "cancelado"
        // Envia um e-mail para o paciente informando o cancelamento
    }
}