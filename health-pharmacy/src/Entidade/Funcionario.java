package Entidade;

public class Funcionario extends Pessoa{
    private String cargo;
    private String CNPJ;

    public Funcionario(String nome,String email,String telefone,String cargo, String senha, String CNPJ){
        super(nome, telefone, email, senha);
        this.cargo = cargo;
        this.CNPJ = CNPJ;
    }


    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }


    @Override
    public String toString() {
        return "Informacoes do Funcionario: \nCargo: " + getCargo() + "\nNome: " + getNome() + "\nCNPJ: " + getCNPJ() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha();
    }

    
}
