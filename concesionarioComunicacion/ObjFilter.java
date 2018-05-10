package concesionarioComunicacion;

import java.io.File;

public class ObjFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		return file.isDirectory() || file.getAbsolutePath().endsWith(".obj");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Objetos (*.obj)";
	}

}
