public class Curso {
    private int iden;
    private int ano;
    private String nome;

    public Curso(int iden, int ano, String nome) {
        this.iden = iden;
        this.ano = ano;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
