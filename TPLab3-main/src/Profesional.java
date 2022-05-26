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

}