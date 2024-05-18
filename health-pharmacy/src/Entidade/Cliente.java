package Entidade;

public class Cliente extends Pessoa {

    private int idade;
    private String endereco;
    private String CPF;
     

    public Cliente(String nome,String email,int idade, String endereco,String telefone,String senha, String CPF) {
        super(nome, telefone, email, senha);
        this.idade = idade;
        this.endereco = endereco;
        this.CPF = CPF;

    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Informacoes do Cliente: \nNome: " + getNome() + "\nCPF: " + getCPF() + "\nTelefone: " + getTelefone() + "\nIdade: " + getIdade() + "\nEmail: " + getEmail() + "\nEndereco: " + getEndereco() + "\nSenha: " + getSenha();
    }
    
    
}
