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

	public Producto crearMostrarProductos(Scanner sc, Producto productos[]) {
		System.out.println("\n\n ¿Quieres crear un nuevo producto o ver los ya creados?");
		System.out.println("\n 1. Crear nuevo \n 2. Mostrar los ya creados \n 3. Salir");

		int respuesta = sc.nextInt();

		switch (respuesta) {
		// Crear productos
			case 1: {
				productos[2].crearProducto(sc, productos[2]);
			} break;

			case 2: {
				productos[1].mostrarProductos(productos);
			} break;

			case 3: {
				//Vacío para que no de default
			} break;

		default: {
			System.out.println("Valor inválido");
		}
		}
		return productos[2];
	}

	public void crearProducto(Scanner sc, Producto newProducto) {
		sc.nextLine();

		System.out.println("Nombre: ");
		newProducto.nombre = sc.nextLine();

		System.out.println("Precio: ");

		newProducto.precio = sc.nextDouble();

		cortarDecimales(precio);
	}
	
	public void mostrarProductos(Producto productos[]) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i].nombre != null) {
				System.out.println("\n Datos producto " + (i + 1) + ": " + "\nNombre: " + productos[i].nombre + "\nPrecio: " + productos[i].precio);
			}
		}
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
