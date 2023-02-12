package tema_4;

import java.util.Scanner;

public class Pedido {

	Cliente cliente;

	Producto productos[];

	double importeTotal;

	PasarelaDePago pago;

	boolean pagado;
	boolean preparando;
	boolean listo;
	boolean entregado;
	
	public Pedido(Cliente cliente, Producto productos[]) {
		
		this.cliente = cliente;
		this.productos = productos;

	}

	// Methods

	public void realizarPedido(Cliente cliente, Producto productos[], PasarelaDePago pago, Pedido pedido, Scanner sc) {
		boolean cantidadStock = productos[0].comprobarStock(productos);
		if (cantidadStock == true) {
			double precioTotal = pago.calcularCosteTotal(pedido);
			System.out.println("Precio total: " + precioTotal);
			pago.elegirMetodoPago(pedido, sc);
		} else {
			System.out.println("No hay suficiente stock");
		}

	}


}
