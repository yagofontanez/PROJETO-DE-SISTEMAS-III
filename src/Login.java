import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmail; 
    private JPasswordField passwordField; 
    
    public Login(JFrame principal) {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setBounds(196, 11, 244, 14);
        add(lblNewLabel);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 88, 80, 14);
        add(lblEmail);

        textFieldEmail = new JTextField(20); 
        textFieldEmail.setBounds(70, 85, 150, 20);
        add(textFieldEmail);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(10, 124, 80, 14);
        add(lblSenha);

        passwordField = new JPasswordField(20); 
        passwordField.setBounds(70, 121, 150, 20);
        add(passwordField);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(70, 163, 89, 23);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean loginBemSucedido = verificarLogin(); 
                int idConta = getIDConta();

                if (loginBemSucedido) { 
                    principal.getContentPane().removeAll(); 
                    Compra compra = new Compra(principal, idConta); 
                    principal.getContentPane().add(compra, BorderLayout.CENTER); 
                    principal.getContentPane().revalidate(); 
                    principal.getContentPane().repaint(); 
                } else {
                    
                    JOptionPane.showMessageDialog(Login.this, "Email ou senha incorretos. Por favor, tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnEnviar);

        JButton btnCadastro = new JButton("Faça seu cadastro");
        btnCadastro.setBounds(70, 201, 150, 23);
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.getContentPane().removeAll(); 
                Cadastro cadastro = new Cadastro(principal); 
                principal.getContentPane().add(cadastro, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
            }
        });
        add(btnCadastro);
        
        JButton btnNewButton_1 = new JButton(".");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		principal.getContentPane().removeAll(); 
                EstoqueApp estoqueapp = new EstoqueApp(principal); 
                principal.getContentPane().add(estoqueapp, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
        	}
        });
        btnNewButton_1.setBounds(-19, 290, 89, 23);
        add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton(".");
        btnNewButton_2.setBounds(48, 290, 89, 23);
        add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton(".");
        btnNewButton_3.setBounds(124, 290, 89, 23);
        add(btnNewButton_3);
        
        JButton btnNewButton = new JButton(".");
        btnNewButton.setBounds(196, 290, 89, 23);
        add(btnNewButton);
        
        JButton btnNewButton_4 = new JButton(".");
        btnNewButton_4.setBounds(276, 290, 89, 23);
        add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton(".");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		principal.getContentPane().removeAll(); 
                InserirProduto inserirProduto = new InserirProduto(principal); 
                principal.getContentPane().add(inserirProduto, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
        		
        	}
        });
        btnNewButton_5.setBounds(361, 290, 89, 23);
        add(btnNewButton_5);
    }

    private boolean verificarLogin() {
        try {
            String email = textFieldEmail.getText(); 
            String senha = new String(passwordField.getPassword()); 
            
            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(Login.this, "Por favor, preencha todos os campos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", ""); // Conexão com o banco de dados
            String sql = "SELECT * FROM pessoa WHERE email = ? AND senha = ?"; 
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, email); 
            ps.setString(2, senha); 

            ResultSet rs = ps.executeQuery(); 

            boolean loginBemSucedido = rs.next(); 

            rs.close(); 
            ps.close(); 
            connection.close(); 

            return loginBemSucedido; 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Login.this, "Erro" );
            return false; 
        }
    }

    
    private int getIDConta() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", ""); // Conexão com o banco de dados
            String email = textFieldEmail.getText(); 
            String senha = new String(passwordField.getPassword()); 
            String sql = "SELECT * FROM pessoa WHERE email = ? AND senha = ?"; 
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, email); 
            ps.setString(2, senha); 

            ResultSet rs = ps.executeQuery(); 

			rs.next();

			int id = Integer.parseInt(rs.getString("id"));
			
            rs.close(); 
            ps.close(); 
            connection.close(); 

            return id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Login.this, "Erro");
            return 0; 
        }
    }
    
}
