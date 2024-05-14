import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JTextField textFieldCpf;

	/**
	 * Create the panel.
	 */
	public Cadastro(JFrame principal) {
		setLayout(null);
		
		//label ------------------------------------------------------
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setBounds(196, 11, 430, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 58, 80, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(10, 94, 80, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(10, 137, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(10, 187, 46, 14);
		add(lblNewLabel_3);
		
		// insert text --------------------------------------------------
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(74, 55, 156, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(74, 91, 156, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(74, 134, 156, 20);
		add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(74, 184, 156, 20);
		add(textFieldCpf);
		textFieldCpf.setColumns(10);
		

		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa= new Pessoa();
				pessoa.setNome(textFieldNome.getText());
				pessoa.setEmail(textFieldEmail.getText());				
				pessoa.setSenha(textFieldSenha.getText());
				pessoa.setCpf(textFieldCpf.getText());
				pessoa.Salvar();
				principal.getContentPane().removeAll();
				JPanel panel = new JPanel();
				principal.getContentPane().add(panel, BorderLayout.CENTER);
				principal.getContentPane().revalidate();
				JOptionPane.showMessageDialog(principal, "Pessoa adicionada com sucesso","mensagem",
						JOptionPane.PLAIN_MESSAGE);
				
				
		                principal.getContentPane().removeAll(); 
		                Login login = new Login(principal); 
		                principal.getContentPane().add(login, BorderLayout.CENTER); 
		                principal.getContentPane().revalidate(); 
		                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(173, 234, 89, 23);
		add(btnNewButton);
		
		
	}

}
