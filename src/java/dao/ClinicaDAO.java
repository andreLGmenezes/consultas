package java.dao;
import java.entidades.Clinica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClinicaDAO {
    private static Connection connection;
    public ClinicaDAO(Connection connection) {
        ClinicaDAO.connection = connection;
    }
    // Método para inserir uma clínica
    public static void inserirClinica(Clinica clinica) {
        String sql = "INSERT INTO clinicas (nome, endereco, telefone) VALUES (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, clinica.getNome());
            pstmt.setString(2, clinica.getEndereço());
            pstmt.setString(3, clinica.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para atualizar uma clínica
    public void atualizarClinica(Clinica clinica) {
        String sql = "UPDATE clinicas SET nome =?, endereco =?, telefone =? WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, clinica.getNome());
            pstmt.setString(2, clinica.getEndereço());
            pstmt.setString(3, clinica.getTelefone());
            pstmt.setInt(4, clinica.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para excluir uma clínica
    public void excluirClinica(int id) {
        String sql = "DELETE FROM clinicas WHERE id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para buscar todas as clínicas
    public List<Clinica> buscarTodasClinicas() {
        String sql = "SELECT * FROM clinicas";
        List<Clinica> clinicas = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Clinica clinica = new Clinica();
                clinica.setId(rs.getInt("id"));
                clinica.setNome(rs.getString("nome"));
                clinica.setEndereço(rs.getString("endereco"));
                clinica.setTelefone(rs.getString("telefone"));
                clinicas.add(clinica);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clinicas;
    }
    // Método para buscar uma clínica por ID
    public Clinica buscarClinicaPorId(int id) {
        String sql = "SELECT * FROM clinicas WHERE id =?";
        Clinica clinica = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clinica = new Clinica();
                    clinica.setId(rs.getInt("id"));
                    clinica.setNome(rs.getString("nome"));
                    clinica.setEndereço(rs.getString("endereco"));
                    clinica.setTelefone(rs.getString("telefone"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clinica;
    }
}