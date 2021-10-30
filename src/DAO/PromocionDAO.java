package DAO;

import java.util.ArrayList;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;

public interface PromocionDAO {

		public ArrayList<Promocion> getAll(ArrayList<Atraccion> atracciones);
}

