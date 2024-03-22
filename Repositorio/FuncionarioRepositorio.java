package Repositorio;
import java.util.ArrayList;
import Entidade.Funcionario;

public class FuncionarioRepositorio {
    static ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

    public static void addFuncionario(Funcionario funcionario){
        listaFuncionario.add(funcionario);
    }
}
