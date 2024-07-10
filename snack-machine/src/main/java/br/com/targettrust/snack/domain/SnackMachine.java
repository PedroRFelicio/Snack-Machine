package br.com.targettrust.snack.domain;

import br.com.targettrust.snack.enumerations.EnumStatusMaquina;
import br.com.targettrust.snack.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class SnackMachine {
    private final List<Fileira> fileiras;
    private final EnumStatusMaquina status;

    public SnackMachine() {
        this.fileiras = new ArrayList<>();
        this.status = EnumStatusMaquina.DISPONIVEL;
    }

    public void adicionarFileira(Fileira fileira) {
        fileiras.add(fileira);
    }


    public Fileira getFileiraPorCodigo(String codigoProduto) throws ProdutoNaoEncontradoException {
        for (Fileira fileira : fileiras) {
            if (fileira.getProduto().getCodigo().equals(codigoProduto)) {
                return fileira;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado.");
    }

    public void exibirInformacoes() {
        System.out.println("Status da Máquina: " + status);
        for (Fileira fileira : fileiras) {
            System.out.println(fileira);
        }
    }
}
