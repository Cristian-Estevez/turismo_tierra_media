package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConstructorDeUsuarioTest {

	ConstructorDeUsuario con1;
	ArrayList<Usuario> usuarios, usuariosEsperados;
	String rutaArchivo;
	Usuario eowyn, gandalf, sam, galadriel;
	
	@Before
	public void setup() {
		usuarios = new ArrayList<Usuario>();
		rutaArchivo = "archivosParaTests/usuariosParaTests.in";
		
		usuariosEsperados = new ArrayList<Usuario>();
		eowyn = new Usuario(1,"Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario(2,"Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario(3,"Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario(45,"Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		
		usuariosEsperados.add(eowyn);
		usuariosEsperados.add(gandalf);
		usuariosEsperados.add(sam);
		usuariosEsperados.add(galadriel);
	}
		
	@Test
	public void creaUsuariosDesdeArchivoCorrectamente() throws FileNotFoundException {
		con1 = new ConstructorDeUsuario();
		usuarios = con1.crearListaUsuarios(rutaArchivo);
		assertEquals(usuariosEsperados, usuarios);
	}
	
}
