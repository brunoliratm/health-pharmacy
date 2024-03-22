package Repositorio;

import java.util.ArrayList;

import Entidade.Suplemento;

public class SuplementoRepositorio {
    static ArrayList<Suplemento> listaSuplementos = new ArrayList<>();
    public static void addSuplemento(Suplemento suplemento){
        listaSuplementos.add(suplemento);
    }
}
