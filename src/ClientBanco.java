import java.sql.*;
import java.util.ArrayList;

public class ClientBanco {
    private Connection conexao;

    public ClientBanco() throws SQLException {
        this.conexao = ConexaoBanco.obterConexao();
    }

    public void PostCursosDisciplinas(ArrayList<CursoDisciplina> cur){
        try {
            CursoDisciplina singleCursoDisciplina = null;
            Curso singleCurso = null;
            Disciplina singleDisciplina = null;

            for(int i = 0; i < cur.size(); i++){
                // divide para salvar
                singleCursoDisciplina = cur.get(i);

                singleCurso.setIden(singleCursoDisciplina.getIden());
                singleCurso.setAno(singleCursoDisciplina.getAno());
                singleCurso.setNome(singleCursoDisciplina.getNomeCurso());

                singleDisciplina.setNome(singleCursoDisciplina.getNomeDisciplina());
                singleDisciplina.setCh(singleCursoDisciplina.getCh());
                singleDisciplina.setCodCurso(singleCursoDisciplina.getIden());

                PostCurso(singleCurso);
                PostDisciplina(singleDisciplina);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void PostCurso(Curso cur){
        String sql = "INSERT INTO TABLE cursos VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cur.getIden());
            ps.setInt(3, cur.getAno());
            ps.setString(2, cur.getNome());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void PostDisciplina(Disciplina dis){
        String sql = "INSERT INTO TABLE cursos VALUES(?,?,?)";
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
