package Entidade;

public abstract class Produto {
    private String id;
    private String nome;
    private float preco;
    private int quantidade;
    private String marca;


    public Produto(String id2, String nome2, float preco2, int quantidade2, String marca2) {
        this.id=id2;
        this.nome=nome2;
        this.preco=preco2;
        this.quantidade=quantidade2;
        this.marca=marca2;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
