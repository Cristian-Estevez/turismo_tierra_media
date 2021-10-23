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
	
		
	
	Atraccion moria = new Atraccion("Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(moria);
	Atraccion minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(minasDeTirith);
	Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
	atraccionesCreadasEnJava.add(laComarca);
	Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(mordor);
	Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(abismoDeHelm);
	Atraccion lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
	atraccionesCreadasEnJava.add(lothlorien);
	Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
	atraccionesCreadasEnJava.add(erebor);
	Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(bosqueNegro);
	Atraccion marDelPlata = new Atraccion("Mar del Plata", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(marDelPlata);
	Atraccion chascomus = new Atraccion("Chascomus", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(chascomus);
	Atraccion bolivia = new Atraccion("Bolivia", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(bolivia);
	Atraccion chile = new Atraccion("Chile", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	atraccionesCreadasEnJava.add(chile);
	}
	
	
	@Test
	public void arrayCreadoDesdeBBDDEsIgualAlCreadoManualmente() {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		atraccionesCreadasEnDDBB = atraccionDAO.getAll();
		assertEquals(atraccionesCreadasEnJava, atraccionesCreadasEnDDBB);
	}
}
