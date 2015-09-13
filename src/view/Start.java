package view;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Start {

	private JFrame frame;
	private JButton btnOk;
	private JPasswordField txtPW;
	private JLabel lblPWInfo;

	public Start() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 263, 185);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));

		lblPWInfo = new JLabel("Bitte Password eingeben.");
		frame.getContentPane().add(lblPWInfo, "cell 0 0,alignx center");

		txtPW = new JPasswordField();
		frame.getContentPane().add(txtPW, "cell 0 1,alignx center");
		txtPW.setColumns(10);

		btnOk = new JButton("OK");
		frame.getContentPane().add(btnOk, "flowx,cell 0 2,alignx center");

		frame.setVisible(true);
	}

	public String getPW() {
		String pw = new String(txtPW.getPassword());
		return pw;
	}

	public void setOkListener(ActionListener l) {
		this.btnOk.addActionListener(l);
	}
	
	public void setPWInfo(String t) {
		this.lblPWInfo.setText(t);
	}
	
	public void hide() {
		frame.setVisible(false);
	}
}
