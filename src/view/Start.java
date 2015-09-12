package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Start {

	private JFrame frame;
	private JTextField txtPW;
	private JButton btnOk;


	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow][grow][grow]"));
		
		JLabel lblPasswort = new JLabel("Passwort = 1337");
		frame.getContentPane().add(lblPasswort, "cell 0 0");
		
		JLabel lblEsStandNirgenwo = new JLabel("Es stand nirgendwo das das Passwort benutzerdefiniert sein soll...");
		frame.getContentPane().add(lblEsStandNirgenwo, "cell 0 1");
		
		txtPW = new JTextField();
		frame.getContentPane().add(txtPW, "cell 0 2,growx,aligny top");
		txtPW.setColumns(10);
		
		btnOk = new JButton("OK");
		frame.getContentPane().add(btnOk, "cell 0 3,alignx center");
		
		frame.setVisible(true);
	}
	
	public String getPW() {
		return this.txtPW.getText();
	}
	
	public void addOkListener(ActionListener l) {
		this.btnOk.addActionListener(l);
	}
	
	public void setVS(boolean bl) {
		this.frame.setVisible(bl);
	}

}
