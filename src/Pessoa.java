import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {
	
	//creation of variables-----------------------------------------------
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	
	// constructor------------------------------------------------------
	
	public Pessoa() {
		setId(0);
		setNome("");
		setEmail("");
		setSenha("");
		setCpf("");
	}
	
	//consult-----------------------------------------------------------
	
	public Pessoa(int id) {
		setId(id);
		setNome("");
		setEmail("");
		setSenha("");
		setCpf("");
		
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM pessoa WHERE id = " + getId() + ";");
		try {
			rs.next();
			setNome(rs.getString("nome"));
			setEmail(rs.getString("email"));
			setSenha(rs.getString("senha"));
			setCpf(rs.getString(cpf));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// get and set ------------------------------------------------------
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String string) {
		this.cpf = string;
	}
	
	// save --------------------------------------------------------
	
	public void Salvar() {
		Banco banco = new Banco();
		if (getId() > 0) {
			banco.sqlAtualizacao("UPDATE pessoa SET nome = '" + this.getNome() + "', email = '" + this.getEmail() + "', senha = '" + this.getSenha() + "', cpf = '" + this.getCpf() + "' WHERE id = " + this.getId() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO pessoa (nome, email, senha, cpf) VALUES ('" + this.getNome() + "', '" + this.getEmail() + "', '" + this.getSenha() + "','" + this.getCpf() + "');");
		}
	}
	
	//consult ------------------------------------------------------
	
	public Pessoa[] consultar() {
		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM pessoa;");

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
		Pessoa[] p = new Pessoa[x];
		rs = b.sqlConsulta("SELECT * FROM pessoa ORDER BY nome;");
		try {
			int count = 0;
			while (rs.next()) {
				Pessoa temp = new Pessoa();
				temp.setId(Integer.parseInt(rs.getString("id")));
				temp.setNome(rs.getString("nome"));
				temp.setEmail(rs.getString("email"));
				temp.setSenha(rs.getString("senha"));
				temp.setCpf(rs.getString("cpf"));
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
		b.sqlAtualizacao("DELETE FROM pessoa WHERE id = " + getId() + ";");
			}
		}
	
}



