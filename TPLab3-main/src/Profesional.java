import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profesional extends Usuario implements CrearPlanControl {
    private String licencia;
    private ArrayList<Paciente> listaPacientesActivos;
    private ArrayList<Paciente> nuevosPacientes;

    public Profesional(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String licencia) {
        super(tipoUsuario, email, contrasena, dni);
        this.licencia = licencia;
        this.listaPacientesActivos = new ArrayList<>();
        this.nuevosPacientes = new ArrayList<>();
    }


    ///FUNCION QUE CHECKEA SI NO COMPLETARON DATO AYER.
    public void checkearInfoDiaAnterior(){
        short contadorNoCompletados = 0;
        for (Paciente x:listaPacientesActivos) {
            Registro checkeoRegistro = x.getRegistroTratamiento().get(x.contadorDias - 1);
           if (!checkeoRegistro.completoRegistro){
               System.out.println("No completo el registro el paciente: " + x.getEmail());
               contadorNoCompletados++;
            }
        }
        System.out.println("Un total de " + contadorNoCompletados + " NO completaron su registro diario");
    }
}