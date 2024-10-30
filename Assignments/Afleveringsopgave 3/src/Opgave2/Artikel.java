package Opgave2;

public class Artikel {
    private String[] forfattere;
    private String titel;
    private Tidsskrift tidsskrift;
    private Artikel[] referencelist;

    //The Constructor for Artikel
    public Artikel (String[] forfattere, String titel, Tidsskrift tidsskrift) {
        this.forfattere = forfattere;
        this.titel = titel;
        this.tidsskrift = tidsskrift;
    }
    
    //Creating the Setter
    public void setReferencelist (Artikel[] referencelist) {
        this.referencelist = referencelist;
    }

    @Override
    public String toString () {
    
        String result = forfattere[0];

        for (int i = 1; i < forfattere.length; i++) {
            result += " & " + forfattere[i];
        }

        return result + ": \"" + titel + "\". " + tidsskrift.toString() + ".";
    }
}
