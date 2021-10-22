package DAO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class UsuarioDAOTest {

	ArrayList<Usuario> usuariosCreadosDesdeJava;
	ArrayList<Usuario> usuariosCreadosDesdeDDBB;

	@Before
	public void setup() {
		usuariosCreadosDesdeDDBB = new ArrayList<Usuario>();
		usuariosCreadosDesdeJava = new ArrayList<Usuario>();
		
		Usuario eowyn = new Usuario("Eowyn", 10, 8.0, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(eowyn);
		Usuario gandalf = new Usuario("Gandalf", 100, 5.0, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(gandalf);
		Usuario sam = new Usuario("Sam", 36, 8.0, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(sam);
		Usuario galadriel = new Usuario("Galadriel", 120, 4.0, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(galadriel);
		Usuario ivan = new Usuario("Ivan", 85, 7, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(ivan);
		Usuario nahuel = new Usuario("Nahuel", 30, 6, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(nahuel);
		Usuario cristianJoel = new Usuario("Cristian Joel", 95, 3, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(cristianJoel);
		Usuario juanjo = new Usuario("Juanjo", 200, 5, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(juanjo);
		Usuario cristianRigoberto = new Usuario("Cristian Rigoberto", 100, 2, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(cristianRigoberto);
		Usuario cristian = new Usuario("Cristian", 62, 60, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(cristian);
		Usuario micaela = new Usuario("Micaela", 98, 10, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(micaela);
		Usuario federico = new Usuario("Federico", 68, 6, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(federico);
		Usuario lucas = new Usuario("Lucas", 160, 9, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(lucas);
		Usuario quique = new Usuario("Quique", 98, 8, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(quique);
		Usuario evita = new Usuario("Evita", 46, 9, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(evita);
		Usuario frida = new Usuario("Frida", 320, 9, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(frida);
		Usuario silvina = new Usuario("Silvina", 200, 9, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(silvina);
		Usuario chavela = new Usuario("Chavela", 50, 10, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(chavela);
		Usuario alfonsina = new Usuario("Alfonsina", 93, 8, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(alfonsina);
				
	}
	
	@Test
	public void arrayCreadoDesdeBBDDEsIgualAlCreadoManualmente() {
		UsuarioDAO miUserDAO = new UsuarioDAO();
		usuariosCreadosDesdeDDBB = miUserDAO.getAll();
		assertEquals(usuariosCreadosDesdeJava, usuariosCreadosDesdeDDBB);
	}
}
