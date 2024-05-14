import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;	

public class Banco {
private final String url = "jdbc:mysql://localhost/projeto";
private final String user = "root";
private final String password = "";
private Connection connection = null;
private Statement statement = null;
private ResultSet resultSet = null;
public Banco() {
}

public void sqlAtualizacao(String sql) {
try {
	connection = DriverManager.getConnection(url, user, password);
	statement = connection.createStatement();
	statement.execute(sql);
} catch(SQLException e) {
	System.out.println(e.getMessage());
} catch(Exception e) {
	System.out.println(e.getMessage());
	}
}
public ResultSet sqlConsulta(String sql) {
try {
	connection = DriverManager.getConnection(url, user, password);
	statement = connection.createStatement();
	resultSet = statement.executeQuery(sql);
} catch(SQLException e) {
	System.out.println(e.getMessage());
} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	return resultSet;
}
}
