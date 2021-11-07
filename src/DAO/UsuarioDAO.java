package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Usuario;

public abstract class UsuarioDAO implements GenericDAO {

	public abstract ArrayList<Usuario> getAll();
	
	public abstract void persistirUsuario(ArrayList<Usuario> usuarios);
}
