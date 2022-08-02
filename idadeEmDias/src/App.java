import java.util.Scanner;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner (System.in);
        System.out.println("Qual seu nome?");
        String nome = ler.nextLine();
        System.out.println("Qual a sua idade?");
        int idade = ler.nextInt();
        int dias = 365 * idade;
        System.out.println(nome+", você já viveu "+String.valueOf(dias)+ " dias");
    }
}