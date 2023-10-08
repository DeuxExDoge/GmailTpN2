package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SendMailsTest {
@Test
    public void create_appuser_send_mail(){
    MailManager aplicacion = new MailManager();
    User mario = aplicacion.crearUsuario("Mario", "Gonzalez", "GonzalezJr");
    User felix = aplicacion.crearUsuario("Felix", "Toledo", "felixt");
    User pedro = aplicacion.crearUsuario("Pedro", "Pepe", "Pepepedro@gmail.com");
    ArrayList<String> para = new ArrayList<>();
    para.add("felixt@Pepe.com");
    para.add("Pepepedro@gmail.com");

    mario.crearMensaje(aplicacion, "Que onda pibe", "Sale un Lolsito pibe", para);
    assertEquals(1, mario.getSalida().tamano());
    assertEquals(1, felix.getEntrada().tamano());
    assertEquals(1, pedro.getEntrada().tamano());
}

}
