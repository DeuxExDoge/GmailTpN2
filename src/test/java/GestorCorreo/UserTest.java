package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void create_new_user_with_name_surname_mailAdress(){
        User pepe = new User("Pepe", "Pedro", "PepePedroctes");

        String nameOf = pepe.getNombre();
        String surnameOf = pepe.getApelldio();
        String mailOf = pepe.getDireccionCorreo();

        assertEquals("Pepe", nameOf);
        assertEquals("Pedro", surnameOf);
        assertEquals("PepePedroctes@Pepe.com", mailOf);
    }

    @Test
    public void create_user_and_check_entry_to_userlist(){
        MailManager aplicacion = new MailManager();
        User pepepedro = aplicacion.crearUsuario("Pepe", "Pedro", "PepePedroctes");
        User orifarela = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");
        
        
        int cantidadDeUsuariosCreados = aplicacion.getListaUsuarios().size();
        User usuarioPepe = aplicacion.getListaUsuarios().get(0);
        
        assertEquals(2, cantidadDeUsuariosCreados);
        assertEquals(pepepedro, usuarioPepe);
    }
    /* 
    @Test
    public void create_new_user_and_give_it_a_personalized_mail_adress(){
        MailManager femailcom = new MailManager();
        User felixtoledo = femailcom.createNewUser("Felix", "Toledo", "felixtoledoctes@gmail.com");
        String mailOfUserInList = femailcom.getUserList().get(0).getMailAdress();
        String mailOfFelix = felixtoledo.getMailAdress();

        assertEquals(mailOfFelix, mailOfUserInList);
    }*/
    /* 
    @Test 
    public void contact_list_test(){
        MailManager app = new MailManager();
        User felix = app.createNewUser("Felix", "Toledo", "felixtoledoctes");

        felix.addNewContact("rodri", "gonzalez - trabajo", "rodrigo@gmail.com");
        felix.addNewContact("Graciela", "Meza", "gracemeza10@femail.ctes");

        ArrayList<Contact> contactos = felix.getContactList();
        int size = contactos.size();

        assertEquals(2, size);
    }*/

    @Test
    public void user_functions_test(){
        User user = new User("Pepe", "Pedro", "Pepe@gmail.com");
        user.setNombre("Pepe");
        user.setApellido("Pedro");
        user.setDireccionCorreo("Pedro@gmail.com");

        String hasToBeName = "Pepe";
        String hasToBeSurname = "Pedro";
        String hasToBeMailAdress = "Pedro@gmail.com";

        assertEquals(hasToBeName, user.getNombre());
        assertEquals(hasToBeSurname, user.getApelldio());
        assertEquals(hasToBeMailAdress, user.getDireccionCorreo());
    }

}
