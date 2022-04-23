package other;

public class OtherStuff {

    public static void main(String[] args) {

        // Dette er en samling av svar på små spørsmål som kom underveis i forelesningen



        // Litt generelt om arv:

        // ParentClass er en helt vanlig klasse
        ParentClass parent = new ParentClass();

        // Klassen har en metode vi kan kjøre på helt vanlig måte
        parent.printSomething();


        // ChildClass arver fra ParentClass
        ChildClass child = new ChildClass();

        // Klassen har dermed alle public-metodene i ParentClass tilgjengelig
        child.printSomething();

        // ChildClass har også en metode som ParentClass ikke har
        child.printSomethingElse();

        // printSomethingElse() er ikke tilgjengelig for ParentClass
        // Jeg har kommentert ut den neste linja, siden den ikke vil virke

        // parent.printSomethingElse();



        // Hvordan omgjøre en string til en int:

        // Oppretter en String
        String myString = "10";

        // Gjør den om til int og lagrer den i en ny variabel
        int myStringAsInt = Integer.parseInt(myString);



        // Hvordan omgjøre en int til en string:

        // Oppretter en int
        int myInt = 20;

        // Gjør den om til string og lagrer den i en ny variabel
        String myIntAsString = Integer.toString(myInt);
    }
}
