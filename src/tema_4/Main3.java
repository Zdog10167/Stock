package tema_4;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente clientes[] = new Cliente[4];
		
		clientes[0] = new Cliente("Francisco", "Franco", "666616666", "Calle Limón", null);
		clientes[1] = new Cliente("San", "Jose", "736933223", "Calle limón", null);
		clientes[2] = new Cliente("Maricarmen", "tengosueñoaaaaaaaaaaaaaaaaa", "999999999", "Orihuela", null);
		clientes[3] = new Cliente(null, null, null, null, null);

		Producto productos[] = new Producto[3];

		productos[0] = new Producto("Coca cola", 0.59);
		productos[1] = new Producto("Hamburguesa", 7.50);
		
		Scanner sc = new Scanner(System.in);

		int respuesta1 = 0;

		while (respuesta1 != 3) {
			System.out.println("\n\n ###### Menu inicial ######");

			System.out.println("\n\n Elige una opción:");
			System.out.println(" 1. Mostrar clientes existentes o crear nuevos \n 2. Mostrar productos o crear nuevos \n 3. Realizar un pedido");

			respuesta1 = sc.nextInt();

			switch (respuesta1) {
				case 1: {
					clientes[0].crearMostrarClientes(sc, clientes);
				} break;

				case 2: {
					
				} break;

				case 3: {
					
				} break;

				default: {
					
				} break;
			}
		}
		sc.close();
	}

}
