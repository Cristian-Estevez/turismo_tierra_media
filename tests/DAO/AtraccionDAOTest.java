package DAO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.TipoDeAtraccion;


public class AtraccionDAOTest {
	 ArrayList<Atraccion> atraccionesCreadasEnJava;
	 ArrayList<Atraccion> atraccionesCreadasEnDDBB;


	@Before
	public void setup() {
		
	atraccionesCreadasEnJava = new ArrayList<Atraccion>();
	atraccionesCreadasEnDDBB = new ArrayList<Atraccion>();
	
		
	
	Atraccion moria = new Atraccion(1, "Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(moria);
	Atraccion minasDeTirith = new Atraccion(2, "Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(minasDeTirith);
	Atraccion laComarca = new Atraccion(3, "La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
	atraccionesCreadasEnJava.add(laComarca);
	Atraccion mordor = new Atraccion(4, "Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(mordor);
	Atraccion abismoDeHelm = new Atraccion(5, "Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(abismoDeHelm);
	Atraccion lothlorien = new Atraccion(6, "Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
	atraccionesCreadasEnJava.add(lothlorien);
	Atraccion erebor = new Atraccion(7, "Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(erebor);
	Atraccion bosqueNegro = new Atraccion(8, "Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(bosqueNegro);
	Atraccion marDelPlata = new Atraccion(9, "Mar del Plata", 4, 5, 13, TipoDeAtraccion.DEGUSTACION);
	atraccionesCreadasEnJava.add(marDelPlata);
	Atraccion chascomus = new Atraccion(10, "Chascomus", 5, 3, 65, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(chascomus);
	Atraccion bolivia = new Atraccion(11, "Bolivia", 3, 2, 60, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(bolivia);
	Atraccion chile = new Atraccion(12, "Chile", 7, 30, 7, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(chile);
	}
	
	
	@Test
	public void arrayCreadoDesdeBBDDEsIgualAlCreadoManualmente() {
		AtraccionDAO atraccionDAO = (AtraccionDAO) DAOFactory.getDAO("Atraccion");
		atraccionesCreadasEnDDBB = atraccionDAO.getAll();
		assertEquals(atraccionesCreadasEnJava, atraccionesCreadasEnDDBB);
		
	}
}