package br.com.targettrust.snack.exceptions;

public class ProdutoIndisponivelException extends Exception {
    public ProdutoIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
