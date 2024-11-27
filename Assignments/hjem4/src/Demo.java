public class Demo {
    public static void main(String[] args) {
        Dump a = new Dump(7);
        System.out.println("+++++++");
        System.out.println(a);
        a.delta(4, 5);
        a.delta(4, 2147483647);
        a.delta(0, 42);
        a.delta(1, 3);
        a.delta(1, 4);
        a.delta(6, 8);
        a.delta(6, 1);
        a.delta(6, 0);
        a.delta(6, -7);
        a.delta(2, 4);
        a.delta(3, 3);
        for (int i = 0; i < 7; i++) {
            System.out.println(a);
            a.process(i);
        }
        System.out.println(a);
        System.out.println("+++++++");
        }
    }
