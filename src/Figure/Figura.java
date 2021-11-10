package Figure;

public abstract class Figura {

	private double perimetro, area;
    String nomeFigura;

	public Figura(String nomeFigura) {
        this.nomeFigura = nomeFigura;
	}

    public abstract double getPerimetro();

    public abstract double getArea();

    public String toString() {
        return nomeFigura + " ---|--- Perimetro: " + getPerimetro() + " ..... Area: " + getArea();
    }

}
