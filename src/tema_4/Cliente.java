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

		if ((tel.length() == 9)
				&& (tel.startsWith("6") || tel.startsWith("7") || tel.startsWith("8") || tel.startsWith("9"))) {
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

		direccion = dir;

		if (fechaAlta == null) {
			fechaDeAlta = new Date();
		} else {
			fechaDeAlta = fechaAlta;
		}
	}

	// Methods

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

		while ((clienteNuevo.telefono.length() != 9) && (clienteNuevo.telefono.startsWith("6") || clienteNuevo.telefono.startsWith("7") || clienteNuevo.telefono.startsWith("8") || clienteNuevo.telefono.startsWith("9"))) {
				System.out.println("\n Teléfono inválido, escriba otra vez: ");
				System.out.println("Número de teléfono: ");
				clienteNuevo.telefono = sc.nextLine();
			}
		
		comprobarTelefono(clienteNuevo);
		
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
