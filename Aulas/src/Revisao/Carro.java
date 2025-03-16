package Revisao;

public class Carro extends Veiculo {
    private int quantidadeDePortas;

    // Construtor
    public Carro(String marca, String modelo, int ano, int quantidadeDePortas) {
        super(marca, modelo, ano); // Chama o construtor da classe base
        this.quantidadeDePortas = quantidadeDePortas;
    }

    // Getter e Setter para quantidadeDePortas
    public int getQuantidadeDePortas() {
        return quantidadeDePortas;
    }

    public void setQuantidadeDePortas(int quantidadeDePortas) {
        this.quantidadeDePortas = quantidadeDePortas;
    }

    // Sobrescrevendo o método exibirDetalhes
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Chama o método da classe base
        System.out.println("Quantidade de Portas: " + quantidadeDePortas);
        System.out.println();
    }
}
