import java.util.*;

public class Main {
    public static void process(Collection<Integer> collection) {
        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {
            int element = iter.next();
            System.out.print(collection + " " + element);
            if (element > 0) {
                iter.remove();
                System.out.print(":Removed!");
            }
            System.out.println(" " + collection);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.addAll(list);
        Set<Integer> set = new TreeSet<>();
        set.addAll(list);
        System.out.println("List=" + list + " Set=" + set);
        process(list);
        process(set);
        System.out.println("List=" + list + " Set=" + set);
    }
}

// List=[1, 0, 1, 0] Set=[0, 1]
// [1, 0, 1, 0] 1:Removed! [0, 1, 0]
// [0, 1, 0] 0 [0, 1, 0]
// [0, 1, 0] 1:Removed! [0, 0]
// [0, 0] 0 [0, 0]
// [0, 1] 0 [0, 1]
// [0, 1] 1:Removed! [0]
// List=[0, 0] Set=[0]
