public class Person extends Top {

    public Person(String s) {
        super(s);
    }

    public String toString() {
        return "Person:" + super.toString();
    }
}
