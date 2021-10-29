package DAO;

public class DAOFactory {
	
	
	public class UsuarioDAOFactory {
	    public static  UsuarioDAO getUsuarioDAO(String type) { 
	        if (type.equalsIgnoreCase("Usuario")) {
	            return (UsuarioDAO) new UsuarioDAOImpl();
	        } else {
	            return (UsuarioDAO) new UsuarioDAOImpl();
	        }
	    }
	}
	
	
	public class AtraccionDAOFactory {
	    public static AtraccionDAO getAtraccionDAO(String type) { 
	        if (type.equalsIgnoreCase("Atraccion")) {
	            return (AtraccionDAO) new AtraccionDAOImpl();
	        } else {
	            return (AtraccionDAO) new AtraccionDAOImpl();
	        }
	    }
	}
}
