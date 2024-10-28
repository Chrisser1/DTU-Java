public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Med gange");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * i);
        }
        System.out.println("Uden gange");
        for (int i = 1; i <= 10; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                result += i;
            }
            System.out.println(result);
        }
    }
}
