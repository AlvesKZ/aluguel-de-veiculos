package models;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Veiculo> frota = new ArrayList<>();

    public List<Veiculo> getFrota() {
        return frota;
    }

    public void setFrota(List<Veiculo> frota) {
        this.frota = frota;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        frota.add(veiculo);
        System.out.println("Veículo adicionado à frota!");
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        System.out.println("Veículos disponíveis:");
        for (int i = 0; i < frota.size(); i++) {
            Veiculo v = frota.get(i);
            if (!v.isAlugado()) {
                System.out.println("[" + i + "] " + v.exibirDetalhes());
            }
        }
        return frota;
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
        System.out.println("Relatório da frota completa:");
        for (int i = 0; i < frota.size(); i++) {
            Veiculo veiculo = frota.get(i);
            System.out.println(i + " - " + veiculo.exibirDetalhes());
        }
    }
}
