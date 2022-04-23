package interfaces;

// Dette er et interface
public interface PrintableMenu {

    // Et interface KAN ha fields. Disse er automatisk public og static
    // (Legg merke til at public og static-nøkkelordene er grå her)
    // Static fields MÅ ha en verdi
    public static String someString = "whatever";

    // Generelt sett, om man trenger fields som kan brukes av flere subklasser,
    // bør man bruke abstrakte klasser istedenfor interfaces

    // Alle metoder i et interface er public
    // Med mindre metoden er static, skal de IKKE ha en body
    // (En metode-body er det som er mellom krøllparentesene -> {} )
    public void printMenuMessage();

    // Alle ikke-static metoder må overrides i klasser som implementerer interfacet
    // Se MainMenu- og OptionsMenu-klassene
    void printMenuAlternatives();

    // I et interface er det kun metodesignaturen som defineres for en ikke-static metode
    // Det vil altså si returtypen (PrintableMenu her), og parametere (String userInput her)
    PrintableMenu pickMenuAlternative(String userInput);

    // Et interface KAN inneholde metoder med en body, men kun om metoden er static
    // Static metoder trenger ikke å overrides
    static void dummyMethod() {
        System.out.println("This is dummy output");
    }
}
