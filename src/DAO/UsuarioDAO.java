package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;
import turismoenlatierramedia.Usuario;

public abstract class UsuarioDAO implements GenericDAO {

	public abstract ArrayList<Usuario> getAll();
	
	public abstract void persistirUsuario(ArrayList<Usuario> usuarios);
	
	public abstract void cargarItinerarios(ArrayList<Usuario> usuarios, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones);

}
