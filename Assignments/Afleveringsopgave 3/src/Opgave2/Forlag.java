package Opgave2;

public class Forlag {
    //We create the 2 two fields of the class
    private String navn;
    private String sted;

    //The Constructor for Forlag
    public Forlag (String navn, String sted) {
        this.navn = navn;
        this.sted = sted;
    }

    @Override
    public String toString() {
        return navn;
    }
}
