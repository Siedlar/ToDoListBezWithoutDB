import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalidacjaTest {

    @Test
    void sprawdzCzyHasloJestIdentyczne() {
    //given
        String haslo="qwerty";
        String haslo2="qwerty";
        //when
        boolean wynik=Walidacja.sprawdzCzyHasloJestIdentyczne(haslo,haslo2);
        //then
        assertTrue(wynik,"Funkcja powinna zwrocic true");
    }
}