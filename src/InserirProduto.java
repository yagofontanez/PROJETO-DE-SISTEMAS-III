import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class InserirProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFielditens;
	private JTextField textFieldEstoque;

	/**
	 * Create the panel.
	 */
	public InserirProduto(JFrame principal) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSERINDO PRODUTOS");
		lblNewLabel.setBounds(155, 11, 187, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ITEM ");
		lblNewLabel_1.setBounds(38, 76, 46, 14);
		add(lblNewLabel_1);
		
		textFielditens = new JTextField();
		textFielditens.setBounds(105, 73, 86, 20);
		add(textFielditens);
		textFielditens.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("QUANTIDADE");
		lblNewLabel_2.setBounds(22, 130, 102, 14);
		add(lblNewLabel_2);
		
		textFieldEstoque = new JTextField();
		textFieldEstoque.setBounds(105, 127, 86, 20);
		add(textFieldEstoque);
		textFieldEstoque.setColumns(10);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto= new Produto();
				produto.setItens(textFielditens.getText());
				produto.setEstoque(textFieldEstoque.getText());
				produto.Salvar();
				principal.getContentPane().removeAll(); 
				JOptionPane.showMessageDialog(principal,
						"PRODUTO ADICIONADO COM SUCESSO",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				principal.getContentPane().removeAll(); 
                InserirProduto inserirProduto = new InserirProduto(principal); 
                principal.getContentPane().add(inserirProduto, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(60, 197, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ESTOQUE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll(); 
                Estoque estoque = new Estoque(principal); 
                principal.getContentPane().add(estoque, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton_1.setBounds(179, 197, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VOLTAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll(); 
				Login login = new Login(principal); 
                principal.getContentPane().add(login, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton_2.setBounds(296, 197, 89, 23);
		add(btnNewButton_2);

	}
}
