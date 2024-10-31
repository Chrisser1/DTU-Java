import java.util.*;
public class Opgave2 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(1, 4);
        a.set(0, 5);
        a.add(0, 0);
        a.add(1, 1);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(i + ":" + a.get(i) + " ");
        }
        System.out.println(":-)");
    }
}
