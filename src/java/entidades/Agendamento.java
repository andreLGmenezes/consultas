package java.entidades;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agendamento {
    @Id
	@GeneratedValue
    private int id;
    private String nomePaciente;
    private String email;
    private String status;
    private Clinica clinica;
    private Medico medico;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataCadastro;
    public Agendamento() {
        this.status = "agendado";
        this.dataCadastro = LocalDateTime.now();
    }
    public Agendamento(String nomePaciente, String email, Clinica clinica, Medico medico, LocalDateTime dataHoraAgendamento) {
        this();
        this.nomePaciente = nomePaciente;
        this.email = email;
        this.clinica = clinica;
        this.medico = medico;
        this.dataHoraAgendamento = dataHoraAgendamento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomePaciente() {
        return nomePaciente;
    }
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Clinica getClinica() {
        return clinica;
    }
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }
    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}