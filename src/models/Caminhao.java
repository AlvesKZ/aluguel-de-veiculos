package models;

public class Caminhao extends Veiculo{
    private double capacidade;

    public Caminhao(String marca, String modelo, int ano, double precoDiaria, boolean alugado, double capacidade) {
        super(marca, modelo, ano, precoDiaria, alugado);
        setCapacidade(capacidade);
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public double calcularPrecoAluguel(int dias) {
        double totalAluguel = (getPrecoDiaria() + 50) * dias;

        System.out.printf("Preço total do aluguel: %.2f", totalAluguel);
        System.out.println();
        return totalAluguel;
    }

    @Override
    public String exibirDetalhes() {
        return String.format("Veiculo: %s %s (%d) - R$%.2f/dia - Alugado: %s - Capacidade total (em toneladas): %.2f",
                getMarca(), getModelo(), getAno(), getPrecoDiaria(), isAlugado() ? "Sim" : "Não", getCapacidade());
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}
