import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Backup extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigo;
	private JTextField textFieldQuantidade;

	/**
	 * Create the panel.
	 */
	public Backup(JFrame principal, int idConta) {
		Pessoa pessoa = new Pessoa(idConta);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOJA");
		lblNewLabel.setBounds(188, 11, 55, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ITENS");
		lblNewLabel_1.setBounds(286, 44, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1- CONSOLES");
		lblNewLabel_2.setBounds(276, 80, 94, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2- JOGOS");
		lblNewLabel_3.setBounds(276, 105, 71, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("3- HARDWARES");
		lblNewLabel_4.setBounds(276, 130, 94, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("4-MONITOR");
		lblNewLabel_5.setBounds(276, 155, 106, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("5- PERIFÉRICOS");
		lblNewLabel_6.setBounds(276, 180, 94, 14);
		add(lblNewLabel_6);
		
		//--------CODIGO-----------------------------------------------------------------------------------------------
		
		JLabel lblNewLabel_7 = new JLabel("CÓDIGO DO ITEM");
		lblNewLabel_7.setBounds(24, 44, 159, 14);
		add(lblNewLabel_7);
	
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(24, 77, 86, 20);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		
		//---------QUANTIDADE----------------------------------------------------------------------------------------------

		JLabel lblNewLabel_8 = new JLabel("QUANTIDADE");
		lblNewLabel_8.setBounds(24, 119, 74, 14);
		add(lblNewLabel_8);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(24, 152, 86, 20);
		add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		//----------------------------------------------------------------------------------------------
		JButton btnNewButton = new JButton("ENVIAR PARA O CARRINHO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificação 
				principal.getContentPane().removeAll(); 
                Carrinho carrinho = new Carrinho(principal, idConta); 
                principal.getContentPane().add(carrinho, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
			}
		});
		btnNewButton.setBounds(24, 232, 219, 23);
		add(btnNewButton);
		//--------TITULO-----------------------------------------------------------------------------------------------
		JLabel lblNewLabel_9 = new JLabel("ADICIONE UM ITEM POR VEZ");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setBounds(24, 167, 219, 40);
		add(lblNewLabel_9);
		//--------ID------------------------------------------------------------------------------------------
		JLabel lblNewLabel_10 = new JLabel("SEU ID: " + idConta);
		lblNewLabel_10.setBounds(10, 0, 100, 14);
		add(lblNewLabel_10);
		
		JButton solicitarButton = new JButton("VERIFICAR NO ESTOQUE");
		solicitarButton.setBounds(24, 199, 219, 22);
		add(solicitarButton);
		
		JLabel retornaEstoque = new JLabel("Produto indisponível.");
		retornaEstoque.setBounds(137, 105, 146, 20);
		add(retornaEstoque);
		//--------------------ajvnejivbsejidvibvosdbnvbsdovbsdovbsdobvsdobvobsdo
		 JLabel EstoqueConsole = new JLabel("estoqueAtual");
         EstoqueConsole.setBounds(368, 80, 46, 14);
         add(EstoqueConsole);
		
		// Lógica do botão
        solicitarButton.addActionListener(e -> {
            try {
                int produtoId = Integer.parseInt(textFieldCodigo.getText());
                int quantidadeSolicitada = Integer.parseInt(textFieldQuantidade.getText());

                boolean estoqueSuficiente = verificarEstoque(produtoId, quantidadeSolicitada);
                retornaEstoque.setText(estoqueSuficiente ? "Estoque disponível!" : "Produto indisponível.");
            } catch (NumberFormatException ex) {
                retornaEstoque.setText("Entrada inválida.");
                
               
            }
        });
    }

    // Função para verificar o estoque no banco de dados
    private boolean verificarEstoque(int produtoId, int quantidadeSolicitada) {
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        return estoqueAtual >= quantidadeSolicitada;  // Retorna true se houver estoque suficiente
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;  // Retorna false se não houver estoque suficiente ou se ocorrer um erro
    }
    //-------------------------------------------------------
    
	}

    
	