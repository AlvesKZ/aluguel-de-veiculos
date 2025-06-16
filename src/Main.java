import models.*;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int opcao;

        Locadora locadora = new Locadora();
        inicializarVeiculos(locadora);

        do {
            System.out.println("\nDigite o número da operação desejada:");
            System.out.println("1 - Listar veículos disponíveis");
            System.out.println("2 - Alugar veículo");
            System.out.println("3 - Devolver veículo");
            System.out.println("4 - Mostrar relatório da frota (veículos alugados)");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            if (opcao < 0 || opcao > 4) {
                System.out.println("Valor inválido");
                continue;
            }

            switch (opcao) {
                case 1:
                    locadora.listarVeiculosDisponiveis();
                    break;
                case 2:
                    locadora.listarVeiculosDisponiveis();
                    System.out.println("Digite o número do veículo que deseja alugar:");
                    int indexAlugar = sc.nextInt();
                    System.out.println("Por quantos dias?");
                    int dias = sc.nextInt();
                    locadora.alugarVeiculo(indexAlugar, dias);
                    break;
                case 3:
                    System.out.println("Digite o número do veículo que deseja devolver:");
                    int indexDevolver = sc.nextInt();
                    locadora.devolverVeiculo(indexDevolver);
                    break;
                case 4:
                    locadora.exibirRelatorioFrota();
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void inicializarVeiculos(Locadora locadora) {
        Veiculo[] veiculos = {
                new Carro("Toyota", "Corolla", 2, 2020, 120.0, false),
                new Carro("Honda", "Civic", 2, 2019, 110.0, false),
                new Carro("Ford", "Ka", 4, 2018, 80.0, false),
                new Carro("Volkswagen", "Golf", 4, 2022, 150.0, false),
                new Carro("Chevrolet", "Onix", 2, 2021, 90.0, false),
                new Carro("Fiat", "Argo", 4, 2020, 85.0, false),
                new Carro("Renault", "Sandero", 4, 2017, 75.0, false),

                new Moto("Honda", "CG 160", 2021, 70.0, false, true),
                new Moto("Yamaha", "Fazer 250", 2022, 90.0, false, true),
                new Moto("Suzuki", "Yes 125", 2020, 60.0, false, false),
                new Moto("Dafra", "Next 300", 2019, 85.0, false, true),
                new Moto("Kawasaki", "Z400", 2023, 120.0, false, true),
                new Moto("BMW", "G310R", 2021, 130.0, false, true),
                new Moto("Haojue", "DK 150", 2018, 55.0, false, false),

                new Caminhao("Volvo", "FH", 2018, 250.0, false, 18.0),
                new Caminhao("Scania", "R450", 2020, 280.0, false, 20.0),
                new Caminhao("Mercedes-Benz", "Atego", 2019, 230.0, false, 15.0),
                new Caminhao("Volkswagen", "Constellation", 2021, 260.0, false, 17.0),
                new Caminhao("Iveco", "Tector", 2018, 220.0, false, 14.0),
                new Caminhao("Ford", "Cargo 2429", 2022, 270.0, false, 19.0),
                new Caminhao("MAN", "TGX", 2023, 300.0, false, 21.0)
        };

        for (Veiculo v : veiculos) {
            locadora.adicionarVeiculo(v);
        }
    }
}
