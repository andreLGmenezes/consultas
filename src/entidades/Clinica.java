import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Clinica {
    @Id
	@GeneratedValue
    private int id ;
    private String telefone;
    private String endereço;
    private String nome;
    public Clinica() {
    }
    public Clinica(int id, String nome,String endereço,String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone= telefone;
    }
    public String getEndereço(){
        return endereço;
    }
    public void setEndereço(String endereço){
        this.endereço= endereço;
    }
}