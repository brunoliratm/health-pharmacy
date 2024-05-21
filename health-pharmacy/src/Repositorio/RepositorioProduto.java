package Repositorio;

import java.util.ArrayList;
import Entidade.Produto;

public class RepositorioProduto {
    public static ArrayList<Produto>  listaProduto = new ArrayList<>();
    public static void addProduto(Produto produto){
        listaProduto.add(produto);
    }
}
