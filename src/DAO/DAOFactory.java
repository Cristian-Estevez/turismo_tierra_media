package DAO;

public class DAOFactory {
	
	
	public static class UsuarioDAOFactory {
	    public static  UsuarioDAO getUsuarioDAO(String type) { 
	        if (type.equalsIgnoreCase("Usuario")) {
	            return (UsuarioDAO) new UsuarioDAOImpl();
	        } else {
	            return (UsuarioDAO) new UsuarioDAOImpl();
	        }
	    }
	}
	
	
	public static class AtraccionDAOFactory {
	    public static AtraccionDAO getAtraccionDAO(String type) { 
	        if (type.equalsIgnoreCase("Atraccion")) {
	            return (AtraccionDAO) new AtraccionDAOImpl();
	        } else {
	            return (AtraccionDAO) new AtraccionDAOImpl();
	        }
	    }
	}
	
	public static class PromocionDAOFactory{
		public static PromocionDAO getPromocionDAO(String type) {
			if (type.equalsIgnoreCase("Promocion")) {
				return (PromocionDAO) new PromocionDAOImpl();
			} else {
				return (PromocionDAO) new PromocionDAOImpl();
			}
		}
	}
	
}
