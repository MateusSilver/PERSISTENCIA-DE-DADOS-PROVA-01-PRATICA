import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        XML xml = new XML();
        System.out.println("Disciplinas\nMenu:" +
                "\n1. Pesquisar nome;\n" +
                "2. Pesquisar ano e nome;\n" +
                "3. Listas todos os Cursos;\n" +
                "4. Exportar para um Bando de dados;\n" +
                "5. Sair\n");

        int option = Integer.parseInt(sc.nextLine());
        while (option != 5){
            if(option == 1) {
                xml.buscaNome();
            } else if(option == 2) {
                xml.buscaNomeAno();
            } else if(option == 3) {
                xml.visualizar();
            } else if(option == 4) {
                xml.addToDatabase();
            } else {
                System.out.println("Fim\n");
            }

            System.out.println("Disciplinas\nMenu:" +
                    "\n1. Pesquisar nome;\n" +
                    "2. Pesquisar ano e nome;\n" +
                    "3. Listas todos os Cursos;\n" +
                    "4. Exportar para um Bando de dados;\n" +
                    "5. Sair\n");
            option = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Fim\n");
    }
}