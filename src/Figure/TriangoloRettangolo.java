package Figure;

import java.lang.*;

public class TriangoloRettangolo extends Triangolo {

	public TriangoloRettangolo(double cateto1, double cateto2) {
		super("Triangolo rettangolo", cateto1, cateto2,/*ipotenusa*/ Math.sqrt(cateto1*cateto1 + cateto2*cateto2));
	}

	public TriangoloRettangolo(char c, double cateto1, double ipotenusa) {
		super("Triangolo rettangolo", cateto1, /* cateto2 */ Math.sqrt(ipotenusa*ipotenusa - cateto1*cateto1), ipotenusa);
	}
}
