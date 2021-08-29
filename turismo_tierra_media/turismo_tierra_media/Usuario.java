package turismo_tierra_media;

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
	}

	public void comprarProducto(Producto atraccion) throws UsuarioException {

		if ((this.getMonedasDeOro() >= atraccion.costo)
				&& (this.tiempoDisponible >= atraccion.tiempoDeDuracion)) {

			/* this.productos = new Producto[CANTIDAD_MAXIMA_DE_PRODUCTOS_POR_USUARIO];
			this.productos[libre] = new Producto(costo, tiempoDeDuracion, tipoDeAtraccion);
			this.libre++; */
			this.monedasDeOro -= atraccion.costo;
			this.tiempoDisponible -= atraccion.tiempoDeDuracion;

		} else
			throw new UsuarioException(
					"El usuario no prefiere este tipo de atraccion, o tiene monedas o tiempo insuficientes");

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

	public Producto getProductosComprados() {
		return this.productos;
	}

	public TipoDeAtraccion getTipoDeAtraccionFavorita() {
		return this.atraccionFavorita;
	}

}
