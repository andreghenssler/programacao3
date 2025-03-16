package aula13;

public class Quadrada extends Figura{
    private float lado;
    public float getLado() {
        return lado;
    }
    public void setLado(float lado) {
        this.lado = lado;
    }
    @Override
    public double calculaArea() {
        return lado*lado;
    }
    @Override
    public double calculaPerimetro() {
        return 4*lado;
    }
}