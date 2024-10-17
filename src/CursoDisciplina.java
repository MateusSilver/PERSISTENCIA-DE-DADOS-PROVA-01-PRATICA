public class CursoDisciplina {
    private int iden;
    private int ano;
    private String nome;
    private String disciplina;
    private int ch;

    public CursoDisciplina(int iden, int ano, String nomeCurso, String nomeDisciplina, int ch) {
        this.iden = iden;
        this.ano = ano;
        this.nome = nomeCurso;
        this.disciplina = nomeDisciplina;
        this.ch = ch;
    }

    public int getIden() {
        return this.iden;
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
        return this.nome;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nome = nomeCurso;
    }

    public String getNomeDisciplina() {
        return this.disciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
    }

    public int getCh() {
        return this.ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }


}
