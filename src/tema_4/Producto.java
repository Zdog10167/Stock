package tema_4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Producto {

	String nombre;
	double precio;

	public Producto(String Nombre, double Precio) {

		if (Nombre != null) {
			nombre = Nombre.toUpperCase();
		}

		BigDecimal precioCortado = new BigDecimal(Precio).setScale(2, RoundingMode.DOWN);
		precio = precioCortado.doubleValue();
	}

	public void crearProducto(Scanner sc, Producto newProducto) {
		sc.nextLine();

		System.out.println("Nombre: ");
		newProducto.nombre = sc.nextLine();

		System.out.println("Precio: ");

		newProducto.precio = sc.nextDouble();

		cortarDecimales(precio);
	}

	public double cortarDecimales(double Precio) {
		BigDecimal precioCortado = new BigDecimal(Precio).setScale(2, RoundingMode.DOWN);
		return precio = precioCortado.doubleValue();
	}

	public void mostrarProducto(Producto newProducto) {
		System.out.println("\n\n\n Datos de " + newProducto.nombre + ": \n");

		System.out.println("Nombre: " + newProducto.nombre);
		System.out.println("Precio: " + newProducto.precio);
	}

	// Constructores

}
