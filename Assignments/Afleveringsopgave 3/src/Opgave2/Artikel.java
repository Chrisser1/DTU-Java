package Opgave2;

public class Artikel {
    private String[] forfattere;
    private String titel;
    private Tidsskrift tidsskrift;
    private String[] referencelist;

    public Artikel (String[] forfattere, String titel, Tidsskrift tidsskrift) {
        this.forfattere = forfattere;
        this.titel = titel;
        this.tidsskrift = tidsskrift;
    }
    
    public void setReferencelist (String[] referencelist) {
        this.referencelist = referencelist;
    }

    public String toString () {
    
        String result = forfattere[0];

        for (int i = 1; i < forfattere.length; i++) {
            result += " & " + forfattere[i];
        }

        return result + " \"" + titel + "\". " + tidsskrift.toString();
    }
}
