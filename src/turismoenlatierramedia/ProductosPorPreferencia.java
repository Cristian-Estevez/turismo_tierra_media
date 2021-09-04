package turismoenlatierramedia;

import java.util.Comparator;

public class ProductosPorPreferencia implements Comparator<Producto> {

	

	public ProductosPorPreferencia(TipoDeAtraccion preferencia) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		int retorno = 0;
		if (o1.tipoDeAtraccion == o2.tipoDeAtraccion) {
			retorno = 0;
		}
		return retorno;
	}

}
