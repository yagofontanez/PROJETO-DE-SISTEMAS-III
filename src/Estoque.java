import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Estoque extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Estoque(JFrame principal) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("ESTOQUE");
		lblNewLabel.setBounds(196, 11, 101, 14);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 391, 128);
		add(scrollPane);

		String colunas[] = { "ID", "Itens", "Quantidade" };
		DefaultTableModel dtm = new DefaultTableModel(colunas, 0);
		Produto p = new Produto();
		Produto[] produtos = p.consultar();

		if (produtos != null) {
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null) {
					dtm.addRow(new Object[] {
							produtos[i].getId(),
							produtos[i].getItens(),
							produtos[i].getEstoque()

					});
				}
			}
		}
		table = new JTable(dtm);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("INSERIR PRODUTOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll();
				InserirProduto inserirProduto = new InserirProduto(principal);
				principal.getContentPane().add(inserirProduto, BorderLayout.CENTER);
				principal.getContentPane().revalidate();
				principal.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(20, 210, 175, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("VOLTAR PARA LOJA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.getContentPane().removeAll();
				Login login = new Login(principal);
				principal.getContentPane().add(login, BorderLayout.CENTER);
				principal.getContentPane().revalidate();
				principal.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(20, 244, 175, 23);
		add(btnNewButton_1);

		JButton btnAtualizar = new JButton("ATUALIAZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					principal.getContentPane().removeAll();
					Atualizar atualizar = new Atualizar(principal, (int) table.getValueAt(table.getSelectedRow(), 0));
					;
					principal.getContentPane().add(atualizar, BorderLayout.CENTER);
					principal.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(principal,
							"Selecione um produto!",
							"Mensagem", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnAtualizar.setBounds(229, 210, 130, 23);
		add(btnAtualizar);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					principal.getContentPane().removeAll();
					Remover remover = new Remover(principal, (int) table.getValueAt(table.getSelectedRow(), 0));
					;
					principal.getContentPane().add(remover, BorderLayout.CENTER);
					principal.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(principal,
							"Selecione um produto!",
							"Mensagem", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		btnRemover.setBounds(229, 244, 130, 23);
		add(btnRemover);

	}
}
