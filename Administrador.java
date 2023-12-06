import java.util.ArrayList;
import java.util.Scanner;
public class Administrador extends Usuario{
    Scanner scanner = new Scanner(System.in);
    public Administrador(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password){
        super(nombre, apellidoPaterno, apellidoMaterno, edad, mail, numeroCelular, direccion, nickname, password);
    }

    public Administrador(){
        super();
    }

    public void registrarEmpleado(ArrayList<Empleado> losEmpleados){
        Utilidades.limpPantalla();
        System.out.println("----REGISTRAR EMPLEADO----");
        System.out.println("Ingresa el nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el apellido paterno del empleado:");
        String apellidoPaterno = scanner.nextLine();
        System.out.println("Ingresa el apellido materno del empleado:");
        String apellidoMaterno = scanner.nextLine();
        System.out.println("Ingresa la fecha de nacimiento del empleado (Use el siguiente formato dd/mm/aaaa):");
        String fechaDeNacimiento = scanner.nextLine();
        System.out.println("Ingresa el correo electrónico del empleado:");
        String correo = scanner.nextLine();
        System.out.println("Ingresa el número celular del empleado:");
        String numero = scanner.nextLine();
        System.out.println("Ingresa la dirección del empleado:");
        String direcion = scanner.nextLine();
        Empleado nuevoEmpleado = new Empleado(nombre, apellidoPaterno, apellidoMaterno, correo, numero, direcion, fechaDeNacimiento);
        EscritorDeArchivos.escribirEmpleado(nuevoEmpleado);
        losEmpleados.add(nuevoEmpleado);
        System.out.println("Se ha registrado un empleado");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e);
        }
        scanner.close();
    }

    public void asignarServicio(Empleado elEmpleado){
        Scanner scanner = new Scanner(System.in);
        String tipoDeServicio = new String();

        System.out.println("---- ASIGNAR SERVICIO A EMPLEADO ----");
        System.out.println("Tipo de servicio:");
        tipoDeServicio = scanner.nextLine();
        System.out.println("Mascota asignada:");

        //Jala un servicio de Historial de Servicios.txt y lo elimina del archivo
        Servicio servicioAsignado.encontrarServicio();
        //Asigna el servicio al empleado
        elEmpleado.setServicioActual(servicioAsignado);
    }
}
