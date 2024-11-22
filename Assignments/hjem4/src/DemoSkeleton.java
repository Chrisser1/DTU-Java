public class DemoSkeleton {
    public static void main(String[] args) {
        DumpSkeleton a = new DumpSkeleton(7);
        System.out.println("+++++++");
        System.out.println(a);
        for (int i = 0; i < 7; i++) {
            System.out.println(a);
            a.process(i);
        }
        System.out.println(a);
        System.out.println("+++++++");
    }
}

