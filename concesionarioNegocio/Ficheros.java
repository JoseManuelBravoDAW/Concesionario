package concesionarioNegocio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ficheros {

	public static void escribir(Concesionario concesionario, String nombre) throws FileNotFoundException, IOException {
		
		String nombreFichero = nombre + ".obj";
		
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero))) ){
			out.writeObject(concesionario);

		}
	}
	
	public static Concesionario leer(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//String nombreFichero = nombre + ".obj";
		
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombre)))){
			
			return (Concesionario) in.readObject();
		}
	}
}
