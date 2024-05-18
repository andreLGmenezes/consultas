package java.ui;

import java.dao.ClinicaDAO;
import java.entidades.Clinica;


public class princ {
    public static void main(String[] args) {
        Clinica clinica1 = new Clinica();
        clinica1.setId(123);
        clinica1.setEndereço("Rua Rio Negro");
        clinica1.setNome("Clinica Do Careca");
        clinica1.setTelefone("9090");

        ClinicaDAO.inserirClinica(clinica1);

    }
}
