import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        double lata = 0.35, garrafa600 = 0.6, garrafa2l = 2.0;

        System.out.println("Quantas latas foram compradas?");
        int qtdLatas = ler.nextInt();

        System.out.println("Quantas garrafas de 600ml foram compradas?");
        int qtdGarrafa600 = ler.nextInt();

        System.out.println("Quantas garrafas de 2L foram compradas?");
        int qtdGarrafa2l = ler.nextInt();

        double litrosTotal = lata * qtdLatas + garrafa600 * qtdGarrafa600 + garrafa2l * qtdGarrafa2l;

        System.out.println("A quantidade total de litros total é: "+litrosTotal);
    }
}