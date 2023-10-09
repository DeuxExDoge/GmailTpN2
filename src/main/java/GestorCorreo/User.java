package GestorCorreo;

import GestorCorreo.Filters.*;


import java.util.ArrayList;

public class User {
    //atributos de la clase
    //tenemos un arraylist que recibe la clase contactos
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    //creamos dos bandejas
    private Bandeja entrada = new Bandeja();
    private Bandeja salida = new Bandeja();
    //atributos
    private String nombre;
    private String apellido;
    private String direccionCorreo;
    //instanciamos los atributos y igualamos 
    public User(String nombre, String apellido, String direccionCorreo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccionCorreo(direccionCorreo);
    }
    //recibe nombre, apellido, dirrecccion de correo
    public Contacto anadirContacto(String nombre, String apellido, String direccionCorreo){
    //crea un objeto nuevocontacto de la clase contacto
        Contacto nuevoContacto = new Contacto(nombre, apellido, direccionCorreo);
    //en lista contacto que es un arraylist que recibe contactos
    //añade los nuevos contactos
        listaContactos.add(nuevoContacto);
    //devuelve los nuevos contactos
        return nuevoContacto;
    }
    //me muestra la lista de contactos
    public ArrayList<Contacto> getListaContactos(){
        return listaContactos;
    }

    //Crea un array de strings que se llama mails donde recorremos toda la lista y vamos añadiendo 
    //todas las direcciones de correos a nuestra lista mails y retornamos mails
    public ArrayList<String> getTodosLosMailsDeContactos(){
        ArrayList<String> mails = new ArrayList<>();

        for(Contacto contact : listaContactos){
            mails.add(contact.getDireccionCorreo());
        }

        return mails;
    }

    //
    //
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, String para) {
        ArrayList<String> listPara = new ArrayList<>();
        listPara.add(para);

        crearMensaje(aplicacion, asunto, mensaje, listPara);
    }
    
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, ArrayList<String> para) {
        Mail mail = new Mail(asunto, mensaje, this.getDireccionCorreo(), para);
        aplicacion.mandarMensaje(this, mail);
    }

    public ArrayList<Mail> filtrarSalida(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarSalida(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, entrada);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, entrada);
        return finded;
    }
    //añado a Mail sus caracteristicas  y creando un clon de mail llamado newmail le damos los valores de mail. 
    //hacemos esto antes de hacer un get y un set
    //añadimos un mail a la bandeja de entrad
    //no lo pongo con el mismo objeto añado un clon porque sino se puede modificar
    public void anadirMailEntrada(Mail mail){
        Mail newMail = new Mail(mail.getAsunto(), mail.getMensaje(), mail.getRemitente(), mail.getPara());
        entrada.anadir(newMail);
    }

    //añadimos un mail a la bandeja de salida
    public void anadirMailSalida(Mail mail){
        salida.anadir(mail);
    }
    //
    public void setDireccionCorreo(String direccionCorreo) {
        if(direccionCorreo.contains("@")){
            this.direccionCorreo = direccionCorreo;
        } else {
            this.direccionCorreo = direccionCorreo + "@Pepe.com";
        }
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
       this.apellido = apellido;
    }

    public String getApelldio() {
        return apellido;
    }

    public Bandeja getSalida() {
        return salida;
    }
    
    public Bandeja getEntrada() {
        return entrada;
    }
}
