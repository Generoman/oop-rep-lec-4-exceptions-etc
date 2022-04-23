## Hvordan laste ned prosjektet:

### Metode 1:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Velg `Download ZIP`
* Pakk ut ZIP-filen i en egenvalgt mappe, og åpne prosjektet i IntelliJ

### Metode 2:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Trykk på knappen til høyre for linken
* Velg `New -> Project from Version Control...` i IntelliJ
* Lim inn linken i URL-feltet og velg mappa hvor prosjektet skal lagres

### Oppdatere allerede nedlastet prosjekt:
* Trykk på den blå pila ved siden av teksten "Git" oppe til høyre i IntelliJ
* Om dere har endret koden mellom nedlasting og oppdatering, kan det skje en merge-konflikt. En måte å løse det på er å laste ned prosjektet på nytt

## Ordliste
* Exception / Unntak
  * En uforutsett hendelse som stopper vanlig kjøring av koden
  * Mer info her: https://rollbar.com/blog/java-exceptions-hierarchy-explained/
* `throws`-nøkkelordet
  * Brukes i signaturen til en metode når man vet at koden KAN føre til en exception
  * Fører til at exception ikke blir behandlet av metoden hvor den oppstår, men "sendes videre" til metoden som kalte på metoden som forårsaket en exception
  * Om main-metoden kaster en exception, vil programmet kræsje når exception oppstår
* `try`/`catch`-blokk
  * En måte å behandle exceptions uten å sende de videre
  * Kan sammenlignes med `if`/`else`
    * `try` er som `if` - hvis det IKKE oppstår en exception, gjør dette
    * `catch` er som `else` - hvis det oppstår en exception, gjør dette

Alle andre uttrykk og nøkkelord brukt i dette prosjektet skal være forklart i ordlisten til andre kodeeskempler.