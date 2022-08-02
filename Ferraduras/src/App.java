import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int ferraduras = 4;
        System.out.println("Quantos cavalos foram comprados?");
        int cavalos = ler.nextInt();
        int totalFerraduras = cavalos * ferraduras;

        System.out.println("O total de ferraduras é: ");
        System.out.println(totalFerraduras);
    }
}