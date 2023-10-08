package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void create_new_user_with_name_surname_mailAdress(){
        User felixtoledo = new User("Felix", "Toledo", "felixtoledoctes");

        String nameOfFelix = felixtoledo.getNombre();
        String surnameOfFelix = felixtoledo.getApelldio();
        String mailOfFelix = felixtoledo.getDireccionCorreo();

        assertEquals("Felix", nameOfFelix);
        assertEquals("Toledo", surnameOfFelix);
        assertEquals("felixtoledoctes@aquilita.com", mailOfFelix);
    }

   

    @Test
    public void user_functions_test(){
        User user = new User("Felix", "Toledo", "felix@gmail.com");
        user.setNombre("Felixito");
        user.setApellido("Perez");
        user.setDireccionCorreo("felixperez@gmail.com");

        String hasToBeName = "Felixito";
        String hasToBeSurname = "Perez";
        String hasToBeMailAdress = "felixperez@gmail.com";

        assertEquals(hasToBeName, user.getNombre());
        assertEquals(hasToBeSurname, user.getApelldio());
        assertEquals(hasToBeMailAdress, user.getDireccionCorreo());
    }

}
