import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmail;
	private JTextField textFieldNome;

	/**
	 * Create the panel.
	 */
	public Consulta(JFrame Principal) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 11, 430, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(10, 58, 80, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(10, 94, 80, 14);
		add(lblNewLabel_1_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(100, 55, 86, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(100, 91, 86, 20);
		add(textFieldNome);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(10, 25, 70, 14);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão clicado");
			}
		});
		btnNewButton.setBounds(182, 161, 89, 23);
		add(btnNewButton);

	}
}
  



