import java.util.ArrayList;
import java.util.LinkedList;

public class Paciente extends Usuario {
    private String enfermedad;
    private Control controlEstablecido;
    private LinkedList<Registro> registroTratamiento;

    public Paciente(UsuarioTipo tipoUsuario, String email, String contrasena, String dni,Control esteControl) {
        super(tipoUsuario, email, contrasena, dni);
        this.enfermedad = "Undefined";
        this.controlEstablecido = esteControl;
        this.registroTratamiento = new LinkedList<>();
    }
///FUNCION COMPLETAR TODAS LAS TAREAS SE GUARDARA LAS REPSUESTAS EN UN STRING BUILDER.
// /FUCION CHECKEA SI COMPLETO TODAS LAS TAREAS O NO
    ///FUNCION CREA REGISTRO PARA ALMARZENAR EN ELUSUARIO.

    public void completarControl(){
        // TODO Poder completar el control, las N veces que dure el control
    }

    public void editarControl(){
        // TODO edita el "control" del dia actual
    }

    public void historialControl(){
        // TODO Ver historial de controles / enfermedad
    }


}
