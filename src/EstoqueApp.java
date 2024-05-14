import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;

public class EstoqueApp extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigo;
    private JTextField textFieldQuantidade;
    private JLabel retornaEstoque;

    public EstoqueApp(JFrame principal) {
        setLayout(null);  // Uso de layout absoluto

        //--------CODIGO-----------------------------------------------------------------------------------------------
        
        JLabel produtoIdLabel = new JLabel("ID do Produto:");
        produtoIdLabel.setBounds(10, 93, 100, 20);
        add(produtoIdLabel);  // Adicionando ao próprio JPanel

        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(120, 93, 150, 20);
        add(textFieldCodigo);  // Adicionando ao próprio JPanel
        //---------QUANTIDADE----------------------------------------------------------------------------------------------
        JLabel estoqueLabel = new JLabel("Estoque:");
        estoqueLabel.setBounds(10, 123, 100, 20);
        add(estoqueLabel);  // Adicionando ao próprio JPanel

        textFieldQuantidade = new JTextField();
        textFieldQuantidade.setBounds(120, 123, 150, 20);
        add(textFieldQuantidade);  // Adicionando ao próprio JPanel

        JButton solicitarButton = new JButton("Solicitar");
        solicitarButton.setBounds(10, 176, 100, 30);
        add(solicitarButton);  // Adicionando ao próprio JPanel

        retornaEstoque = new JLabel("");
        retornaEstoque.setBounds(10, 217, 250, 20);
        add(retornaEstoque);  // Adicionando ao próprio JPanel
        
        JLabel lblNewLabel = new JLabel("VERIFICAÇÃO DO ESTOQUE");
        lblNewLabel.setBounds(144, 22, 176, 14);
        add(lblNewLabel);
        
        JButton btnNewButton = new JButton("VOLTAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		principal.getContentPane().removeAll(); 
				Login login = new Login(principal); 
                principal.getContentPane().add(login, BorderLayout.CENTER); 
                principal.getContentPane().revalidate(); 
                principal.getContentPane().repaint(); 
        	}
        });
        btnNewButton.setBounds(10, 248, 100, 30);
        add(btnNewButton);
        //-------------------------------------------------------------------------------------------------
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
}
