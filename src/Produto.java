import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {
	
	private int id;
	private String Itens;
	private String Estoque;
	
	//constructor 
	
	public Produto() {
		setId(id);
		setItens("");
		setEstoque("");
	}
	
	// consult
	
	public Produto(int id) {
		setId(id);
		setItens("");
		setEstoque("");
		
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM produtos WHERE idProdutos = " + getId() + ";");
		try {
			rs.next();
			setItens(rs.getString("itens"));
			setEstoque(rs.getString("estoque"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// get and set 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItens() {
		return Itens;
	}

	public void setItens(String itens) {
		Itens = itens;
	}

	public String getEstoque() {
		return Estoque;
	}

	public void setEstoque(String estoque) {
		Estoque = estoque;
	}
	
	//save
	
	public void Salvar() {
		Banco banco = new Banco();
		if (getId() > 0) {
			banco.sqlAtualizacao("UPDATE produtos SET itens = '" + this.getItens() + "', estoque = '" + this.getEstoque() + "' WHERE idProdutos = " + this.getId() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO produtos (itens, estoque) VALUES ('" + this.getItens() + "', '" + this.getEstoque() + "');");
		}
	}
	
	//consult
	
	public Produto[] consultar() {
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
		Produto[] p = new Produto[x];
		rs = b.sqlConsulta("select * from produtos");

		try {
			int count = 0;
			while (rs.next()) {
				Produto temp = new Produto();
				temp.setId(Integer.parseInt(rs.getString("idProdutos")));
				temp.setItens(rs.getString("itens"));
				temp.setEstoque(rs.getString("estoque"));
				
				p[count] = temp;
				count++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;

	}
	
	//remove ------------------------------------------------------
	
		public void remover() {
			Banco b = new Banco();
			if (getId() > 0) {
			b.sqlAtualizacao("DELETE FROM produtos WHERE idProdutos = " + getId() + ";");
				}
			}
		
		public void Compra() {
			Banco banco = new Banco();
			if (getId() > 0) {
				banco.sqlAtualizacao("UPDATE produtos SET itens = '" + this.getItens() + "', estoque = '" + this.getEstoque() + "' WHERE idProdutos = " + this.getId() + ";");
			} else {
				banco.sqlAtualizacao("INSERT INTO produtos (itens, estoque) VALUES ('" + this.getItens() + "', '" + this.getEstoque() + "');");
			}
		}
			
}
	



