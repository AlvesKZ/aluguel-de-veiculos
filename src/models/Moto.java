package models;

public class Moto extends Veiculo{
    private boolean partidaEletrica;

    public Moto(String marca, String modelo, int ano, double precoDiaria, boolean alugado, boolean partidaEletrica) {
        super(marca, modelo, ano, precoDiaria, alugado);
        setPartidaEletrica(partidaEletrica);
    }

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public double calcularPrecoAluguel(int dias) {
        double totalAluguel = getPrecoDiaria() * dias;

        if (dias < 3) {
            totalAluguel += 15;
        }

        System.out.printf("Preço total do aluguel: %.2f", totalAluguel);
        System.out.println();
        return totalAluguel;
    }

    @Override
    public String exibirDetalhes() {
        return String.format("Veiculo: %s %s (%d) - R$%.2f/dia - Alugado: %s - Partida elétrica: %s",
                getMarca(), getModelo(), getAno(), getPrecoDiaria(), isAlugado() ? "Sim" : "Não", isPartidaEletrica() ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}
