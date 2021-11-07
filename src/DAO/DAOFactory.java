package DAO;

public class DAOFactory {

		public static GenericDAO getDAO(String type) {
			if (type.equalsIgnoreCase("promocion")) {
				return new PromocionDAOImpl();
			} else if (type.equalsIgnoreCase("usuario")){
				return new UsuarioDAOImpl();
			} else if (type.equalsIgnoreCase("atraccion")) {
				return new AtraccionDAOImpl();
			}
			return null;
		}
}