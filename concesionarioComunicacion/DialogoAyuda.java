package concesionarioComunicacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAyuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAyuda dialog = new DialogoAyuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAyuda() {
		setTitle("Ayuda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnArchivoPermiteCrear = new JTextPane();
		txtpnArchivoPermiteCrear.setBackground(UIManager.getColor("Button.background"));
		txtpnArchivoPermiteCrear.setText("ARCHIVO\r\nPermite crear un nuevo concesionario, abrir un concesionario ya existente y guardar el concesionario sobre el que se est\u00E1 trabajando actualmente.\r\n\r\nCOCHES\r\nPermite dar de alta/baja coches en el concesionario, asi como buscar un coche por su matr\u00EDcula, ver los coches de un color y ver todos los coches.\r\n\r\nAYUDA\r\nAporta informaci\u00F3n sobre c\u00F3mo usar el programa y datos sobre su creaci\u00F3n.");
		txtpnArchivoPermiteCrear.setEditable(false);
		txtpnArchivoPermiteCrear.setBounds(28, 11, 389, 218);
		
		contentPanel.add(txtpnArchivoPermiteCrear);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton atrasButton = new JButton("Atras");
				atrasButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						
					}
				});
				atrasButton.setActionCommand("Cancel");
				buttonPane.add(atrasButton);
			}
		}
	}
}
