import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private String user = "root";
    private String senha = "1234";
    private String url = "jdbc:mysql://localhost:3306/universidade";

    public Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.senha);
    }
}
