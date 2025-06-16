package models;

public class Carro extends Veiculo{
    private int numeroDePortas;

    public Carro(String marca, String modelo, int numeroDePortas, int ano, double precoDiaria, boolean alugado) {
        super(marca, modelo, ano, precoDiaria, alugado);
        setNumeroDePortas(numeroDePortas);
    }

    public int getNumeroDePortas() {
        return this.numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public double calcularPrecoAluguel(int dias) {
        double totalAluguel = getPrecoDiaria() * dias;

        if (dias > 7) {
            totalAluguel -= totalAluguel * 0.1;
        }

        System.out.printf("Preço total do aluguel: %.2f", totalAluguel);
        System.out.println();
        return totalAluguel;
    }

    @Override
    public String exibirDetalhes() {
        return String.format("Veiculo: %s %s (%d) - R$%.2f/dia - Alugado: %s - Numero de portas: %d",
                getMarca(), getModelo(), getAno(), getPrecoDiaria(), isAlugado() ? "Sim" : "Não", getNumeroDePortas());
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}
