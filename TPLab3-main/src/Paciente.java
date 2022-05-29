import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Paciente extends Usuario {
    private String enfermedad;
    private Control controlEstablecido;
    protected LinkedList<Registro> registroTratamiento;
    private LocalDate fechaInicio;
    int duracionDias;
    int contadorDias;

    public Paciente(UsuarioTipo tipoUsuario, String email, String contrasena, String dni,Control esteControl) {
        super(tipoUsuario, email, contrasena, dni);
        this.enfermedad = "Undefined";
        this.controlEstablecido = esteControl;
        this.registroTratamiento = new LinkedList<>();
        this.duracionDias = 0;
        this.contadorDias = 0;
    }

///FUNCION COMPLETAR TODAS LAS TAREAS SE GUARDARA LAS REPSUESTAS EN UN STRING BUILDER.
// /FUCION CHECKEA SI COMPLETO TODAS LAS TAREAS O NO
    ///FUNCION CREA REGISTRO PARA ALMARZENAR EN ELUSUARIO.

    public void completarControl() {
        StringBuilder auxUsuario = new StringBuilder();
        int contador = 0;
        Scanner scan = new Scanner(System.in);
        for (TareaControl x : controlEstablecido.tareaControl) {
            System.out.println(x.descripcion);
            System.out.println("Ingrese OPCION DESEADA");
            System.out.println("1- PRESENTA");
            System.out.println("2- NO PRESENTA");
            System.out.println("3- DATO PERSONALIZADO");
            System.out.println("4- NO COMPLETAR");
            System.out.println("0- SALIR");
            while (true) {
                try {
                    short opcion = scan.nextShort();
                    switch (opcion) {
                        case 1:{
                           auxUsuario.append(x.nombreTarea + " : "+ "PRESENTA \n");
                           contador++;
                            break;
                        }
                        case 2:{
                            auxUsuario.append(x.nombreTarea + " : "+ "NO PRESENTA \n");
                            contador++;
                            break;
                        }
                        case 3:{
                            System.out.println("INGRESE EL VALOR PERSONALIZADO ");
                            scan.nextLine();
                            String repuesta = scan.nextLine();
                            auxUsuario.append(x.nombreTarea + " : "+ repuesta + "\n");
                            contador++;
                            break;
                        }
                        case 4:{
                            auxUsuario.append(x.nombreTarea + "VACIO");
                            break;
                        }
                        default:
                            System.out.println("NUMERO INCORRECTO");
                    }
                } catch (NumberFormatException a) {
                    System.out.println("NO INGRESO NUMERO");
                }
            }
        }
        if(contador!= controlEstablecido.tareaControl.size()){
            Registro nuevoRegistro = new Registro(auxUsuario.toString(),false);
            System.out.println("Quedaron datos sin completar");
            registroTratamiento.add(nuevoRegistro);
        }else {
            Registro nuevoRegistro = new Registro(auxUsuario.toString(),true);
            System.out.println("Usted completo el Resistro Diario!!!");
            registroTratamiento.add(nuevoRegistro);
        }

    }




 public void editarControl(){
        Scanner scan = new Scanner(System.in);
     System.out.println("Desea volver a completar el registro?");
     System.out.println("Recuerde que debera completarlo en su totalidad nuevamente en caso de que asi lo desee");
     short opcion = scan.nextShort();
     try {


         switch (opcion) {
             case 1:
                 int index = registroTratamiento.size();
                 registroTratamiento.remove(index - 1);
                 completarControl();
                 break;
             case 2:
                 System.out.println("Volvemos al menu inicial");
                 /// llamado al menu
                 break;
             default:
                 System.out.println("opcion invalida se volvera el menu");
                 break;
         }

     }catch (NumberFormatException a) {
         System.out.println("NO INGRESO NUMERO");
         editarControl();
     }
  }

    public void historialControl() {
        if ((registroTratamiento !=null)){
            if (duracionDias != 0) {
                System.out.println("Usted completo " + contadorDias);
                System.out.println("La duracion del plan de control es:  " + duracionDias);
            } else
                System.out.println("No posee un plan de control activo");
    }else {
            System.out.println("Usted no ah iniciado aun un plan de control");
        }
    }


    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getContadorDias() {
        return contadorDias;
    }

    public void setContadorDias(int contadorDias) {
        this.contadorDias = contadorDias;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Control getControlEstablecido() {
        return controlEstablecido;
    }

    public void setControlEstablecido(Control controlEstablecido) {
        this.controlEstablecido = controlEstablecido;
    }

    public LinkedList<Registro> getRegistroTratamiento() {
        return registroTratamiento;
    }

    public void setRegistroTratamiento(LinkedList<Registro> registroTratamiento) {
        this.registroTratamiento = registroTratamiento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
