package tema_4;

public class Pedido {

	Cliente cliente;

	Producto producto1;
	Producto producto2;
	double importeTotal;

	PasarelaDePago pago;

	boolean pagado;
	boolean preparando;
	boolean listo;
	boolean entregado;
	
	public Pedido(Cliente cliente, boolean Pagado, boolean Preparando, boolean Listo, boolean Entregado) {
		
		this.cliente = cliente;

		pagado = Pagado;
		preparando = Preparando;
		listo = Listo;
		entregado = Entregado;

		if (pagado = false) {
			preparando = false;
			listo = false;
			entregado = false;
		}
		if (preparando = false) {
			listo = false;
			entregado = false;
		}
		if (listo = false) {
			entregado = false;
		}

	}

	// Setters y Getters
	
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double ImporteCalc) {
		ImporteCalc = producto1.precio + producto2.precio;

		this.importeTotal = ImporteCalc;
	}


}
