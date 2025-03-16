package Animal;

public class Peixe extends Animal {
    private String caracteristica;

    public Peixe(String nome, String caracteristica, int comprimento, float velocidade) {
        super(nome, "Cinzento", "Mar", comprimento, velocidade, 0); // cor padrão cinzenta, ambiente padrão mar, patas 0
        this.caracteristica = caracteristica;
    }

    public void nadar(float velocidade) {
        System.out.println(nome + " está nadando a " + velocidade + " m/s.");
    }

    @Override
    public void dados() {
        super.dados();
        System.out.println("Características: " + this.caracteristica);
    }
}
