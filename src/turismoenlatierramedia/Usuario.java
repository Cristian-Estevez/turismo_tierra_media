package turismoenlatierramedia;

/**
 * 
 * @author Micaela Trisi
 *
 */
public class Usuario {

	private String nombre;
	private double monedasDeOro;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private Producto[] productos;
	private int libre = 0;
	private final static int CANTIDAD_MAXIMA_DE_PRODUCTOS_POR_USUARIO = 1000; // hasta que veamos listas

	public Usuario(String nombre, double monedasDeOro, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.monedasDeOro = monedasDeOro;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		productos = new Producto[CANTIDAD_MAXIMA_DE_PRODUCTOS_POR_USUARIO];
	}

	/*
	 * @pre app envía la confirmación de la compra, 
	 * se asigna el producto comprado al usuario y se descuentan tiempo y monedasDeOro necesarios
	 * 
	 * ¡¡¡¡¡¡¡¡¡¡¡¡¡PREGUNTAR SI HACE FALTA LA DOBLE VERIFICACIÓN DE DISPONIBILIDAD DE DINERO Y TIEMPO DEL USUARIO, YA QUE APP 
	 * NO OFRECE LA ATRACCION A MENOS QUE EL USUARIO TENGA EL DINERO Y TIEMPO NECESARIOS!!!!!!!
	 */
	public void comprarProducto(Producto atraccion) throws UsuarioException {

		if ((this.getMonedasDeOro() >= atraccion.getCosto())
				&& (this.tiempoDisponible >= atraccion.getTiempoDeDuracion())) {
		
			this.productos[libre] = atraccion;
			this.libre++; 
			this.monedasDeOro -= atraccion.getCosto();
			this.tiempoDisponible -= atraccion.getTiempoDeDuracion();

		} else
			throw new UsuarioException(	"El usuario tiene monedas o tiempo insuficientes");

	}

	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getMonedasDeOro() {
		return this.monedasDeOro;
	}

	public Producto[] getProductosComprados() {
		return this.productos;
	}

	public TipoDeAtraccion getTipoDeAtraccionFavorita() {
		return this.atraccionFavorita;
	}

}
