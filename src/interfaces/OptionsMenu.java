package interfaces;

// Legg merke til at denne klassen implementerer interfacet PrintableMenu (bruker nøkkelordet "implements")
// Dette betyr at vi må override alle ikke-static metodene som interfacet inneholder
public class OptionsMenu implements PrintableMenu {

    @Override
    public void printMenuMessage() {
        System.out.println("Options");
    }

    @Override
    public void printMenuAlternatives() {
        System.out.println("1 - Set date");
        System.out.println("2 - Set time");
        System.out.println("3 - Back to main menu");
    }

    @Override
    public PrintableMenu pickMenuAlternative(String userInput) {

        // Lignende logikk som i MainMenu, bare gjort med switch istedenfor if/else
        switch (userInput) {
            case "1" :
                System.out.println("Date is set correctly");
                return this;
            case "2" :
                System.out.println("Time is set correctly");
                return this;
            case "3" :
                return new MainMenu();
            default :
                System.out.println("Pick a valid option");
                return this;
        }
    }
}
