package tema_4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {
	int cantidad;

	double importe;
	double precioTotal;

	Pedido Pedido;

	String codigoPago;

	double efectivo;
	String tarjeta;
	String cuenta;

	public PasarelaDePago(Pedido pedido) {
		Pedido = pedido;
	}
	// Metodos

	public double calcularCosteTotal(Pedido pedidoProducto) {
		double coste = pedidoProducto.productos[0].precio;
		if (pedidoProducto.productos[1] != null) {
			coste += pedidoProducto.productos[1].precio;
		}

		BigDecimal importeCortado = new BigDecimal(coste).setScale(2, RoundingMode.DOWN);
		coste = importeCortado.doubleValue();

		if (Pedido.pagado = true) {
			codigoPago = Long.toString(new Date().getTime());
			importe = 0;
		}
		precioTotal = coste;
		return coste;
	}

	public void elegirMetodoPago(Pedido pedido, Scanner sc) {
		System.out.println("Elige tu método de pago: \n 1. Efectivo \n 2. Tarjeta");
		int respuesta = 0;
		while (respuesta != 1 && respuesta != 2) {
			respuesta = sc.nextInt();
			switch (respuesta) {
				case 1: {
					efectivo(pedido, sc);
				} break;
				case 2: {
					tarjeta();
				}
					break;
				default:
					System.err.println("Valor inválido");
			}
		}
	}

	public void efectivo(Pedido pedido, Scanner sc) {

		System.out.println("Introduzca su importe: ");

		double importe = sc.nextDouble();

		BigDecimal importeCortado = new BigDecimal(importe).setScale(2, RoundingMode.DOWN);
		importe = importeCortado.doubleValue();

		while (importe < precioTotal) {
			System.out.println("Importe demasiado bajo, introduzca de nuevo");
			importe = sc.nextDouble();
		}
		
		System.out.println("Cantidad válida, cambio: " + calcularCambio(importe, precioTotal));
		pedido.pagado = true;
	}

	public void tarjeta() {
		System.out.println("Pase la tarjeta por el tarjetero");
	}

	public double calcularCambio(double importe, double precio) {
		double cambio = importe - precio;

		BigDecimal importeCortado = new BigDecimal(cambio).setScale(2, RoundingMode.DOWN);
		cambio = importeCortado.doubleValue();

		return cambio;
	}

	public String generarCodigoPago() {
		codigoPago = Long.toString(new Date().getTime());
		return codigoPago;
	}

}
