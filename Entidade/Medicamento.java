package Entidade;

public class Medicamento extends Produto{

    private String tarja;
    public Medicamento(String id2, String nome2, float preco2, int quantidade2, String marca2, String tarja) {
        super(id2, nome2, preco2, quantidade2, marca2);
        this.tarja=tarja;
    }

    public String getTarja() {
        return tarja;
    }
    public void setTaxa(String tarja) {
        this.tarja = tarja;
    }

    
    
}
