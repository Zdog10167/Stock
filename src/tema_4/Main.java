package tema_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Clientes ya creados

		Cliente cliente1 = new Cliente("Francisco", "Franco", "666616666", "Calle Limón", null);
		Cliente cliente2 = new Cliente("San", "Jose", "736933223", "Calle limón", null);
		Cliente cliente3 = new Cliente("Maricarmen", "Algo", "234765348", "Orihuela", null);
		
		Producto producto1 = new Producto("Coca cola", 0.59);
		Producto producto2 = new Producto("Hamburguesa", 7.50);
		
		// Cliente nuevo a modificar

		Cliente clienteNuevo = new Cliente(null, null, "3", null, null);

		int respuesta1 = 0;

		while (respuesta1 != 3) {
			System.out.println("###### Menu inicial ######");

			System.out.println("\n\n Elige una opción:");

			System.out.println(" 1. Mostrar clientes existentes o crear nuevos \n 2. Mostrar productos existentes o crear nuevos \n 3. Realizar un pedido");

			respuesta1 = sc.nextInt();

			switch (respuesta1) {

			// Mostrar clientes o crear nuevos
				case 1: {
					int respuesta2 = 0;
					while (respuesta2 != 3) {
						System.out.println("\n\n Quieres crear un nuevo usuario o ver los ya creados");
						System.out.println("\n 1. Crear nuevo \n 2. Mostrar los ya creados \n 3. Salir");
						respuesta2 = 0;

						Scanner sca = new Scanner(System.in);

						respuesta2 = sca.nextInt();

						switch (respuesta2) {

						// Crear un usuario nuevo

							case 1: {
								if (clienteNuevo.direccion != null) {
									System.out.println("Ya se ha creado un nuevo usuario, ¿quiere modificarlo? \n Si \n No" );
									sc.nextLine();
									String modCliente = sc.nextLine();
									if (modCliente.equalsIgnoreCase("Si")) {
										clienteNuevo.crearCliente(clienteNuevo, sc);
									}
								} else {
									clienteNuevo.crearCliente(clienteNuevo, sc);
								}
							} break;

							// Mostrar los ya creados

							case 2: {
								cliente1.mostrarCliente(cliente1);
								cliente2.mostrarCliente(cliente2);
								cliente3.mostrarCliente(cliente3);

								if (clienteNuevo.direccion != null) {
									clienteNuevo.mostrarCliente(clienteNuevo);
								}

							} break;

						} sca.close();
					}
				} break;

				// Ver productos o crear nuevos
				case 2: {

				} break;

				// Este va vacío para que no de el erorr del default
				case 3: {

				} break;

				// Error en caso de que se pulse otro número
				default: {
					System.out.println("Valor inválido");
				}
			}
		}
		sc.close();
	}

}