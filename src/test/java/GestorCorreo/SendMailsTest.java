package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SendMailsTest {
@Test
    public void create_appuser_send_mail(){
    //creamos un objeto mailmanager llamado aplicacion
    MailManager aplicacion = new MailManager();
    //cremos 3 usuarios
    User mario = aplicacion.crearUsuario("Mario", "Gonzalez", "GonzalezJr");
    User felix = aplicacion.crearUsuario("Felix", "Toledo", "felixt");
    User pedro = aplicacion.crearUsuario("Pedro", "Pepe", "Pepepedro@gmail.com");
    //creamos un para
    ArrayList<String> para = new ArrayList<>();
    //añadimos al para los gmails de nuestros usuarios
    para.add("felixt@Pepe.com");
    para.add("Pepepedro@gmail.com");
    //creamos y enviamos el mensaje
    mario.crearMensaje(aplicacion, "Que onda pibe", "Sale un Lolsito pibe", para);
    //comparamos que mario tiene en su bandeja de salida un mensaje enviado y felix y pedro tienen un mensaje recivido
    assertEquals(1, mario.getSalida().tamano());
    assertEquals(1, felix.getEntrada().tamano());
    assertEquals(1, pedro.getEntrada().tamano());
    assertEquals(1, pedro.getEntrada().tamano());
}

}
