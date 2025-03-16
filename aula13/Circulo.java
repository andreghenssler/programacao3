package aula13;

public class Circulo extends Figura {
    private float raio;

    public  float getRaio(){
      return  raio;
    }

    public  void setRaio(float raio){
      this.raio = raio;
    }


    @Override
    public double calculaArea() {
      return 1;
    }

    @Override
    public double calculaPerimetro() {
      return 0;
    }
}
