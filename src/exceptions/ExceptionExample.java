package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionExample {

    // Eksempel på behandling av exceptions


    // Field som skal brukes til å holde på tekst hentet fra fil
    public ArrayList<String> textFromFile = new ArrayList<>();


    // Metode som skal lese tekst fra fil og legge det inn i textFromFile
    // Legg merke til "throws FileNotFoundException"
    public void readFromFile() throws FileNotFoundException {

        // Oppretter et File-objekt ved hjelp av filbane
        // Filbanen til en fil kan hentes ut i IntelliJ ved å høyreklikke på filen,
        // velge "Copy Path/Reference..", også velge en av alternativene der.
        // Jeg anbefaler å la filer som koden skal bruke ligge i en mappe som heter
        // "resources", og alltid velge "Path from content root" når filbanen skal hentes ut
        File inputFile = new File("resources/readFromThis.txt");

        // Oppretter et Scanner-objekt som skal lese fra fil
        // Det er denne linja som gjør at vi muligens får en exception her
        // Hva skjer om fila vi prøver å lese ikke finnes?
        // I dette tilfellet "kaster" vi exception videre til metoden som kaller på readFromFile()
        // Derfor står det "throws FileNotFoundException" på linje 21
        Scanner fileScanner = new Scanner(inputFile);

        // En while-loop som kjører så lenge scanneren vår finner en ny linje i filen
        while (fileScanner.hasNextLine()) {

            // Legger til linja vi leser inn i textFromFile
            // Uansett om man skal lese tall (int), booleans, eller strings,
            // vil jeg alltid anbefale å bruke nextLine() istedenfor nextInt()
            // eller nextBoolean(). Dette er fordi nextLine() får med seg
            // "ny linje"-tegnet på slutten av linja, sånn at scanneren faktisk
            // går til neste linje når den skal lese en ny linje
            // Om man absolutt vil ha en boolean eller int (eller noe annet)
            // lest ut av filen, kan man alltids omgjøre en string til en int,
            // boolean, etc. Se eksempel i OtherStuff-klassen
            textFromFile.add(fileScanner.nextLine());
        }

        // Lukker scanneren når vi er ferdig med den
        fileScanner.close();

        System.out.println("\nData read from file.\n");
    }



    // Metode som skal skrive innholdet i textFromFile til en fil
    // Legg merke til at det IKKE står "throws" her
    public void writeToFile() {

        // Istedenfor "throws", behandler vi exception her internt i metoden
        // "try" og "catch" er litt som "if" og "else"
        // "try" blir litt som å si "hvis det IKKE oppstår en exception, gjør dette"
        try {

            // Lager et File-objekt
            // Se linje 23-27 for detaljer
            File outputFile = new File("resources/writeToThis.txt");

            // Oppretter et FileWriter-objekt som skal brukes til å skrive til fil
            // Denne linja KAN føre til exception om filen ikke fins
            FileWriter fileWriter = new FileWriter(outputFile);

            // Går gjennom alle elementer (tekstlinjer) i textFromFile ved hjelp
            // av en foreach-loop
            for (String line : textFromFile) {
                // Skriver linja inn i filen
                fileWriter.write(line + "\n");
            }

            // Lukker fileWriteren vår. Om vi IKKE lukker den, vil ikke
            // endringene vi har gjort (dvs linjene vi har lagt til) lagres
            fileWriter.close();

            System.out.println("\nData written to file.\n");

        // "catch" blir som å si "hvis det oppstår en exception, gjør dette"
        } catch (IOException exception) {

            System.out.println("\nFile could not be found\n");

            // Denne linja skriver ut feilmeldingen som java lager automatisk
            exception.printStackTrace();
        }
    }



    // En metode som printer hele innholdet i textFromFile til konsollen
    public void printToConsole() {

        for (String line : textFromFile) {

            System.out.println(line);
        }
    }





    public static void main(String[] args) {

        // Lager et objekt av ExceptionExample-klassen vår
        ExceptionExample example = new ExceptionExample();

        // Siden readFromFile()-metoden kaster en exception, kan vi fange den opp her i en try/catch-blokk
        // Om vi IKKE fanger den opp her i en try/catch-blokk, må main-metoden også kaste den videre, men
        // da vil programmet automatisk kræsje når det forekommer en exception
        try {

            // Bare som repetisjon - readFromFile() kaster en exception til metoden som kjører den (main
            // i dette tilfellet). main-metoden fanger den opp, og behandler den i en try/catch-blokk
            example.readFromFile();

        } catch (FileNotFoundException everythingWentWrongOhGod) {

            System.out.println("\nFile could not be found\n");

            everythingWentWrongOhGod.printStackTrace();
        }

        // Denne delen har jeg kun med for å vise likheten mellom try/catch og if/else
        // "!example.textFromFile.isEmpty()" er en sjekk på om textFromFile IKKE er tom
        // isEmpty()-metoden returnerer true om arrayListen man kjører den på er tom
        // Ved å sette "!" foran, sjekker jeg om det motsatte er sant.
        // "!" betyr "not", så "NOT empty"
        if (!example.textFromFile.isEmpty()) {

            example.printToConsole();

        } else {

            System.out.println("\nThere is nothing to print\n");
        }

        // writeToFile()-metoden behandler sin potensielle exception internt, så her trenger vi ikke
        // en try/catch-blokk
        example.writeToFile();
    }
}
