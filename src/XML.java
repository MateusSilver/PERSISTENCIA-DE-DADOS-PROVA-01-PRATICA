import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class XML {
    private XStream x;
    private String filename;

    public XML(){
        this.x = new XStream(new DomDriver());
        x.addPermission(AnyTypePermission.ANY);

        this.filename = "./dados.xml";

        x.alias("universidade", Universidade.class);
        x.alias("curso", CursoDisciplina.class);

        x.addImplicitCollection(Universidade.class, "cursos");
    }

    public void visualizar() throws IOException {
        File file = new File(filename);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder xmlBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            xmlBuilder.append(line);
            xmlBuilder.append(System.lineSeparator());
        }
        bufferedReader.close();
        String xml = xmlBuilder.toString();

        Universidade universidade = (Universidade) x.fromXML(xml);

        for(CursoDisciplina c: universidade.getCursos()){
            System.out.println("\nIdentificação: " + c.getIden() +
                    "\nAno: " + c.getAno() +
                    "\nNome do Curso: " + c.getNomeCurso() +
                    "\nDisciplina: " + c.getNomeDisciplina() +
                    "\nCarga Horária: " + c.getCh() + "\n");
        }
    }
    public void buscaNome() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pesquisa \nNome: ");
        String nome = sc.nextLine();

        File file = new File(filename);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder xmlBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            xmlBuilder.append(line);
            xmlBuilder.append(System.lineSeparator());
        }
        bufferedReader.close();
        String xml = xmlBuilder.toString();

        Universidade universidade = (Universidade) x.fromXML(xml);

        for(CursoDisciplina c: universidade.getCursos()){
            if(c.getNomeDisciplina().contains(nome) || c.getNomeCurso().contains(nome)) {
                System.out.println("\nIdentificação: " + c.getIden() +
                        "\nAno: " + c.getAno() +
                        "\nNome do Curso: " + c.getNomeCurso() +
                        "\nDisciplina: " + c.getNomeDisciplina() +
                        "\nCarga Horária: " + c.getCh() + "\n");
            }
        }
    }

    public void buscaNomeAno() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pesquisa \nNome: ");
        String nome = sc.nextLine();

        System.out.println("\nAno: ");
        String ano = sc.nextLine();

        File file = new File(filename);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder xmlBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            xmlBuilder.append(line);
            xmlBuilder.append(System.lineSeparator());
        }
        bufferedReader.close();
        String xml = xmlBuilder.toString();

        Universidade universidade = (Universidade) x.fromXML(xml);

        for(CursoDisciplina c: universidade.getCursos()){
            if((c.getNomeDisciplina().contains(nome) || c.getNomeCurso().contains(nome)) && c.getAno() == Integer.parseInt(ano)) {
                System.out.println("\nIdentificação: " + c.getIden() +
                        "\nAno: " + c.getAno() +
                        "\nNome do Curso: " + c.getNomeCurso() +
                        "\nDisciplina: " + c.getNomeDisciplina() +
                        "\nCarga Horária: " + c.getCh() + "\n");
            }
        }
    }

    public void addToDatabase() throws IOException, SQLException {
        File file = new File(filename);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder xmlBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            xmlBuilder.append(line);
            xmlBuilder.append(System.lineSeparator());
        }
        bufferedReader.close();
        String xml = xmlBuilder.toString();

        Universidade universidade = (Universidade) x.fromXML(xml);

        List<CursoDisciplina> toDatabase = universidade.getCursos();
        ClientBanco cb = new ClientBanco();
        cb.PostCursosDisciplinas(toDatabase);
    }
}
