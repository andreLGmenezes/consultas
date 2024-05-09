import java.util.List;

public class MedicoBean {
    private Medico medico;
    private List<Medico> medicos;

    public void init() {
        // Inicializa a lista de médicos
    }
    public MedicoBean() {
        this.medico = new Medico();
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public List<Medico> getMedicos() {
        return medicos;
    }
    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    public void salvarMedico() {
        // Salva o médico no banco de dados
    }
    public void excluirMedico(Medico medico) {
        // Exclui o médico do banco de dados
    }
}