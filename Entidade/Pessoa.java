package Entidade;
public class Pessoa {
    private String nome;
    private String cVUnica;
    private String telefone;
    private String email;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getcVUnica() {
        return cVUnica;
    }
    public void setcVUnica(String cVUnica) {
        this.cVUnica = cVUnica;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Pessoa(String nome, String cVUnica, String telefone, String email) {
        this.nome = nome;
        this.cVUnica = cVUnica;
        this.telefone = telefone;
        this.email = email;
    }

    
    
}