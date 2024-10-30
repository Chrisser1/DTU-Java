package Opgave2;

public class ArtikelTest {
    public static void main(String[] args) {
        //Creating the first forlag
        Forlag forlag1 = new Forlag("University Press", "Denmark");

        //Creating the two "Tidsskrifter"
        Tidsskrift tidsskrift1 = new Tidsskrift("Journel of Logic");
        Tidsskrift tidsskrift2 = new Tidsskrift("Brain");

        //Setting the "Tidsskrifter's" forlag
        tidsskrift1.setForlag(forlag1);
        tidsskrift2.setForlag(forlag1);

        //Creating two "artikel's"
        Artikel artikel2 = new Artikel(new String[] {"B. Bim"}, "B", tidsskrift1);
        Artikel artikel1 = new Artikel(new String[] {"A. Abe", "A. Turing"}, "A", tidsskrift1);

        //Setting the referencelist for the first "artikel"
        artikel1.setReferencelist(new Artikel[]{artikel2});

        //printing the 2 "artikel's"
        System.out.println(artikel1);
        System.out.println(artikel2);
    }
}
