public class App {
    public static void main(String[] args) throws Exception {
        int soma = 0;
        for(int i = 1; i <= 500; i++) {
            if (i % 2 == 1 && i % 3 == 0) {
                soma += i;
            }
        } 
        System.out.println(soma);
    }
}
