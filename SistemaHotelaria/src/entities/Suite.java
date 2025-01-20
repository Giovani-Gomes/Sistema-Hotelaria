package entities;

public class Suite {
    public int numero;
    String tipo;
    double preco;

    public Suite(int numero, String tipo, double preco) {

        if (numero == 5) {
            throw new IllegalArgumentException("O número 5 não pode ser utilizado para uma suíte.");
        }

        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Tipo: " + tipo + ", Preço: " + preco;
    }
}
