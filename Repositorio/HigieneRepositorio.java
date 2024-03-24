package Repositorio;

import java.util.ArrayList;
import Entidade.Higiene;

public class HigieneRepositorio {
    static ArrayList<Higiene> listaHigiene =  new ArrayList<>();

    public static void addHigiene(Higiene higiene){
        listaHigiene.add(higiene);
    }
}
