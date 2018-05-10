package concesionarioNegocio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Modificacion {

	private static boolean modificado;
	private static String nombreFichero = "Sin título";
	private static String ubicacionFichero;
	private static Concesionario concesionario;
	
	private static void setConcesionario(Concesionario c) {
		concesionario = c;
	}
	
	@SuppressWarnings("unused")
	private static Concesionario getConcesionario() {
		return concesionario;
	}
	
	public static void setNombreFichero(String nombre) {
		nombreFichero = nombre;
	}
	
	public static String getNombreFichero() {
		return nombreFichero;
	}
	
	public static void setUbicacionFichero(String ubicacion) {
		ubicacionFichero = ubicacion;
	}
	
	public static String getUbicacionFichero() {
		return ubicacionFichero;
	}
	
	public static void setModificado(boolean b) {
		
		modificado = b;
	}
	
	public static void resetear() {
		setModificado(false);
		setNombreFichero("Sin título");
		setConcesionario(null);
	}
	
	public static boolean isModificado() {
		return modificado;
	}

	public static void escribir(Concesionario concesionario, String nombre, String ubicacion) throws FileNotFoundException, IOException {
		
		Ficheros.escribir(concesionario, ubicacion);
		setConcesionario(concesionario);
		setModificado(false);
		setNombreFichero(nombre);
		setUbicacionFichero(ubicacion);
		
	}
	
	public static Concesionario leer(String nombre, String ubicacion) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Concesionario c = Ficheros.leer(ubicacion);
		setConcesionario(c);
		setNombreFichero(nombre);
		setUbicacionFichero(ubicacion);
		return c;
	
	}
}
