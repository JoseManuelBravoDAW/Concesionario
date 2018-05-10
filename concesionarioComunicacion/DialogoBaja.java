package concesionarioComunicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exceptions.CocheNoExisteException;
import exceptions.MatriculaNoValidaException;

public class DialogoBaja extends DialogoAlta {

	public DialogoBaja() {
		super();
		setTitle("Eliminar coche");
		rdbtnRojo.setEnabled(false);
		rdbtnAzul.setEnabled(false);
		rdbtnPlateado.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		okButton.setText("Eliminar");
		
		
		
//		okButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//					
//				}
//			});
		}
	
	@Override
	protected void accionBotonIzquierda() throws CocheNoExisteException, MatriculaNoValidaException {
		
		ConcesionarioGUI.concesionario.eliminarCoche(txtMatricula.getText());
		JOptionPane.showMessageDialog(contentPanel, "Coche eliminado con éxito.", "Baja",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
