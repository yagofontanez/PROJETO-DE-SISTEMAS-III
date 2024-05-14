import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistema {

	private JFrame frmSistema;
	private JTextField textField_Usuario;
	private JTextField textField_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema window = new Sistema();
					window.frmSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistema = new JFrame();
		frmSistema.setTitle("Login");
		frmSistema.setBounds(100, 100, 450, 300);
		frmSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistema.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_Usuario = new JLabel("Usuário");
		frmSistema.getContentPane().add(lblNewLabel_Usuario);
		
		textField_Usuario = new JTextField();
		frmSistema.getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		JLabel lblNewLabel_Senha = new JLabel("Senha");
		frmSistema.getContentPane().add(lblNewLabel_Senha);
		
		textField_Senha = new JTextField();
		frmSistema.getContentPane().add(textField_Senha);
		textField_Senha.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton btnNewButton = new JButton("ACESSE NOSSA LOJA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmSistema.getContentPane().removeAll();
				System.out.println("Botão clicado");
				Login login = new Login(frmSistema);
				frmSistema.getContentPane().add(login, BorderLayout.CENTER);
				frmSistema.getContentPane().revalidate();
			}
		});
		frmSistema.getContentPane().add(btnNewButton);
		
	}
}
