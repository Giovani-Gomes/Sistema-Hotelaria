package Application;

import entities.Pessoa;
import entities.Suite;

import java.util.ArrayList;
import java.util.Scanner;

import static entities.Pessoa.listarPessoas;


public class Cadastro {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Suite> suites = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Cadastrar Pessoa");
            System.out.println("2. Cadastrar Suíte");
            System.out.println("3. Listar Pessoas");
            System.out.println("4. Listar Suítes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha após a opção

            switch (opcao) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    cadastrarSuite();
                    break;
                case 3:
                    listarPessoas();
                    break;
                case 4:
                    listarSuites();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarPessoa() {
        try {
            System.out.print("Digite o nome da pessoa: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade da pessoa: ");
            int idade = Integer.parseInt(scanner.nextLine());

            pessoas.add(new Pessoa(nome, idade));
            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Idade deve ser um número inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    public static void cadastrarSuite() {
        try {
            System.out.print("Digite o número da suíte: ");
            int numero = Integer.parseInt(scanner.nextLine());

            for (Suite suite : suites) {
                if (suite.numero == numero) {
                    throw new IllegalArgumentException("Já existe uma suíte com esse número.");
                }
            }

            System.out.print("Digite o tipo da suíte (ex: Luxo, Simples, etc): ");
            String tipo = scanner.nextLine();

            System.out.print("Digite o preço da suíte: ");
            double preco = Double.parseDouble(scanner.nextLine());


            suites.add(new Suite(numero, tipo, preco));
            System.out.println("Suíte cadastrada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Número ou preço inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }



    public static void listarSuites() {
        if (suites.isEmpty()) {
            System.out.println("Nenhuma suíte cadastrada.");
        } else {
            System.out.println("\nSuítes cadastradas:");
            for (Suite suite : suites) {
                System.out.println(suite);
            }
        }
    }
}
