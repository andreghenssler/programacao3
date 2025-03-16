package Animal;

public class Animal {
    protected String nome;
    protected  int comprimento;
    protected int patas;
    protected String cor;
    protected  String ambiente;
    protected  double velocidade;

    public Animal(String nome, String cinza, String mar, int comprimento, float velocidade, int i) {
        this.patas = 4;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public void dados()  {
        System.out.println("Nome: " + this.nome);
        System.out.println("Comprimento: " + this.comprimento + " cm");
        System.out.println("Patas: " + this.patas);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ambiente: " + this.ambiente);
        System.out.println("Velocidade: " + this.velocidade + " m/s");
    }
}

