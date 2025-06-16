package models;

import java.util.List;
import java.util.ArrayList;

public class Locadora {
    private List<Veiculo> frota = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        frota.add(veiculo);
        System.out.println("Veículo adicionado à frota!");
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        System.out.println("Veículos disponíveis:");
        List<Veiculo> disponiveis = new ArrayList<>();
        for (int i = 0; i < frota.size(); i++) {
            Veiculo v = frota.get(i);
            if (!v.isAlugado()) {
                System.out.println("[" + i + "] " + v.exibirDetalhes());
                disponiveis.add(v);
            }
        }
        return disponiveis;
    }

    public void alugarVeiculo(int index, int dias) {
        if (index < 0 || index >= frota.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Veiculo veiculo = frota.get(index);
        if (veiculo.isAlugado()) {
            System.out.println("Esse veículo já está alugado.");
            return;
        }

        double preco = veiculo.calcularPrecoAluguel(dias);
        veiculo.alugar();
        System.out.printf("Valor total do aluguel: R$ %.2f%n", preco);
    }

    public void devolverVeiculo(int index) {
        if (index < 0 || index >= frota.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Veiculo veiculo = frota.get(index);
        if (!veiculo.isAlugado()) {
            System.out.println("Esse veículo não está alugado.");
            return;
        }

        veiculo.devolver();
        System.out.println("Veículo devolvido.");
    }

    public void exibirRelatorioFrota() {
        System.out.println("Relatório dos veículos alugados:");
        boolean algumAlugado = false;
        for (int i = 0; i < frota.size(); i++) {
            Veiculo veiculo = frota.get(i);
            if (veiculo.isAlugado()) {
                System.out.println(i + " - " + veiculo.exibirDetalhes());
                algumAlugado = true;
            }
        }
        if (!algumAlugado) {
            System.out.println("Nenhum veículo está alugado no momento.");
        }
    }

}
