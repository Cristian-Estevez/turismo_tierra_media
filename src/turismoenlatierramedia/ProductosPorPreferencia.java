package turismoenlatierramedia;

import java.util.Comparator;

public class ProductosPorPreferencia implements Comparator<Producto> {

	

	public ProductosPorPreferencia(TipoDeAtraccion preferencia) {
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		int valorARetornar = 0;
		valorARetornar = -(o1.getTipo().compareTo(o2.getTipo()));
		if (valorARetornar != 0)
			return valorARetornar;
		valorARetornar = -(((Double) o1.getCosto()).compareTo(((Double)o2.getCosto())));
		if (valorARetornar != 0) {
			return valorARetornar;
		}
		return valorARetornar;
	}

}
