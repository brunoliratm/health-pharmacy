package Repositorio;

import java.util.ArrayList;

import Entidade.Medicamento;

public class MedicamentoRepositorio {
    static ArrayList<Medicamento>  listaMedicamentos = new ArrayList<>();
    public static void addMedicamento(Medicamento medicamento){
        listaMedicamentos.add(medicamento);
    }
}
