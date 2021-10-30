package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Usuario;

public interface UsuarioDAO {

	public ArrayList<Usuario> getAll();
	
	public void persistirUsuario(ArrayList<Usuario> usuarios);
}
