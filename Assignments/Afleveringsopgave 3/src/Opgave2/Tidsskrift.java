package Opgave2;

public class Tidsskrift {
    //We create the 3 two fields of the class
    private String titel;
    private Forlag forlag;
    private String issn;

    //Constuctor for the Tidsskrift
    public Tidsskrift (String titel) {
        this.titel = titel;
    }

    //Creating the Setters
    public void setForlag (Forlag forlag) {
        this.forlag = forlag;
    }

    public void setIssn (String issn) {
        this.issn = issn;
    }
    
    @Override
    public String toString () {
        return titel;
    }
}
