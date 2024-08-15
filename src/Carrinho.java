import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Carrinho extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Carrinho(JFrame principal, int idConta) {
		Pessoa pessoa = new Pessoa(idConta);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARRINHO");
		lblNewLabel.setBounds(196, 11, 101, 14);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 391, 128);
		add(scrollPane);
		
		String colunas[]= {"ID", "Nome", "Itens", "Quantidade"};
		DefaultTableModel dtm = new DefaultTableModel(colunas, 0);
		CarrinhoConsulta CC = new CarrinhoConsulta();
		CarrinhoConsulta[] carrinhoconsulta = CC.consultarCarrinho();

					for (int i=0; i<carrinhoconsulta.length; i++) {
						if (carrinhoconsulta[i] != null) {
							dtm.addRow(new Object[] {
										carrinhoconsulta[i].getId(),
										carrinhoconsulta[i].getNome(),
										carrinhoconsulta[i].getItens(),
										carrinhoconsulta[i].getQuantidade(),
										
		}					);
	}
}
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll(); 
                Compra compra = new Compra(principal, idConta); 
                principal.getContentPane().add(compra, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(283, 211, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("SEU ID: " + idConta);
		lblNewLabel_10.setBounds(10, 0, 100, 14);
		add(lblNewLabel_10);

	}
}



 