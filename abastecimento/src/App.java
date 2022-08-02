import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.println("Quanto custa a gasolina?");
        float precoGasolina = ler.nextFloat();
        System.out.println("Quantos reais de gasolina deseja colocar?");
        float valorAbastecido = ler.nextFloat();

        float litrosTotal = valorAbastecido / precoGasolina  ;

        System.out.println("Você conseguiu abastecer " + litrosTotal + "L com esse valor");

    }
}
