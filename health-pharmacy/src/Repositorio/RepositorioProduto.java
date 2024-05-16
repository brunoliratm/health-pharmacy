package Repositorio;

import java.util.ArrayList;
import Entidade.Produto;

public class RepositorioProduto {
    static ArrayList<Produto>  listaProdutos = new ArrayList<>();
    public static void addProduto(Produto produto){
        listaProdutos.add(produto);
    }
}
