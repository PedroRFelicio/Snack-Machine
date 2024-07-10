package br.com.targettrust.snack;

import br.com.targettrust.snack.domain.Fileira;
import br.com.targettrust.snack.domain.Produto;
import br.com.targettrust.snack.domain.SnackMachine;
import br.com.targettrust.snack.interfaces.Fluxo;

import java.io.*;

public class FluxoRecarga implements Fluxo {
    private final SnackMachine maquina;

    public FluxoRecarga(SnackMachine maquina) {
        this.maquina = maquina;
    }

    @Override
    public void executar() throws Exception {
        String path = System.getProperty("user.dir");
        String caminhoArquivo = path + File.separator + "snack.txt";

        System.out.println("## Fluxo de recarga");
        System.out.println("Atendente fazendo a recarga da Snack Machine");

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    String codigo = partes[0].trim();
                    String nome = partes[1].trim();
                    double preco = Double.parseDouble(partes[2].trim());
                    int quantidade = Integer.parseInt(partes[3].trim());
                    Produto produto = new Produto(codigo, nome, preco);
                    Fileira fileira = new Fileira(produto, quantidade);
                    maquina.adicionarFileira(fileira);
                }
            }
        }
    }
}
