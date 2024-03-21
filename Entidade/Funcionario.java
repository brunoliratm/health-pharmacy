package Entidade;

public class Funcionario extends Pessoa{
    private String cargo;
    private Float salario;

    public Funcionario(String nome,String email,String telefone,String cargo,Float salario, String senha, String cnpj){
        super(nome, cnpj, telefone, email, senha);
        this.cargo = cargo;
        this.salario = salario;
    }
    public Float getSalario(){
        return salario;
    }
    public void setSalario(Float salario){
        this.salario = salario;
    }
    public String getCargo(){
        return cargo;
    }
    public void setcVUnica(String cargo){
        this.cargo = cargo;
    }

}
