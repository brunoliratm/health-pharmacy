package Repositorio;
import java.util.ArrayList;
import Entidade.Funcionario;

public class FuncionarioRepositorio {
    ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

    public void addFuncionario(Funcionario funcionario){
        listaFuncionario.add(funcionario);
    }
}
