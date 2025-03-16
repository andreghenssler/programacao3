package Revisao;

public class Moto extends Veiculo {
    private String tipoDeGuidom;

    // Construtor
    public Moto(String marca, String modelo, int ano, String tipoDeGuidom) {
        super(marca, modelo, ano); // Chama o construtor da classe base
        this.tipoDeGuidom = tipoDeGuidom;
    }

    // Getter e Setter para tipoDeGuidom
    public String getTipoDeGuidom() {
        return tipoDeGuidom;
    }

    public void setTipoDeGuidom(String tipoDeGuidom) {
        this.tipoDeGuidom = tipoDeGuidom;
    }

    // Sobrescrevendo o método exibirDetalhes
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Chama o método da classe base
        System.out.println("Tipo de Guidom: " + tipoDeGuidom);
        System.out.println();
    }
}
