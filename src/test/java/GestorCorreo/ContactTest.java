package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void check_creation_of_contact(){
        Contacto contacto = new Contacto("Pepe", "Pedro", "Pepe@gmail.com");
        assertEquals("Pepe", contacto.getNombre());
        assertEquals("Pedro", contacto.getApellido());
        assertEquals("Pepe@gmail.com", contacto.getDireccionCorreo());
    }

    @Test
    public void contact_functions_test(){
        Contacto contacto = new Contacto("Oriana", "Farela", "OrianaFa@gmail.com");
        contacto.setNombre("Orianita");
        contacto.setApellido("Farela");
        contacto.setDireccionCorreo("OrianaFa@gmail.com");

        String hasToBeName = "Orianita";
        String hasToBeSurname = "Farela";
        String hasToBeMailAdress = "OrianaFa@gmail.com";

        assertEquals(hasToBeName, contacto.getNombre());
        assertEquals(hasToBeSurname, contacto.getApellido());
        assertEquals(hasToBeMailAdress, contacto.getDireccionCorreo());
    }
}
