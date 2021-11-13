package Figure;

import myExceptions.*;

public class Rettangolo extends Figura {

	private double base, altezza;

	public Rettangolo(String nome, double base, double altezza) {
		super(nome);
		this.base = base;
		this.altezza = altezza;
	}

	public double getBase() {
		return base;
	}

	public double getAltezza() {
		return altezza;
	}

	public double getPerimetro() {
		return 2*base + 2*altezza;
	}

	public double getArea() {
		return base * altezza;
	}
}
