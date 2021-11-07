package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Atraccion;

public abstract class AtraccionDAO implements GenericDAO{
	
	public abstract ArrayList<Atraccion> getAll();
	
	public abstract void persistirAtraccion(ArrayList<Atraccion> atracciones);
}