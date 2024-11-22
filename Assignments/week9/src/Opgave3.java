public class Opgave3 {
    public static void main(String[] args) {
        Dump a = new Dump(16);
        System.out.println("++++++++++++++++");
        System.out.println(a);
        a.create(5);
        a.create(6);
        a.create(7);
        a.create(8);
        a.create(9);
        a.create(10);
        for (int x = 0; x < 7; x++) {
            System.out.println(a);
            a.update();
        }
        System.out.println(a);
        System.out.println("++++++++++++++++");
    }
}
