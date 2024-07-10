package br.com.targettrust.snack.domain;

public class Produto {
    private final String codigo;
    private final String nome;
    private final double preco;

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Codigo='" + codigo + '\'' +
                ", Nome='" + nome + '\'' +
                ", Preco=" + preco +
                '}';
    }
}
