package Figure;

import java.lang.*;

public class Cerchio extends Figura {

	public double raggio;

	public Cerchio(double raggio) {
		super("Cerchio");
		this.raggio = raggio;
	}

	public double getRaggio() {
		return raggio;
	}

	public double getPerimetro() {
		return 2 * raggio * Math.PI;
	}

	public double getArea() {
		return Math.PI * Math.pow(raggio, 2);
	}
}
