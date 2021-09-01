package turismoenlatierramedia;

import java.util.ArrayList;
import java.util.List;


public class Usuario {

	private String nombre;
	private double monedasDeOro;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private List<Producto> productos;

	public Usuario(String nombre, double monedasDeOro, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.monedasDeOro = monedasDeOro;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		this.productos =  new ArrayList<Producto>();
	}

	/*
	 * @pre app envía la confirmación de la compra, 
	 * se asigna el producto comprado al usuario y se descuentan tiempo y monedasDeOro necesarios
	 * envia mensaje Atraccion.ocuparPlaza()
	 * 
	 * ¡¡¡¡¡¡¡¡¡¡¡¡¡PREGUNTAR SI HACE FALTA LA DOBLE VERIFICACIÓN DE DISPONIBILIDAD DE DINERO Y TIEMPO DEL USUARIO, YA QUE APP 
	 * NO OFRECE LA ATRACCION A MENOS QUE EL USUARIO TENGA EL DINERO Y TIEMPO NECESARIOS!!!!!!!
	 */
	public void comprarProducto(Producto atraccion) throws UsuarioException {

		if ((this.getMonedasDeOro() >= atraccion.getCosto()) && 
			(this.tiempoDisponible >= atraccion.getTiempoDeDuracion())) {
			
			this.monedasDeOro -= atraccion.getCosto();
			this.tiempoDisponible -= atraccion.getTiempoDeDuracion();
			this.productos.add(atraccion);
			
			try {
				atraccion.ocuparPlaza();
			} catch (AtraccionException e) {
				System.out.println(e.getMessage());
			}

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

	public List<Producto> getProductosComprados() {
		return this.productos;
	}

	public TipoDeAtraccion getTipoDeAtraccionFavorita() {
		return this.atraccionFavorita;
	}
	
	

}
