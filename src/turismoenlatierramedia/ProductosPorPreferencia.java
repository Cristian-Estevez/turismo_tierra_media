package turismoenlatierramedia;

import java.util.Comparator;

public class ProductosPorPreferencia implements Comparator<Producto> {

	private TipoDeAtraccion tipoFavorito;
	

	public ProductosPorPreferencia(TipoDeAtraccion tipoDeAtraccionPreferido) {
		this.tipoFavorito = tipoDeAtraccionPreferido;
		
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		
		
			if (o1.getTipo() == this.tipoFavorito && o2.getTipo() == this.tipoFavorito) {
				// si las dos son del mismo tipo preferido, compara para ver cual es promocion
				if (o1.esPromocion() && o2.esPromocion()) {
					// si las dos son promociones, compara por el costo 
					if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
						// si el costo es el mismo, compara por el tiempo
						return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
					} else { 
						return -Double.compare(o1.getCosto(), o2.getCosto());
					} 
				} else if (!o1.esPromocion() && !o2.esPromocion()) {
					// ninguna es promo, compara por costo
					if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
						// mismo costo, comparo por tiempo finalmente
						return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
					} else {
						return -Double.compare(o1.getCosto(), o2.getCosto());
					}
				} else {
					return -Boolean.compare(o1.esPromocion(), o2.esPromocion());
				}
			} else if (o1.getTipo() != this.tipoFavorito && o2.getTipo() != this.tipoFavorito){
				if (o1.esPromocion() && o2.esPromocion()) {
					// ambas son promos, compara por costo
					if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
						// mismo costo, comparo por tiempo finalmente
						return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
					} else {
						return -Double.compare(o1.getCosto(), o2.getCosto());
					}
				} else if (!o1.esPromocion() && !o2.esPromocion()) {
					// ninguna es promo, compara por costo
					if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
						// mismo costo, comparo por tiempo finalmente
						return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
					} else {
						return -Double.compare(o1.getCosto(), o2.getCosto());
					}
				} else {
					return -Boolean.compare(o1.esPromocion(), o2.esPromocion());
				}
			} else {
				// una es preferida y la otra no
				if (o1.getTipo() == this.tipoFavorito) return -1;
				return 1;
			}
		}
}
		
		
		
		  
		
		
		
		
		
		
		
		
		
		
		/*
		if (o1.getTipo() == this.tipoFavorito && o2.getTipo() == this.tipoFavorito) {
			if (o1.esPromocion() && o2.esPromocion()) {
				if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
					return Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
				}
				else {
					return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
				} 
				else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				} 
				} else {
					return -Boolean.compare(o1.esPromocion(), o2.esPromocion());
				}
		} else if (o1.getTipo() != this.tipoFavorito && o2.getTipo() != this.tipoFavorito) {
			if (o1.esPromocion() && o2.esPromocion()) {
				if (Double.compare(o1.getCosto(), o2.getCosto() == 0)) {
					return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion();
				}else {
					return Double.compare((o1.getCosto(), o2.getCosto());
				} }else if (!o1.esPromocion() && !o2.esPromocion()) {
					if (Double.compare(o1.getCosto(), o2.getCosto() == 0) {
						return -Double.compare(o1.getTiempoDeDuracion(), o2.getTiempoDeDuracion());
					}else {
						return -Double.compare(o1.esPromocion(), o2.esPromocion());
					}} else {
						if (o1.getTipo() == this.tipoFavorito) return -1;
						return 1;
						
							
					
				}
			}
		}
			/*
		
		/*
		int valorARetornar = 0;
		valorARetornar = -(o1.getTipo().compareTo(o2.getTipo()));
		if (valorARetornar != 0)
			return valorARetornar;
		valorARetornar = -(((Double) o1.getCosto()).compareTo(((Double)o2.getCosto())));
		if (valorARetornar != 0) {
			return valorARetornar;
		}
		return valorARetornar;
	}*/


