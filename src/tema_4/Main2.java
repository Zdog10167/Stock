package tema_4;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Francisco", "Franco", "666616666", "Calle Limón", null);
		Cliente cliente2 = new Cliente("San", "Jose", "736933223", "Calle limón", null);
		Cliente cliente3 = new Cliente("Maricarmen", "maricaJAJAJAJA", "234765348", "Orihuela", null);

		Cliente clienteNuevo = new Cliente(null, null, "3", null, null);

		Producto producto1 = new Producto("Coca cola", 0.59);
		Producto producto2 = new Producto("Hamburguesa", 7.50);

		Producto productoNuevo = new Producto(null, 0);

		int respuesta1 = 0;

		Scanner sc = new Scanner(System.in);

		// Menú inicial, se repite hasta que se proceda a realizar el pedido
		do {
			System.out.println("\n\n ###### Menu inicial ######");

			System.out.println("\n\n Elige una opción:");
			System.out.println(" 1. Mostrar clientes existentes o crear nuevos \n 2. Mostrar productos o crear nuevos \n 3. Realizar un pedido");

			respuesta1 = sc.nextInt();
			
			switch (respuesta1) {
			case 1: {
					int respuesta2 = 0;

					System.out.println("\n\n ¿Quieres crear un nuevo cliente o ver los ya creados? \n\n 1. Crear nuevo \\n 2. Mostrar los ya creados \\n 3. Salir");

					respuesta2 = sc.nextInt();

					switch (respuesta2) {
					case 1: {
						// Crear un cliente, si ya existe modificarlo
						if (clienteNuevo.tipoTel.equalsIgnoreCase("Invalido")) {
							clienteNuevo.crearCliente(clienteNuevo, sc);
						} else {
							System.out.println("Ya se ha creado un cliente, ¿quiere sobreescribirlo? \n 1. Si \n  2. No");
							int respuesta3 = sc.nextInt();
							switch (respuesta3) {
							case 1: {
								clienteNuevo.crearCliente(clienteNuevo, sc);
							} break;
							case 2: {

							}
								break;
							default:
								System.out.println("Valor inválido");
							}
						}

						} break;
						// Mostrar los clientes
					case 2: {
							cliente1.mostrarCliente(cliente1);
							cliente2.mostrarCliente(cliente2);
							cliente3.mostrarCliente(cliente3);

							if (clienteNuevo.telefono != null) {
								clienteNuevo.mostrarCliente(clienteNuevo);
							}
						} break;

					case 3: {
						// Valor vacío para que no de el error
						} break;

						default: {
							System.out.println("Valor inválido");
						}
					}
				} break;

			case 2: {
				int respuesta2 = 0;

				System.out.println("\n\n ¿Quieres crear un nuevo producto o ver los ya creados?");
				System.out.println("\n 1. Crear nuevo \n 2. Mostrar los ya creados \n 3. Salir");

				respuesta2 = sc.nextInt();

				switch (respuesta2) {
				case 1: {
					productoNuevo.crearProducto(sc, productoNuevo);
				}
					break;

				case 2: {
					producto1.mostrarProducto(producto1);
					producto2.mostrarProducto(producto2);

					if (productoNuevo.nombre != null) {
						productoNuevo.mostrarProducto(productoNuevo);
					}
				}
					break;

				case 3: {

				}
					break;

				default: {
					System.out.println("Valor inválido");
				}
				}
				} break;
				
			case 3: {
				
			} break;

			default: {
				System.out.println("Valor inválido");
			}
			}
		} while (respuesta1 != 3);

		// Fin del while, a partir de aquí empieza la realización del pedido

		System.out.println("\n\n ###### Menu pedidos ######");

		Cliente clientePedido = new Cliente(null, null, "3", null, null);

		// clientePedido.elegirCliente(sc, cliente1, cliente2, cliente3, clienteNuevo,
		// clientePedido);

		clientePedido.elegirCliente(sc, cliente1, cliente2, cliente3, clientePedido);

		System.out.println("Datos cliente pago: \n Nombre: " + clientePedido.nombre + "Telefono: " + clientePedido.telefono);

		sc.close();
	}

}
