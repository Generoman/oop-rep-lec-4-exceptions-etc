package interfaces;

import java.util.Scanner;

public class MenuPrinter {

    // En metode som skal printe en meny til konsoll, og behandle menyalternativer
    // Metoden tar inn et objekt av typen PrintableMenu, som er et interface
    // Alle klasser som implementerer dette interfacet kan altså brukes som argumenter her
    // (Et argument er det man setter inn i en parameter)
    public void printMenu(PrintableMenu menu) {

        // Lager et scanner-objekt som leser brukerinput fra konsoll
        Scanner consoleReader = new Scanner(System.in);

        // Kjører en while-loop så lenge menu-parameteren ikke er lik null
        while (menu != null) {

            // Kjører metoder som tilhører menu-objektet vårt (som er enten av typen MainMenu eller OptionsMenu)
            menu.printMenuMessage();

            menu.printMenuAlternatives();

            // DEN NESTE DELEN ER IKKE NØDVENDIG Å FORSTÅ FOR OOP-PENSUM!!!
            // Dette er mer relevant for algoritmer og datastrukturer. Se bort fra det om dere ikke forstår
            // Om dere likevel er nysgjerrige, send meg spm på MatterMost. Om jeg ikke er begravd i eksamensarbeid, kan jeg forklare nærmere
            // Dette er et rekursivt metodekall, som vil si at printMenu-metoden kjører seg selv inne i metode-bodyen
            // Vi printer en ny meny valgt via pickMenuAlternative-metoden. Denne tar inn brukerinput fra scanneren vår som argument
            printMenu(
                    menu.pickMenuAlternative(
                            consoleReader.nextLine()
                    )
            );
        }

        // Lukker scanner-objektet vårt når vi er ferdig å bruke det
        consoleReader.close();
    }


    public static void main(String[] args) {

        // Lager et objekt av MenuPrinter-klassen
        MenuPrinter menuPrinter = new MenuPrinter();

        // Lager et objekt av MainMenu-klassen
        MainMenu mainMenu = new MainMenu();

        // Kjører printMenu-metoden med mainMenu-objektet som argument
        menuPrinter.printMenu(mainMenu);

    }
}
