import java.sql.*;
import java.util.List;

public class ClientBanco {
    private Connection conexao;

    public ClientBanco() throws SQLException {
        this.conexao = new ConexaoBanco().obterConexao();
    }

    public Curso getCurso(Curso curso) throws SQLException {
        String sql = "SELECT * FROM curso WHERE iden = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, curso.getIden());

            ResultSet rs = ps.executeQuery();
            Curso c = null;
            if (rs.next()) {
                c = new Curso(rs.getInt(1), rs.getInt(2),rs.getString(3));
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void PostCursosDisciplinas(List<CursoDisciplina> cur){
        try {
            Curso singleCurso;
            Disciplina singleDisciplina;

            for(CursoDisciplina c : cur){
                // divide para salvar

                singleCurso = new Curso(c.getIden(),c.getAno(),c.getNomeCurso());
                singleDisciplina = new Disciplina(c.getNomeDisciplina(), c.getCh(), c.getIden());

                PostCurso(singleCurso);
                PostDisciplina(singleDisciplina);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void PostCurso(Curso cur) throws SQLException {
        if(true) {
            String sql = "INSERT INTO curso VALUES(?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, cur.getIden());
                ps.setInt(2, cur.getAno());
                ps.setString(3, cur.getNome());

                ps.execute();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  void PostDisciplina(Disciplina dis){

        String sql = "INSERT INTO disciplina VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dis.getNome());
            ps.setInt(2, dis.getCh());
            ps.setInt(3, dis.getCodCurso());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
