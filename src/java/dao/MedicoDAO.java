package java.dao;
import java.entidades.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private Connection connection;
    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }
    // Método para inserir um médico
    public void inserirMedico(Medico medico) {
        String sql = "INSERT INTO medicos (nome, especialidade, crm) VALUES (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getEspecialidade());
            pstmt.setString(3, medico.getCrm());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para atualizar um médico
    public void atualizarMedico(Medico medico) {
        String sql = "UPDATE medicos SET nome =?, especialidade =?, crm =? WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getEspecialidade());
            pstmt.setString(3, medico.getCrm());
            pstmt.setInt(4, medico.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para excluir um médico
    public void excluirMedico(int id) {
        String sql = "DELETE FROM medicos WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para buscar todos os médicos
    public List<Medico> buscarTodosMedicos() {
        String sql = "SELECT * FROM medicos";
        List<Medico> medicos = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setCrm(rs.getString("crm"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicos;
    }
    // Método para buscar um médico por ID
    public Medico buscarMedicoPorId(int id) {
        String sql = "SELECT * FROM medicos WHERE id =?";
        Medico medico = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();
                    medico.setId(rs.getInt("id"));
                    medico.setNome(rs.getString("nome"));
                    medico.setEspecialidade(rs.getString("especialidade"));
                    medico.setCrm(rs.getString("crm"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }
}