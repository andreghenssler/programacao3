package aula13;

public class Retangulo extends Figura {
    private float lado;
    private float altura;

    public  float getLado(){
      return  lado;
    }

    public  void setLado(){
      this.lado = lado;
    }
    public  float geAltura(){
      return  altura;
    }

    public  void setAltura(){
      this.altura = altura;
    }

    @Override
    public double calculaArea() {
      return altura*lado;
    }

    @Override
    public double calculaPerimetro() {
      return altura*2+lado*2;
    }
}
