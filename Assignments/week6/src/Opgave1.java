public class Opgave1 {
    public static void main(String[] args) throws Exception {
        int[] values = { 74, 85, 102, 99, 101, 85, 56 };
        System.out.println("The index of 85 is: " + lasIndexOf(values, 85));
    }

    private static int lasIndexOf(int[] values, int lookForValue) {
        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == lookForValue) {
                index = i;
            }
        }
        return index;
    }
}
