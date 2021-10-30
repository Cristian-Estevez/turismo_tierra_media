package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Atraccion;

public interface AtraccionDAO {
	
	public ArrayList<Atraccion> getAll();
	
	public void persistirAtraccion(ArrayList<Atraccion> atracciones);
}