package br.com.targettrust.snack;

import br.com.targettrust.snack.domain.Fileira;
import br.com.targettrust.snack.domain.SnackMachine;
import br.com.targettrust.snack.exceptions.ProdutoIndisponivelException;
import br.com.targettrust.snack.exceptions.ProdutoNaoEncontradoException;
import br.com.targettrust.snack.interfaces.Fluxo;
import java.util.Scanner;

public class FluxoAtendimento implements Fluxo {
    private final SnackMachine maquina;

    public FluxoAtendimento(SnackMachine maquina) {
        this.maquina = maquina;
    }

    @Override
    public void executar() {
        System.out.println("## Fluxo de atendimento:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o código do produto");
        String codigo = scanner.nextLine();

        try {
            Fileira fileira = maquina.getFileiraPorCodigo(codigo);

            if (fileira.getQuantidade() == 0) {
                throw new ProdutoIndisponivelException("Produto indisponível no momento.");
            }

            System.out.println("Qual será a forma de pagamento?");
            System.out.println("Se for cartão de crédito/débito, informe 1");
            System.out.println("Se for dinheiro, informe 2");
            int formaPagamento = scanner.nextInt();

            if (formaPagamento == 1) {
                System.out.println("Pagamento realizado com cartão.");
            } else if (formaPagamento == 2) {
                System.out.println("Informe o valor pago:");
                double valorPago = scanner.nextDouble();

                double precoProduto = fileira.getProduto().getPreco();

                if (valorPago >= precoProduto) {
                    fileira.setQuantidade(fileira.getQuantidade() - 1);
                    double troco = valorPago - precoProduto;
                    System.out.println("Compra realizada com sucesso. Troco: " + troco);
                } else {
                    System.out.println("Valor insuficiente para a compra.");
                }
            } else {
                System.out.println("Forma de pagamento inválida.");
            }

        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (ProdutoIndisponivelException e) {
            System.out.println(e.getMessage());
        }
    }
}
