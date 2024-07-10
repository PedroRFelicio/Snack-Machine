package br.com.targettrust.snack;

import br.com.targettrust.snack.domain.SnackMachine;

public class Principal {
    public static void main(String[] args) {
        SnackMachine maquina = new SnackMachine();

        FluxoRecarga fluxoRecarga = new FluxoRecarga(maquina);
        try {
            fluxoRecarga.executar();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de recarga: " + e.getMessage());
        }

        maquina.exibirInformacoes();

        FluxoAtendimento fluxoAtendimento = new FluxoAtendimento(maquina);
        fluxoAtendimento.executar();
    }
}