import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class XML {
    public static void visualizar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pesquisa \nNome: ");
        String nome = sc.nextLine();

        XStream x = new XStream();

        try {
            String filename = "./data.xml";
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
            System.out.println(xml);

            x.alias("universidade", List.class);
            x.alias("cursosdisciplinas", CursoDisciplina.class);

            List<CursoDisciplina> cursosDisciplinas = (List<CursoDisciplina>) x.fromXML(xml);

            for(CursoDisciplina c: cursosDisciplinas){
                if(c.getNomeDisciplina().equals(nome) || c.getNomeCurso().equals(nome)){
                    System.out.println("\nIdentificação: " + c.getIden() +
                            "\nAno: " + c.getAno() +
                            "\nNome: " + c.getNomeCurso() +
                            "\nDisciplina: " + c.getNomeDisciplina() +
                            "\nCarga Horária: " + c.getCh() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("\nNome não encontrado\n");
            throw new RuntimeException(e);
        }
    }
}
