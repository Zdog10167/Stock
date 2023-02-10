package tema_4;

import java.util.Date;
import java.util.Scanner;

public class Cliente {

	// Datos del cliente
	String nombre;
	String apellidos;
	String telefono;
	String tipoTel;
	String direccion;
	String historial;
	Date fechaDeAlta;

	Pedido pedidoCliente;

	PasarelaDePago codigoProd;

	public Cliente(String nom, String ap, String tel, String dir, Date fechaAlta) {
		if (nom != null) {
			nombre = nom.toLowerCase();
		}

		if (ap != null) {
			apellidos = ap.toUpperCase();
		}

		if (tel != null) {
			if ((tel.length() == 9) && (tel.startsWith("6") || tel.startsWith("7") || tel.startsWith("8") || tel.startsWith("9"))) {
				if (tel.startsWith("6") || tel.startsWith("7")) {
					tipoTel = "Movil";
					telefono = tel;
				} else {
					tipoTel = "Fijo";
					telefono = tel;
				}
			} else {
				tipoTel = "Invalido";
				telefono = null;
			}

			if (tel.contains("a") || tel.contains("b") || tel.contains("c") || tel.contains("d") || tel.contains("e")
					|| tel.contains("f") || tel.contains("g") || tel.contains("h") || tel.contains("i")
					|| tel.contains("j") || tel.contains("k") || tel.contains("l") || tel.contains("m")
					|| tel.contains("n") || tel.contains("o") || tel.contains("p") || tel.contains("q")
					|| tel.contains("r") || tel.contains("s") || tel.contains("t") || tel.contains("u")
					|| tel.contains("v") || tel.contains("w") || tel.contains("x") || tel.contains("y")
					|| tel.contains("z") || tel.contains("ñ")) {
				telefono = null;
				tipoTel = "invalido";
			}
		}

		direccion = dir;

		if (fechaAlta == null) {
			fechaDeAlta = new Date();
		} else {
			fechaDeAlta = fechaAlta;
		}
	}

	// Methods

	public Cliente crearMostrarClientes(Scanner sc, Cliente clientes[]) {
		System.out.println("\n\n ¿Quieres crear un nuevo cliente o ver los ya creados? \n\n 1. Crear nuevo \\n 2. Mostrar los ya creados \\n 3. Salir");

		int respuesta = sc.nextInt();

		switch (respuesta) {
			case 1: {
				// Crear un cliente, si ya existe modificarlo

				if (clientes[3].telefono == null) {
					clientes[3].crearCliente(clientes[3], sc);
				} else {
					System.out.println("Ya se ha creado un cliente, ¿quiere sobreescribirlo? \n 1. Si \n  2. No");
					int respuesta2 = sc.nextInt();
					switch (respuesta2) {
						case 1: {
							clientes[3].crearCliente(clientes[3], sc);
						} break;
						
						case 2: {
							// Vacío para que no de default
						} break;
						
						default:
							System.err.println("Valor inválido");
						}
				}
			} break;

			// Mostrar los clientes
			case 2: {
				clientes[0].mostrarClientes(clientes);

			} break;

			case 3: {
				// Vacío para que no de default
			}
			break;

		default: {
			System.err.println("Valor inválido");
		}
		}

		return clientes[3];
	}


	public void agregarPedido() {
		if (pedidoCliente.pagado = true) {
			historial = historial.concat(codigoProd.codigoPago);
		}
	}

	public void mostrarCliente(Cliente newCliente) {
		System.out.println("\n\n\n Datos de " + newCliente.nombre + ": \n");

		System.out.println("Nombre: " + newCliente.nombre);
		System.out.println("Apellido: " + newCliente.apellidos);
		System.out.println("Teléfono: " + newCliente.telefono);
		System.out.println("Tipo teléfono: " + newCliente.tipoTel);
		System.out.println("Dirección: " + newCliente.direccion);
		System.out.println("Fecha de alta: " + newCliente.fechaDeAlta);
	}

