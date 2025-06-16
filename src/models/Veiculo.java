package models;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double precoDiaria;
    private boolean alugado;

    // Construtor
    public Veiculo(String marca, String modelo, int ano, double precoDiaria, boolean alugado) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setPrecoDiaria(precoDiaria);
        this.setAlugado(alugado);
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    // Metodos
    public abstract double calcularPrecoAluguel(int dias);

    public void alugar() {
        if (isAlugado()) {
            System.out.println("Veiculo já está alugado");
            return;
        }

        setAlugado(true);
        System.out.println("Veiculo alugado com sucesso!");
    }

    public void devolver() {
        if (!isAlugado()) {
            System.out.println("Veiculo não está alugado");
            return;
        }

        setAlugado(false);
        System.out.println("Veiculo devolvido com sucesso!");
    }

    public String exibirDetalhes() {
        return String.format("Veiculo: %s %s (%d) - R$%.2f/dia - Alugado: %s",
                getMarca(), getModelo(), getAno(), getPrecoDiaria(), isAlugado() ? "Sim" : "Não");
    }


    public static void exibirTiposVeiculos() {
        System.out.println("Tipos de veículos disponíveis:");
        System.out.println("- Carro");
        System.out.println("- Moto");
        System.out.println("- Caminhão");
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }

}