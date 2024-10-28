public class Opgave1 {
    public static void main(String[] args) {
        A x = new A("*");
        B y = new B("**");
        C z = new C("***");
        Nisse v = new Nisse("XY");
        Top[] a = { v, x, y, z };
        printArray(a);
    }

    public static void printArray(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + " " + a[i]);
        }
    }
}