	public void mostrarClientes(Cliente clientes[]) {

		// La intención de este es que recorra el array entero escribiendo los datos de
		// todos los clientes, y en caso de que uno de ellos no tenga el teléfono bien
		// asignado no se mostrará

		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i].telefono != null) {
				System.out.println("\n\n\n Datos del cliente " + (i + 1) + ": \n");

				System.out.println("Nombre: " + clientes[i].nombre);
				System.out.println("Apellido: " + clientes[i].apellidos);
				System.out.println("Teléfono: " + clientes[i].telefono);
				System.out.println("Tipo teléfono: " + clientes[i].tipoTel);
				System.out.println("Dirección: " + clientes[i].direccion);
				System.out.println("Fecha de alta: " + clientes[i].fechaDeAlta);
			}
		}
	}

	public void mostrarClientesPedido(Cliente newCliente1, Cliente newCliente2, Cliente newCliente3,
			Cliente newCliente4) {
		System.out.println(newCliente1.nombre + ", telefono " + newCliente1.telefono);
		System.out.println(newCliente2.nombre + ", telefono " + newCliente2.telefono);
		if (newCliente3.telefono != null) {
			System.out.println(newCliente3.nombre + ", telefono " + newCliente4.telefono);
		}

		if (newCliente4.telefono != null) {
			System.out.println(newCliente2.nombre + ", telefono " + newCliente2.telefono);
		}

	}

	// Todo lo de elegirCliente se quedará obsoleto si el Main3 acaba siendo funcional
	
	// public Cliente elegirCliente(Scanner sc, Cliente cliente1, Cliente cliente2,
	// Cliente cliente3, Cliente cliente4, Cliente clientePedido) {
	public Cliente elegirCliente(Scanner sc, Cliente cliente1, Cliente cliente2, Cliente cliente3,
			Cliente clientePedido) {
		System.out.println("\n¿Con qué cliente quieres realizar el pedido? Escriba el número de teléfono\n");

		// cliente1.mostrarClientesPedido(cliente1, cliente2, cliente3, cliente4);

		sc.nextLine();
		String telElegido = sc.nextLine();


		if (telElegido.equals(cliente1.telefono)) {
			System.out.println("Pedido realizado con el cliente 1");
			clientePedido = cliente1;
			return clientePedido;
		} else if (telElegido.equals(cliente2.telefono)) {
			System.out.println("Pedido realizado con el cliente 2");
			clientePedido = cliente2;
			return clientePedido;
		} else if (telElegido.equals(cliente3.telefono)) {
			System.out.println("Pedido realizado con el cliente 3");
			clientePedido = cliente3;
			return clientePedido;
		} else {
			System.out.println("Cliente invalido");
			return clientePedido;
		}

	}


	public Cliente crearCliente(Cliente clienteNuevo, Scanner sc) {
		sc.nextLine();
		System.out.println("Nombre: ");
		clienteNuevo.nombre = sc.nextLine();

		System.out.println("Apellidos: ");
		clienteNuevo.apellidos = sc.nextLine();

		System.out.println("Número de teléfono: ");
		clienteNuevo.telefono = sc.nextLine();

		System.out.println("Dirección: ");
		clienteNuevo.direccion = sc.nextLine();

		comprobarTelefono(clienteNuevo);

		while (clienteNuevo.telefono == null) {
			System.out.println("\n Teléfono inválido, escriba otra vez: ");
			System.out.println("Número de teléfono: ");
			clienteNuevo.telefono = sc.nextLine();
			comprobarTelefono(clienteNuevo);
		}
		
		

		return clienteNuevo;
	}

	public void comprobarTelefono(Cliente clienteNuevo) {
		if ((clienteNuevo.telefono.length() == 9)
				&& (clienteNuevo.telefono.startsWith("6") || clienteNuevo.telefono.startsWith("7")
						|| clienteNuevo.telefono.startsWith("8") || clienteNuevo.telefono.startsWith("9"))) {
			if (clienteNuevo.telefono.startsWith("6") || clienteNuevo.telefono.startsWith("7")) {
				tipoTel = "Movil";
				telefono = clienteNuevo.telefono;
			} else {
				tipoTel = "Fijo";
				telefono = clienteNuevo.telefono;
			}
		} else {
			tipoTel = "Invalido";
			telefono = null;
		}

		if (clienteNuevo.telefono.contains("a") || clienteNuevo.telefono.contains("b")
				|| clienteNuevo.telefono.contains("c") || clienteNuevo.telefono.contains("d")
				|| clienteNuevo.telefono.contains("e") || clienteNuevo.telefono.contains("f")
				|| clienteNuevo.telefono.contains("g") || clienteNuevo.telefono.contains("h")
				|| clienteNuevo.telefono.contains("i") || clienteNuevo.telefono.contains("j")
				|| clienteNuevo.telefono.contains("k") || clienteNuevo.telefono.contains("l")
				|| clienteNuevo.telefono.contains("m") || clienteNuevo.telefono.contains("n")
				|| clienteNuevo.telefono.contains("o") || clienteNuevo.telefono.contains("p")
				|| clienteNuevo.telefono.contains("q") || clienteNuevo.telefono.contains("r")
				|| clienteNuevo.telefono.contains("s") || clienteNuevo.telefono.contains("t")
				|| clienteNuevo.telefono.contains("u") || clienteNuevo.telefono.contains("v")
				|| clienteNuevo.telefono.contains("w") || clienteNuevo.telefono.contains("x")
				|| clienteNuevo.telefono.contains("y") || clienteNuevo.telefono.contains("z") 
				|| clienteNuevo.telefono.contains("ñ")) {
			telefono = null;
			tipoTel = "invalido";
		}
	}

	// Setters y Getters

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String Telefono) {
		if ((Telefono.length() == 9) && (Telefono.startsWith("6") || Telefono.startsWith("7") || Telefono.startsWith("8") || Telefono.startsWith("9"))) {
			if (Telefono.startsWith("6") || Telefono.startsWith("7")) {
				tipoTel = "Movil";
				this.telefono = Telefono;
			} else {
				tipoTel = "Fijo";
				this.telefono = Telefono;
			}
		} else {
			tipoTel = "Invalido";
			this.telefono = null;
		}
	}

	/*
	 * agregarPedido(Pedido pedido)
	 * 
	 * 
	 */
}
