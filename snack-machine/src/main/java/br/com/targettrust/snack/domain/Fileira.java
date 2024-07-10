package br.com.targettrust.snack.domain;


import br.com.targettrust.snack.enumerations.EnumStatusFileira;

public class Fileira {
    private final Produto produto;
    private int quantidade;
    private EnumStatusFileira status;

    public Fileira(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.status = quantidade > 0 ? EnumStatusFileira.COM_PRODUTO : EnumStatusFileira.VAZIA;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.status = quantidade > 0 ? EnumStatusFileira.COM_PRODUTO : EnumStatusFileira.VAZIA;
    }

    @Override
    public String toString() {
        return "Fileira{" +
                "Produto=" + produto +
                ", Quantidade=" + quantidade +
                ", Status=" + status +
                '}';
    }


}
