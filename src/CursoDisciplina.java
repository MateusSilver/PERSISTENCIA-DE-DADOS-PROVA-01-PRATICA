public class CursoDisciplina {
    private int iden;
    private int ano;
    private String nomeCurso;
    private String nomeDisciplina;
    private int ch;

    public CursoDisciplina(int iden, int ano, String nomeCurso, String nomeDisciplina, int ch) {
        this.iden = iden;
        this.ano = ano;
        this.nomeCurso = nomeCurso;
        this.nomeDisciplina = nomeDisciplina;
        this.ch = ch;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }
}
