package other;

// En klasse som arver fra ParentClass, bruker nøkkelordet "extends"
public class ChildClass extends ParentClass {

    public void printSomethingElse() {
        System.out.println("Printing something as ChildClass");
    }


    // Om vi ønsker at printSomething()-metoden skal oppføre seg annerledes når vi kjører
    // den på et ChildClass-objekt, kan vi override den.
    // Denne koden er kommentert ut for å vise hvordan metoden vil fungere UTEN overriding
    // Fjern kommentartegnene (//) på de neste linjene for å se hvordan ting endrer seg
//    @Override
//    public void printSomething() {
//        System.out.println("Printing something as ChildClass (overridden)");
//    }
}
