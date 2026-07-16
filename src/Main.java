import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            System.out.print("Gênero (Masculino/Feminino): ");
            String genero = sc.nextLine();

            pessoas.add(new Pessoa(nome, idade, genero));

            System.out.print("Deseja continuar? (S/N): ");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("N")) {
                break;
            }
        }

        // Lambda para filtrar somente mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());

        System.out.println("\nLista de Mulheres:");
        mulheres.forEach(System.out::println);

        sc.close();
    }

}
