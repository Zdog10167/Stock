package tema_4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class PasarelaDePago {
	int cantidad;

	double importe;

	Pedido pedido1;

	String codigoPago;

	double efectivo;
	String tarjeta;
	String cuenta;

	public PasarelaDePago(double Importe) {
		BigDecimal importeCortado = new BigDecimal(Importe).setScale(2, RoundingMode.DOWN);
		importe = importeCortado.doubleValue();

		if (pedido1.pagado = true) {
			codigoPago = Long.toString(new Date().getTime());
			importe = 0;
		}
	}
	// Metodos

}
