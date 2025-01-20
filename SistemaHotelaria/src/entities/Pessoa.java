package entities;

import static Application.Cadastro.pessoas;

public class Pessoa{
    String nome;
    int idade;


    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public static void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("\nPessoas cadastradas:");
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }


    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + " " ;
    }

}
