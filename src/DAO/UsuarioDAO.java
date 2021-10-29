package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public interface UsuarioDAO {

	public ArrayList<Usuario> getAll();
}
