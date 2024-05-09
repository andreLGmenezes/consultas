import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class AgendamentoDAO {
    private Connection connection;
    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }
    // Método para inserir um agendamento
    public void inserirAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (nome_paciente, email, clinica_id, medico_id, data_hora_agendamento, status) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, agendamento.getNomePaciente());
            pstmt.setString(2, agendamento.getEmail());
            pstmt.setInt(3, agendamento.getClinica().getId());
            pstmt.setInt(4, agendamento.getMedico().getId());
            pstmt.setObject(5, agendamento.getDataHoraAgendamento());
            pstmt.setString(6, agendamento.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para atualizar um agendamento
    public void atualizarAgendamento(Agendamento agendamento) {
        String sql = "UPDATE agendamentos SET nome_paciente =?, email =?, clinica_id =?, medico_id =?, data_hora_agendamento =?, status =? WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, agendamento.getNomePaciente());
            pstmt.setString(2, agendamento.getEmail());
            pstmt.setInt(3, agendamento.getClinica().getId());
            pstmt.setInt(4, agendamento.getMedico().getId());
            pstmt.setObject(5, agendamento.getDataHoraAgendamento());
            pstmt.setString(6, agendamento.getStatus());
            pstmt.setInt(7, agendamento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para excluir um agendamento
    public void excluirAgendamento(int id) {
        String sql = "DELETE FROM agendamentos WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para buscar todos os agendamentos
    public List<Agendamento> buscarTodosAgendamentos() {
        String sql = "SELECT * FROM agendamentos";
        List<Agendamento> agendamentos = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("id"));
                agendamento.setNomePaciente(rs.getString("nome_paciente"));
                agendamento.setEmail(rs.getString("email"));
                agendamento.setClinica(new Clinica(rs.getInt("clinica_id"), sql, sql, sql));
                agendamento.setMedico(new Medico(rs.getInt("medico_id"), sql, sql, sql));
                agendamento.setDataHoraAgendamento(rs.getTimestamp("data_hora_agendamento").toLocalDateTime());
                agendamento.setStatus(rs.getString("status"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agendamentos;
    }
    // Método para buscar um agendamento por ID
    public Agendamento buscarAgendamentoPorId(int id) {
        String sql = "SELECT * FROM agendamentos WHERE id =?";
        Agendamento agendamento = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    agendamento = new Agendamento();
                    agendamento.setId(rs.getInt("id"));
                    agendamento.setNomePaciente(rs.getString("nome_paciente"));
                    agendamento.setEmail(rs.getString("email"));
                    agendamento.setClinica(new Clinica(rs.getInt("clinica_id"), sql, sql, sql));
                    agendamento.setMedico(new Medico(rs.getInt("medico_id"), sql, sql, sql));
                    agendamento.setDataHoraAgendamento(rs.getTimestamp("data_hora_agendamento").toLocalDateTime());
                    agendamento.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agendamento;
    }
    // Método para buscar agendamentos por clínica, data e hora
    public List<Agendamento> buscarAgendamentosPorClinicaDataHora(Clinica clinica, LocalDateTime dataHora) {
        String sql = "SELECT * FROM agendamentos WHERE clinica_id =? AND data_hora_agendamento =?";
        List<Agendamento> agendamentos = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, clinica.getId());
            pstmt.setTimestamp(2, Timestamp.valueOf(dataHora));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Agendamento agendamento = new Agendamento();
                    agendamento.setId(rs.getInt("id"));
                    agendamento.setNomePaciente(rs.getString("nome_paciente"));
                    agendamento.setEmail(rs.getString("email"));
                    agendamento.setClinica(new Clinica(rs.getInt("clinica_id"), sql, sql, sql));
                    agendamento.setMedico(new Medico(rs.getInt("medico_id"), sql, sql, sql));
                    agendamento.setDataHoraAgendamento(rs.getTimestamp("data_hora_agendamento").toLocalDateTime());
                    agendamento.setStatus(rs.getString("status"));
                    agendamentos.add(agendamento);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agendamentos;
    }
}