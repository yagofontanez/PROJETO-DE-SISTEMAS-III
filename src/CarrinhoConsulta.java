import java.sql.ResultSet;
import java.sql.SQLException;

public class CarrinhoConsulta {

	private int id;
	private int Quantidade;
	private String itens;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	
	public CarrinhoConsulta() {
		setId(id);
		setQuantidade(Quantidade);
		setItens(itens);
		setNome(nome);
	}
	
	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CarrinhoConsulta[] consultarCarrinho() {
		
		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM produtos;");

		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (x == 0)
			return null;
		CarrinhoConsulta[] CC = new CarrinhoConsulta[x];
		
		rs = b.sqlConsulta("select p.id, p.nome, prod.itens, c.quantidade from carrinho c inner join pessoa p on c.id = p.id inner join produtos prod on prod.idProdutos = c.idProduto");
		try {
			int count = 0;
			while (rs.next()) {
				CarrinhoConsulta temp = new CarrinhoConsulta();
				temp.setId(Integer.parseInt(rs.getString("id")));
				temp.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
				temp.setItens(rs.getString("itens"));
				temp.setNome(rs.getString("nome"));
				CC[count] = temp;
				count++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return CC;
		
	}
	
}
 


