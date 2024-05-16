package Repositorio;

import java.util.ArrayList;
import Entidade.Cliente;


public class RepositorioCliente {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
}
