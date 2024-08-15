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

public class Compra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigo;
	private JTextField textFieldQuantidade;

	/**
	 * Create the panel.
	 */
	public Compra(JFrame principal, int idConta) {
		Pessoa pessoa = new Pessoa(idConta);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOJA");
		lblNewLabel.setBounds(188, 11, 55, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ITENS");
		lblNewLabel_1.setBounds(263, 44, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1- CONSOLES");
		lblNewLabel_2.setBounds(253, 80, 94, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2- JOGOS");
		lblNewLabel_3.setBounds(253, 105, 71, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("3- HARDWARES");
		lblNewLabel_4.setBounds(253, 130, 94, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("4-MONITOR");
		lblNewLabel_5.setBounds(253, 155, 106, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("5- PERIFÉRICOS");
		lblNewLabel_6.setBounds(253, 180, 94, 14);
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
		btnNewButton.setBounds(24, 218, 219, 23);
		add(btnNewButton);
		//--------TITULO-----------------------------------------------------------------------------------------------
		JLabel lblNewLabel_9 = new JLabel("ADICIONE UM ITEM POR VEZ");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setBounds(24, 181, 219, 40);
		add(lblNewLabel_9);
		//--------ID------------------------------------------------------------------------------------------
		JLabel lblNewLabel_10 = new JLabel("SEU ID: " + idConta);
		lblNewLabel_10.setBounds(10, 0, 100, 14);
		add(lblNewLabel_10);
		//--------------------ajvnejivbsejidvibvosdbnvbsdovbsdovbsdobvsdobvobsdo
		JLabel estoqueConsole = new JLabel("");
        estoqueConsole.setBounds(357, 74, 65, 20);
        add(estoqueConsole);
        
        JLabel lblNewLabel_11 = new JLabel("QUANTIDADE");
        lblNewLabel_11.setBounds(334, 44, 106, 14);
        add(lblNewLabel_11);
        
        JLabel estoqueJogos = new JLabel("");
        estoqueJogos.setBounds(357, 105, 83, 14);
        add(estoqueJogos);
        
        JLabel estoqueHardwaves = new JLabel("");
        estoqueHardwaves.setBounds(357, 130, 46, 14);
        add(estoqueHardwaves);
        
        JLabel estoqueMonitor = new JLabel("");
        estoqueMonitor.setBounds(357, 155, 46, 14);
        add(estoqueMonitor);
        
        JLabel estoquePerifericos = new JLabel("");
        estoquePerifericos.setBounds(357, 180, 46, 14);
        add(estoquePerifericos);
        
        verificarEstoque(estoqueConsole); 
        verificarEstoque2(estoqueJogos);
        verificarEstoque3(estoqueHardwaves);
        verificarEstoque4(estoqueMonitor);
        verificarEstoque5(estoquePerifericos);
    }

    // estoque console-----------------------------------------------------------------------------------
    private void verificarEstoque(JLabel estoqueConsole) {
        int produtoId = 1;  
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        estoqueConsole.setText("" + estoqueAtual);  
                    } else {
                        estoqueConsole.setText("Produto não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
            estoqueConsole.setText("Erro ao acessar o banco de dados.");
            ex.printStackTrace();  // Detalhes do erro para diagnóstico
        }
    }
    // estoque jogos-----------------------------------------------------------------------------------
    private void verificarEstoque2(JLabel estoqueJogos) {
        int produtoId = 2;  
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        estoqueJogos.setText("" + estoqueAtual);  // Exibir a quantidade de estoque
                    } else {
                    	estoqueJogos.setText("Produto não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
        	estoqueJogos.setText("Erro ao acessar o banco de dados.");
            ex.printStackTrace();  // Detalhes do erro para diagnóstico
        }
    }
    // estoque hardwaves-----------------------------------------------------------------------------------
    private void verificarEstoque3(JLabel estoqueHardwaves) {
        int produtoId = 3; 
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        estoqueHardwaves.setText("" + estoqueAtual);  // Exibir a quantidade de estoque
                    } else {
                    	estoqueHardwaves.setText("Produto não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
        	estoqueHardwaves.setText("Erro ao acessar o banco de dados.");
            ex.printStackTrace();  // Detalhes do erro para diagnóstico
        }
    }
    //estoque monitor-----------------------------------------------------------------------------------
    private void verificarEstoque4(JLabel estoqueMonitor) {
        int produtoId = 4;  
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        estoqueMonitor.setText("" + estoqueAtual);  // Exibir a quantidade de estoque
                    } else {
                    	estoqueMonitor.setText("Produto não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
        	estoqueMonitor.setText("Erro ao acessar o banco de dados.");
            ex.printStackTrace();  // Detalhes do erro para diagnóstico
        }
    }
    //estoque perifericos-----------------------------------------------------------------------------------
    private void verificarEstoque5(JLabel estoquePerifericos) {
        int produtoId = 5;  
        String query = "SELECT estoque FROM produtos WHERE idProdutos = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "")) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, produtoId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int estoqueAtual = rs.getInt("estoque");
                        estoquePerifericos.setText("" + estoqueAtual);  // Exibir a quantidade de estoque
                    } else {
                    	estoquePerifericos.setText("Produto não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
        	estoquePerifericos.setText("Erro ao acessar o banco de dados.");
            ex.printStackTrace();  // Detalhes do erro para diagnóstico
        }
    }
}  



