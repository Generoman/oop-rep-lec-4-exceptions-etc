package interfaces;

// Legg merke til at denne klassen implementerer interfacet PrintableMenu (bruker nøkkelordet "implements")
// Dette betyr at vi må override alle ikke-static metodene som interfacet inneholder
public class MainMenu implements PrintableMenu {

    @Override
    public void printMenuMessage() {
        System.out.println("Main menu");
    }

    @Override
    public void printMenuAlternatives() {
        System.out.println("1 - Options");
        System.out.println("2 - Quit");
    }

    // Denne metoden tar inn en string, og skal returnere et PrintableMenu-objekt
    @Override
    public PrintableMenu pickMenuAlternative(String userInput) {

        // Hvis input er "1", returnerer vi et OptionsMenu-objekt
        if (userInput.equals("1")) {

            return new OptionsMenu();

        // Hvis input er "2", returnerer vi null
        } else if (userInput.equals("2")) {

            return null;

        // Hvis input ikke er "1" eller "2", returnerer vi dette objektet (det samme MainMenu-objektet på nytt)
        } else {

            System.out.println("Pick a valid option");

            return this;
        }
    }
}
