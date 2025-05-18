package database;

import java.sql.Date;

public class Item{

    private int quantidade;
    private double preco;
    private String nome;
    private String marca;
    private Date validade;
    private int setor;
    private int id=-1;

    public Item(String nome, double preco, String marca, Date validade, int quantidade, int setor){
        this.nome=nome;
        this.preco=preco;
        this.marca=marca;
        this.validade=validade;
        this.quantidade=quantidade;
        this.setor=setor;
    }

    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
    public Date getValidade() { return validade; }
    public int getSetor() { return setor; }
    public int getId() { return id; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setValidade(Date validade) { this.validade = validade; }
    public void setSetor(int setor) { this.setor = setor; }
    public void setId(int id) { this.id = id; }

}
