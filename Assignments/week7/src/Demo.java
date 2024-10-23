public class Demo {
    public static void main(String[] args) {
        Dump p = new Dump();
        p.update(false);
        p.update(true);
        p.update(false);
        p.update(true);
        p.update(false);
        p.update(false);
        p.update(false);
        System.out.println("++++++++");
        System.out.print(p);
        System.out.println("++++++++");
    }
}
