public class App {
    public static void main(String[] args) throws Exception {
        String hello = "hello";
        String output = repl(hello, 3);
        System.out.println(output);
    }

    private static String repl(String output, int times) {
        String out = "";
        for (int i = 0; i < times; i++) {
            out += output;
        }
        return out;
    }
}
