package Opgave2;

public class Forlag {
    //We create the 2 two fields of the class
    private String navn;
    private String sted;

    public Forlag (String navn, String sted) {
        this.navn = navn;
        this.sted = sted;
    }

    public String toString() {
        return navn;
    }
}
