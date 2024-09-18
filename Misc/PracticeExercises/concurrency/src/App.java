public class App implements Runnable {
    public static void main(String[] args) throws Exception {
        (new Thread(new App())).start();
    }

    public void run() {
        System.out.println("Hello from a thread");
    }
}
