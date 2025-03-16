package Animal;

public class Mamifero extends Animal {
    private String alimento;

    public Mamifero(String nome, String cor, String alimento, int comprimento, float velocidade, int patas) {
        super(nome, cor, "Terra", comprimento, velocidade, patas); // ambiente padrão terra
        this.alimento = alimento;
    }

    public void alteraAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String alimento() {
        return this.alimento;
    }

    public void andar(float velocidade) {
        System.out.println(nome + " está andando a " + velocidade + " m/s.");
    }

    @Override
    public void dados() {
        super.dados();
        System.out.println("Alimento preferido: " + this.alimento);
    }
}

