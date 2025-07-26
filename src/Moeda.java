public class Moeda {
    private String nome;   // Ex: "BRL"
    private double valor;  // Ex: 5.31

    public Moeda(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + ": " + valor;
    }
}

