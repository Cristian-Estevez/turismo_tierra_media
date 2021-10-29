package DAO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.DAOFactory.UsuarioDAOFactory;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Producto;
import turismoenlatierramedia.PromocionAbsoluta;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class UsuarioDAOTest {

	ArrayList<Usuario> usuariosCreadosDesdeJava;
	ArrayList<Usuario> usuariosCreadosDesdeDDBB;

	Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo;
	Atraccion mordor, abismoDeHelm, moria, bosqueNegro;

	List<Producto> productosEsperados;
	List<Atraccion> listaDeAtraccionesA;
	PromocionAbsoluta promoNueva;

	@Before
	public void setup() {
		usuariosCreadosDesdeDDBB = new ArrayList<Usuario>();
		usuariosCreadosDesdeJava = new ArrayList<Usuario>();

		Usuario eowyn = new Usuario(1, "Eowyn", 10, 8.0, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(eowyn);
		Usuario gandalf = new Usuario(2, "Gandalf", 100, 5.0, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(gandalf);
		Usuario sam = new Usuario(3, "Sam", 36, 8.0, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(sam);
		Usuario galadriel = new Usuario(4, "Galadriel", 120, 4.0, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(galadriel);
		Usuario ivan = new Usuario(5, "Ivan", 85, 7, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(ivan);
		Usuario nahuel = new Usuario(6, "Nahuel", 30, 6, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(nahuel);
		Usuario cristianJoel = new Usuario(7, "Cristian Joel", 95, 3, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(cristianJoel);
		Usuario juanjo = new Usuario(8, "Juanjo", 200, 5, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(juanjo);
		Usuario cristianRigoberto = new Usuario(9, "Cristian Rigoberto", 100, 2, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(cristianRigoberto);
		Usuario cristian = new Usuario(10, "Cristian", 62, 60, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(cristian);
		Usuario micaela = new Usuario(11, "Micaela", 98, 10, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(micaela);
		Usuario federico = new Usuario(12, "Federico", 68, 6, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(federico);
		Usuario lucas = new Usuario(13, "Lucas", 160, 9, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(lucas);
		Usuario quique = new Usuario(14, "Quique", 98, 8, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(quique);
		Usuario evita = new Usuario(15, "Evita", 46, 9, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(evita);
		Usuario frida = new Usuario(16, "Frida", 320, 9, TipoDeAtraccion.PAISAJE);
		usuariosCreadosDesdeJava.add(frida);
		Usuario silvina = new Usuario(17, "Silvina", 200, 9, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(silvina);
		Usuario chavela = new Usuario(18, "Chavela", 50, 10, TipoDeAtraccion.DEGUSTACION);
		usuariosCreadosDesdeJava.add(chavela);
		Usuario alfonsina = new Usuario(19, "Alfonsina", 93, 8, TipoDeAtraccion.AVENTURA);
		usuariosCreadosDesdeJava.add(alfonsina);

	}

	@Test
	public void arrayCreadoDesdeBBDDEsIgualAlCreadoManualmente() {
		UsuarioDAO miUserDAO = UsuarioDAOFactory.getUsuarioDAO("Usuario");
		usuariosCreadosDesdeDDBB = miUserDAO.getAll();
		assertEquals(usuariosCreadosDesdeJava, usuariosCreadosDesdeDDBB);
	}
}
