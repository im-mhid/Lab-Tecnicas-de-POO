import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        float comprimento = 0, largura = 0;
        System.out.println("Insira o comprimento do seu terreno:");
        comprimento = ler.nextFloat();

        System.out.println("Insira a largura do terreno:");
        largura = ler.nextFloat();

        float area = comprimento * largura;

        System.out.println("A área do terreno é: ");
        System.out.print(area);
    }
}
