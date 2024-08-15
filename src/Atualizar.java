import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Atualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldItens;
	private JTextField textFieldEstoque;

	/**
	 * Create the panel.
	 */
	public Atualizar(JFrame principal, int id) {
		Produto produto = new Produto(id);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("ATUALIZAR / ID " + produto.getId());
		lblNewLabel.setBounds(10, 11, 430, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ITENS");
		lblNewLabel_1.setBounds(10, 58, 80, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ESTOQUE");
		lblNewLabel_1_1.setBounds(10, 94, 80, 14);
		add(lblNewLabel_1_1);
		
		textFieldItens = new JTextField(produto.getItens());
		textFieldItens.setBounds(100, 55, 86, 20);
		add(textFieldItens);
		textFieldItens.setColumns(10);

		textFieldEstoque = new JTextField(produto.getEstoque());
		textFieldEstoque.setColumns(10);
		textFieldEstoque.setBounds(100, 91, 86, 20);
		add(textFieldEstoque);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto(id);
				produto.setItens(textFieldItens.getText());
				produto.setEstoque(textFieldEstoque.getText());
				produto.Salvar();
				principal.getContentPane().removeAll();
				JOptionPane.showMessageDialog(principal, "Produto atualizado com sucesso", "mensagem",
						JOptionPane.PLAIN_MESSAGE);
				Estoque estoque = new Estoque(principal); 
                principal.getContentPane().add(estoque, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(182, 161, 89, 23);
		add(btnNewButton);
	}
}
    