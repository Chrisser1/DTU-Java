public class App {
    public static void main(String[] args) throws Exception {
        Letter letterMoney = new Letter("Money", "I would also like to ask for some money, because I'm hella broke. Pls! ");
        Letter letterHobby = new Letter("Hobby", "I started practicing gum eating. It's really fun, but my jaw is fucked:) ");
        Letter letterLoveLife = new Letter("Love life","Sometimes i feel really lonely, because i haven't found a japanese femboy yet. Maybe you could help me with this in the future? ");
        Letter letterClasses = new Letter("Classes","I just had this cool ass class where i had to learn Java. ");

        sendLetter("mom", letterClasses, letterMoney);
        sendLetter("bro", letterClasses, letterHobby);
        sendLetter("beautiful", letterLoveLife, letterHobby);
        sendLetter("dad", letterMoney, letterLoveLife);
    }

    public static void sendLetter(String person, Letter letter1, Letter letter2){
        System.out.println("Hey "+person+"! "+ letter1.message() + letter2.message() + "Cya! \n");
    }
}
