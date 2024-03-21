package Entidade;

public class Cliente extends Pessoa {

    private int idade;
    private String endereco;
     

    public Cliente(String nome,String email,int idade, String endereco,String telefone,String senha, String cVUnica) {
        super(nome, cVUnica, telefone, email, senha);
        this.idade = idade;
        this.endereco = endereco;

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
    
    
}
