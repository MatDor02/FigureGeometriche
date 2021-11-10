package Figure;

public class Triangolo extends Figura {


	private double base, altezza, lato2, lato3;

	public Triangolo(String nome, double altezza, double latoRelativoAdAltezza, double lato2, double lato3) {
		super(nome);
		base = latoRelativoAdAltezza;
		this.altezza = altezza;
		this.lato2 = lato2;
		this.lato3 = lato3;
	}

	public double getBase() {
		return base;
	}

	public double getAltezza() {
		return altezza;
	}

	public double getLato2() {
		return lato2;
	}

	public double getLato3() {
		return lato3;
	}

	public double getPerimetro() {
		return base + lato2 + lato3;
	}

	public double getArea() {
		return base*altezza;
	}
}

