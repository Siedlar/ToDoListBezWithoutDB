import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @BeforeAll
    static void wypisz(){
        System.out.println("testowanie klasy User");
    }
    @BeforeEach
     void wypisz1(){
        System.out.println("uallala");
    }
    @Test
    void testToString() {
        //given
    User user=new User();
    user.setImie("Krystian");
        user.setNazwisko("Siedlarski");
        //when
    String wynik=user.toString();
        //then
        assertEquals("Krystian Siedlarski",wynik);
    }

    @Test
    void getImie() {
        //given
        User user=new User();
        user.setImie("Krystian");
        //when
        String imie=user.getImie();
        //then
assertEquals("Krystian",imie);
    }
}