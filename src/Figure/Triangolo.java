package Figure;

import java.lang.*;

public class Triangolo extends Figura {


	private double lato1, lato2, lato3, altezza1;

	public Triangolo(String nome, double lato1, double lato2, double lato3) {
		super(nome);
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.lato3 = lato3;
		setAltezza1(lato1, lato2, lato3);
	}

	public double getLato1() {
		return lato1;
	}

	public double getLato2() {
		return lato2;
	}

	public double getLato3() {
		return lato3;
	}

	public double getAltezza1() {
		return altezza1;
	}

	private void setAltezza1(double base, double latoSx, double latoDx) {
		double  altezza, cosAlfa;
		cosAlfa = (base*base + latoSx*latoSx - latoDx*latoDx)/(2 * base * latoSx);
		altezza = latoSx * Math.sqrt(1 - cosAlfa * cosAlfa);
		altezza1 = altezza;
	}

	public double getPerimetro() {
		return lato1 + lato2 + lato3;
	}

	public double getArea() {
		return lato1 * altezza1 / 2;
	}
}

