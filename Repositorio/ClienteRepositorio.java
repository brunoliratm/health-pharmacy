package Repositorio;

import java.util.ArrayList;

import Entidade.Cliente;


public class ClienteRepositorio {
    static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
}
