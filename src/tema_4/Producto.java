package tema_4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Producto {

	String nombre;
	double precio;
	int[] stock = new int[30];


	public Producto(String Nombre, double Precio, int Stock) {

		if (Nombre != null) {
			nombre = Nombre.toUpperCase();
		}

		BigDecimal precioCortado = new BigDecimal(Precio).setScale(2, RoundingMode.DOWN);
		precio = precioCortado.doubleValue();

		for (int i = 0; i < Stock; i++) {
			stock[i] = 1;
		}
	}

	// Methods (pendiente de eliminar los obsoletos)

	public Producto crearMostrarStockProductos(Scanner sc, Producto productos[]) {
		System.out.println("\n\n ¿Quieres crear un nuevo producto o ver los ya creados?");
		System.out.println("\n 1. Crear nuevo \n 2. Mostrar los ya creados \n 3. Mostrar stock o añadir \n 4. Salir");

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
				productos[1].mostrarLlenarStock(productos, sc);
			}
			
			case 4: {
				//Vacío para que no de default
			} break;

			default: {
				System.out.println("Valor inválido");
			}
		}
		return productos[2];
	}

	public Producto crearProducto(Scanner sc, Producto newProducto) {
		sc.nextLine();

		System.out.println("Nombre: ");
		newProducto.nombre = sc.nextLine();

		System.out.println("Precio: ");

		newProducto.precio = sc.nextDouble();

		cortarDecimales(precio);

		System.out.println("¿Quieres añadir stock? \n 1. Si \n 2. No");
		
		int respuesta = sc.nextInt();
		
		switch (respuesta) {
			case 1: {
				newProducto.llenarStock(sc, newProducto);
			} break;
		
			case 2: {
				newProducto.stock[0] = 0;
			} break;
			
			default:
				System.err.println("Valor inválido");
		}

		return newProducto;
	}
	
	public void mostrarProductos(Producto productos[]) {
		int cantidadStock[] = new int[productos.length];
		for (int a = 0; a < productos.length; a++) {
			for (int b = 0; b < productos[a].stock.length; b++) {
				if (productos[a].stock[b] == 1) {
					cantidadStock[a]++;
				}
			}
		}

		for (int i = 0; i < productos.length; i++) {
			if (productos[i].nombre != null) {
				System.out.println("\n Datos producto " + (i + 1) + ": " + "\nNombre: " + productos[i].nombre + "\nPrecio: " + productos[i].precio + "\nStock: " + cantidadStock[i]);
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

	public int[] mostrarLlenarStock(Producto productos[], Scanner sc) {
		System.out.println("¿Quiere agregar stock o mostrar el existente? \n 1. Mostrar Stock \n 2. Agregar Stock \n 3. Salir");
		int respuesta = sc.nextInt();
		switch (respuesta) {
			case 1: {
				mostrarStock(productos);
			} break;
		
			case 2: {
				System.out.println("¿De que producto quieres llenar el stock? \n 1. " + productos[0].nombre + "\n 2. " + productos[1].nombre);
				if (productos[2].nombre != null) {
					System.out.println("3. " + productos[2].nombre);
				}
				int productoElegido = sc.nextInt();
				if (productoElegido == 1 || productoElegido == 2 || (productoElegido == 3 && productos[productoElegido].nombre != null)) {
					llenarStock(sc, productos[productoElegido]);
					return productos[productoElegido].stock;
				} else {
					System.err.println("Valor inválido");
				}
			} break;
		
			case 3: {
				// Valor vacío para que no de default
			} break;
		
			default:
				System.err.println("Valor inválido");
			}
		return productos[1].stock;
	}

	public void mostrarStock(Producto productos[]) {
		int cantidadStock[] = new int[productos.length];
		for (int a = 0; a < productos.length; a++) {
			for (int b = 0; b < productos[a].stock.length; b++) {
				if (productos[a].stock[b] == 1) {
					cantidadStock[a]++;
				}
			}
		}

		for (int i = 0; i < productos.length; i++) {
			if (productos[i].nombre != null) {
				System.out.println("Stock de " + productos[i].nombre + ": " + cantidadStock[i]);
			}
		}
	}

	public int llenarStock(Scanner sc, Producto producto) {
		System.out.println("¿Cuánto stock quieres añadir? Máximo 30");
		int cantStock = sc.nextInt();
		if (cantStock >= 30) {
			cantStock = 30;
		}
		for (int i = 0; i < cantStock; i++) {
			producto.stock[i] = 1;
		}

		return cantStock;
	}

	public Producto[] elegirProducto(Producto productos[], Scanner sc) {
		Producto productosPedido[] = new Producto[2];

		System.out.println("\n¿Que producto quieres agregar al pedido? \n 1. " + productos[0].nombre + "\n 2. " + productos[1].nombre);
		if (productos[2].nombre != null) {
			System.out.println(" 3. " + productos[2].nombre);
		}
		int producto1 = sc.nextInt();
		while (producto1 != 1 && producto1 != 2 && (producto1 != 3 || productos[2] == null)) {
			System.out.println("Valor inválido, escribalo de nuevo");
			producto1 = sc.nextInt();
		}
		productosPedido[0] = productos[producto1 - 1];

		System.out.println("¿Quiere añadir un segundo producto? \n 1. Si \n 2. No");

		int respuesta = sc.nextInt();
		
		switch (respuesta) {
			case 1: {
				System.out.println("\n¿Que producto quieres agregar al pedido? \n 1. " + productos[0].nombre + "\n 2. " + productos[1].nombre);
				if (productos[2].nombre != null) {
					System.out.println(" 3. " + productos[2].nombre);
				}
				int producto2 = sc.nextInt();
				while (producto2 != 1 && producto2 != 2 && (producto2 != 3 || productos[2] == null)) {
					System.out.println("Valor inválido, escribalo de nuevo");
					producto2 = sc.nextInt();
				}
				productosPedido[1] = productos[producto2 - 1];
			} break;
			case 2: {
				// Vacío para no default
			} break;
			default:
				System.err.println("Valor inválido, no se agregará un segundo producto");
			}

		return productosPedido;
	}

	public boolean comprobarStock(Producto producto[]) {
		if (producto[0].stock[0] == 0) {
			if (producto[1] != null) {
				if (producto[1].stock[0] == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	// Constructores

}
