import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Remover extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Remover(JFrame principal, int id) {
		Produto produto = new Produto(id);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deseja remover essa produto?");
		lblNewLabel.setBounds(10, 11, 430, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(37, 45, 72, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(37, 70, 72, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Estoque:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(37, 95, 72, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabelID = new JLabel(Integer.toString(produto.getId()));
		lblNewLabelID.setBounds(119, 45, 304, 14);
		add(lblNewLabelID);
		
		JLabel lblNewLabelNome = new JLabel(produto.getItens());
		lblNewLabelNome.setBounds(119, 70, 304, 14);
		add(lblNewLabelNome);
		
		JLabel lblNewLabelEmail = new JLabel(produto.getEstoque());
		lblNewLabelEmail.setBounds(119, 95, 304, 14);
		add(lblNewLabelEmail);
		
		JButton btnNewButton = new JButton("Sim");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll();
				produto.remover();
				JOptionPane.showMessageDialog(principal,
						"Produto removida com sucesso",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				Estoque estoque = new Estoque(principal); 
                principal.getContentPane().add(estoque, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(119, 173, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Não");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll();
				JOptionPane.showMessageDialog(principal,
					"Não remove entao ue oxi vsf",
			"Mensagem", JOptionPane.PLAIN_MESSAGE);
				Estoque estoque = new Estoque(principal); 
                principal.getContentPane().add(estoque, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton_1.setBounds(222, 173, 89, 23);
		add(btnNewButton_1);

	}
}
