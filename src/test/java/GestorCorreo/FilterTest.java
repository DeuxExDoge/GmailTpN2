package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;
import GestorCorreo.Filters.*;

import java.util.ArrayList;


public class FilterTest {
     MailManager app = new MailManager();

     User mario = app.crearUsuario("Mario", "GonzalezJr", "MarioGonzalezJrdoctes");
     User oriana = app.crearUsuario("Oriana", "Farela", "OriFarela@gmail.com");
     User pini = app.crearUsuario("Bruno", "Pini", "PiniBru10");
     

     @Test
     public void filter_from_title(){
          mario.anadirContacto("Bruno", "Pini - Facu", "PiniBru10@Pepe");
          mario.anadirContacto("Orianita", "Le cuesta", "OriFarela@gmail.com");

          mario.crearMensaje(app, "BuscoEste", "mensaje", mario.getTodosLosMailsDeContactos());
          mario.crearMensaje(app, "Nobuskoezte", "mensaje", "OriFarela@gmail.com");
          mario.crearMensaje(app, "EsteSiBusco", "mensaje", "PiniBru10@Pepe.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = mario.filtrarSalida("Busco", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void FilterTitleandWho2(){
          mario.crearMensaje(app, "buenas", "jugamos", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola ", "jugamos", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "gracias", "OriFarela@gmail.com");
          oriana.crearMensaje(app, "hola", "como estas?", "MarioGonzalezJrdoctes@Pepe.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = mario.filtrarSalida("hola", "Mario", filtro);
          assertEquals(1, resultado.size());
}

@Test
     public void FilterTitleandWho3(){
          pini.anadirContacto("Mario", "Gonzalez", "MarioGonzalezJrdoctes@Pepe.com");
          pini.anadirContacto("Lautaro", "vegano", "OriFarela@gmail.com");

          pini.crearMensaje(app, "buenas", "jugamos", pini.getTodosLosMailsDeContactos());
          pini.crearMensaje(app, "hola", "jugamos", "OriFarela@gmail.com");
          pini.crearMensaje(app, "chau", "gracias", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola", "como estas?", "OriFarela@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = pini.filtrarSalida("hola", "Pini", filtro);
          assertEquals(1, resultado.size());
}



     @Test
     public void filter_from_message(){
          mario.crearMensaje(app, "mensaje a pini", "hola Peni", "PiniBru10@Pepe.com");
          mario.crearMensaje(app, "mensaje a pini", "chau Brunito", "PiniBru10@Pepe.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = pini.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          mario.crearMensaje(app, "hola", "mensaje", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "mensaje", "OriFarela@gmail.com");
          pini.crearMensaje(app, "Nobuskoezte", "mensaje", "OriFarela@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("Mario", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          mario.crearMensaje(app, "hola", "mensaje", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola mi hermana", "quiero que hablemos", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "mensaje", "OriFarela@gmail.com");
          pini.crearMensaje(app, "hola", "mensaje", "OriFarela@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("hola", "Mario", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          mario.crearMensaje(app, "hola", "mi hermana", "OriFarela@gmail.com");
          mario.crearMensaje(app, "este no", "mi hermana", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "este no busco", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola", "hermana, como estas?", "OriFarela@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("hola", "hermana", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void name_of_filters(){
          FiltroRemitente filtroRemitente = new FiltroRemitente();
          FiltroMensaje filtroMensaje = new FiltroMensaje();
          FiltroAsunto filtroAsunto = new FiltroAsunto();

          String nombreFiltroRemitente = filtroRemitente.getNombre();
          String nombreFiltroMensaje = filtroMensaje.getNombre();
          String nombreFiltroAsunto = filtroAsunto.getNombre();

          assertEquals("Filtro de Remitente", nombreFiltroRemitente);
          assertEquals("Filtro de Mensaje", nombreFiltroMensaje);
          assertEquals("Filtro de Asunto", nombreFiltroAsunto);

     }

     

}
