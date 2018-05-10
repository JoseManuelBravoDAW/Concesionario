package concesionarioComunicacion;

import concesionarioNegocio.Coche;
import exceptions.CocheNoExisteException;
import exceptions.MatriculaNoValidaException;

public class DialogoVer extends DialogoAlta {
	
	

	public DialogoVer() {
		super();
		setTitle("Ver");
		rdbtnRojo.setEnabled(false);
		rdbtnAzul.setEnabled(false);
		rdbtnPlateado.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		okButton.setText("Ver");
		
		if(ConcesionarioGUI.concesionario.contar() == 0) {
			txtMatricula.setText("No hay coches");
			txtMatricula.setEditable(false);
			okButton.setEnabled(false);
		}
			
		
	}
	
	@Override
	protected void accionBotonIzquierda() throws CocheNoExisteException, MatriculaNoValidaException {
		Coche c = ConcesionarioGUI.concesionario.getCoche(txtMatricula.getText());
		
		switch(c.getColor()) {
		
		case ROJO:
			rdbtnRojo.setSelected(true);
			break;
		case AZUL:
			rdbtnAzul.setSelected(true);
			break;
		case PLATA:
			rdbtnPlateado.setSelected(true);
			break;
		}
		
		comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
		comboBoxModelo.setSelectedItem(c.getModelo());
	}
}
