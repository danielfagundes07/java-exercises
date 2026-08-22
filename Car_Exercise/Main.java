package Car_Exercise;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {
                List<Car> cars = List.of(
                                new Car("Toyota", "Corolla", 2020, 50000),
                                new Car("Honda", "Civic", 2019, 65000),
                                new Car("Ford", "Focus", 2018, 58000),
                                new Car("Chevrolet", "Onix", 2021, 73900),
                                new Car("Volkswagen", "Golf", 2017, 46900),
                                new Car("Hyundai", "Elantra", 2022, 68500),
                                new Car("Toyota", "Camry", 2015, 78000),
                                new Car("Honda", "Accord", 2016, 47900),
                                new Car("Ford", "Fusion", 2014, 89000),
                                new Car("Chevrolet", "Cruze", 2013, 43000));

                boolean quit = false;

                try (Scanner scanner = new Scanner(System.in)) {
                        System.out.println("Bem vindo ao seu Relatório de Carros Java!");
                        while (!quit) {
                                System.out.print("""
                                                \n1) Filtrar carros por ano
                                                2) Ordenar carros por preço (do mais barato para o mais caro)
                                                3) Extrair apenas os modelos e imprimir em maiúsculo
                                                4) Remover duplicados de modelos
                                                5) Verificar se existe alguma marca na concessionária
                                                6) Pegar o primeiro carro da lista e imprimir
                                                7) Agrupar os carros por marca e imprimir cada grupo.
                                                8) Separar os carros em dois grupos: novos (>=2018) e antigos (<2018).
                                                9) Gerar estatísticas dos preços (min, max, média, soma, quantidade).
                                                10) Criar um relatório final com todos os resultados acima.
                                                0) Sair
                                                Digite uma opção:
                                                """);
                                int input = scanner.nextInt();
                                scanner.nextLine();

                                if (input >= 1 && input <= MenuOption.values().length) {
                                        MenuOption option = MenuOption.values()[input - 1];
                                        option.execute(cars, scanner);
                                } else if (input == 0) {
                                        System.out.println("Obrigado por utilizar o programa!");
                                        quit = true;
                                } else {
                                        System.out.println("Opção inválida, tente novamente.");
                                }

                        }
                } catch (InputMismatchException e) {
                        System.out.println("Erro de digitação. Tente novamente");
                }

        }

        enum MenuOption {
                FILTER_BY_YEAR {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                System.out.println("Escolha o ano:");
                                int ano = scanner.nextInt();
                                cars.stream().filter(c -> c.getYear() >= ano)
                                                .forEach(c -> System.out.println(c.printCar()));
                        }
                },
                SORT_BY_PRICE {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                cars.stream().sorted(Comparator.comparing(Car::getPrice))
                                                .forEach(c -> System.out.println(c.printCar()));
                        }
                },
                DISTINCT_PRINT_UPPERCASE {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                cars.stream().map(Car::getModel).forEach(c -> System.out.println(c.toUpperCase()));
                        }
                },
                REMOVE_MODEL_DUPLICATES {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                cars.stream().map(Car::getModel).distinct().forEach(System.out::println);
                        }
                },
                CHECK_BRAND {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                System.out.print("Digite o carro que deseja buscar na consessionária: ");

                                String userCar = scanner.nextLine();
                                boolean hasCar = cars.stream()
                                                .anyMatch(c -> c.getBrand().equalsIgnoreCase(userCar));

                                System.out.println(hasCar ? "Existe carro da marca " + userCar
                                                : "Não existe carro da marca " + userCar);
                        }
                },
                RETURN_FIRST_CAR {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                cars.stream()
                                                .findFirst()
                                                .ifPresent(c -> System.out.println(c.printCar()));
                        }
                },
                GROUPING_BY_BRAND {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                Map<String, List<Car>> listByBrand = cars.stream()
                                                .collect(Collectors.groupingBy(Car::getBrand));

                                listByBrand.forEach((brand, list) -> {
                                        System.out.println("Marca: " + brand);
                                        list.forEach(c -> System.out.println(" - " + c.printCar()));
                                });
                        }
                },
                PARTITIONING_BY_YEAR {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                Map<Boolean, List<Car>> listByYear = cars.stream()
                                                .collect(Collectors.partitioningBy(c -> c.getYear() >= 2018));

                                System.out.println("\n=========== RELATÓRIO POR ANO ===========");
                                listByYear.forEach((isNew, list) -> {
                                        System.out.println(isNew ? "\nNovos (>=2018):" : "\nAntigos (<2018):");
                                        if (list.isEmpty()) {
                                                System.out.println("  Nenhum carro encontrado.");
                                        } else {
                                                list.forEach(c -> System.out.println("  - " + c.printCar()));
                                        }
                                });
                                System.out.println("=========================================\n");
                        }
                },
                PRICE_STATISTICS {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                Map<String, DoubleSummaryStatistics> statsByBrand = cars.stream()
                                                .collect(Collectors.groupingBy(
                                                                Car::getBrand,
                                                                Collectors.summarizingDouble(Car::getPrice)));

                                System.out.println("\n=========== RELATÓRIO POR MARCA ===========");
                                statsByBrand.forEach((brand, stats) -> {
                                        System.out.println("\nMarca: " + brand);
                                        System.out.printf("%-25s %d%n", "Quantidade de carros:", stats.getCount());
                                        System.out.printf("%-25s %.2f%n", "Preço mínimo:", stats.getMin());
                                        System.out.printf("%-25s %.2f%n", "Preço máximo:", stats.getMax());
                                        System.out.printf("%-25s %.2f%n", "Soma dos preços:", stats.getSum());
                                        System.out.printf("%-25s %.2f%n", "Média dos preços:", stats.getAverage());
                                });
                                System.out.println("===========================================\n");

                        }
                },
                OVERALL_STATISTICS {
                        @Override
                        void execute(List<Car> cars, Scanner scanner) {
                                DoubleSummaryStatistics stats = cars.stream()
                                                .collect(Collectors.summarizingDouble(Car::getPrice));

                                System.out.println("\n================ RELATÓRIO GERAL =================");
                                System.out.printf("%-25s %d%n", "Quantidade de carros:", stats.getCount());
                                System.out.printf("%-25s %.2f%n", "Preço mínimo:", stats.getMin());
                                System.out.printf("%-25s %.2f%n", "Preço máximo:", stats.getMax());
                                System.out.printf("%-25s %.2f%n", "Soma dos preços:", stats.getSum());
                                System.out.printf("%-25s %.2f%n", "Média dos preços:", stats.getAverage());
                                System.out.println("==================================================\n");
                        }
                };

                abstract void execute(List<Car> cars, Scanner scanner);
        }
}