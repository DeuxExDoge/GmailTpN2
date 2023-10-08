package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;
import GestorCorreo.Filters.*;

import java.util.ArrayList;


public class FilterTest {
     MailManager app = new MailManager();
     /*User felix = app.crearUsuario("Felix", "Toledo", "felixtoledoctes");
     User rodrigo = app.crearUsuario("rodri", "Gonzalez", "rodrigo@gmail.com");
     User grace = app.crearUsuario("grace", "meza", "gracemeza10"); */

     User mario = app.crearUsuario("Mario", "GonzalezJr", "MarioGonzalezJrdoctes");
     User oriana = app.crearUsuario("Oriana", "Farela", "OriFarela@gmail.com");
     User pini = app.crearUsuario("Bruno", "Pini", "PiniBru10");
     

     @Test
     public void filter_from_title(){
          mario.anadirContacto("Gracielita", "Meza - TRABAJO", "PiniBru10@Pepe");
          mario.anadirContacto("Rodri", "Mi hermano", "OriFarela@gmail.com");

          mario.crearMensaje(app, "BuscoEste", "mensaje", mario.getTodosLosMailsDeContactos());
          mario.crearMensaje(app, "Nobuskoezte", "mjito", "OriFarela@gmail.com");
          mario.crearMensaje(app, "EsteSiBusco", "mensaje", "PiniBru10@Pepe.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = mario.filtrarSalida("Busco", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_message(){
          mario.crearMensaje(app, "mensaje a grace", "hola graciela", "PiniBru10@Pepe.com");
          mario.crearMensaje(app, "mensaje a grace", "chau grace", "PiniBru10@Pepe.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = pini.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          mario.crearMensaje(app, "hola", "mjito", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "mjito", "OriFarela@gmail.com");
          pini.crearMensaje(app, "Nobuskoezte", "mjito", "OriFarela@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("Mario", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          mario.crearMensaje(app, "hola", "mjito", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola mi hermano", "quiero que hablemos", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "mjito", "OriFarela@gmail.com");
          pini.crearMensaje(app, "hola", "mjito", "OriFarela@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("hola", "Mario", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          mario.crearMensaje(app, "hola", "mi hermano", "OriFarela@gmail.com");
          mario.crearMensaje(app, "este no", "mi hermano", "OriFarela@gmail.com");
          mario.crearMensaje(app, "chau", "este no busco", "OriFarela@gmail.com");
          mario.crearMensaje(app, "hola", "hermano, como estas?", "OriFarela@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = oriana.filtrarEntrada("hola", "hermano", filtro);
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
