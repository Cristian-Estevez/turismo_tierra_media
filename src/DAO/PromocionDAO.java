package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;

public abstract class PromocionDAO implements GenericDAO {

		public abstract ArrayList<Promocion> getAll(ArrayList<Atraccion> atracciones);
}

