import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase que representa a un administrador en el sistema.
 * Extiende la clase abstracta Usuario.
 */
public class Administrador extends Usuario {
    // Objeto Scanner para la entrada del usuario
    Scanner scanner = new Scanner(System.in);
    /**
     * Constructor que inicializa un objeto Administrador con información básica.
     *
     * @param nombre          Nombre del administrador.
     * @param apellidoPaterno Apellido paterno del administrador.
     * @param apellidoMaterno Apellido materno del administrador.
     * @param edad            Edad del administrador.
     * @param mail            Correo electrónico del administrador.
     * @param numeroCelular   Número de celular del administrador.
     * @param direccion       Dirección del administrador.
     * @param nickname        Nombre de usuario (nickname) del administrador.
     * @param password        Contraseña del administrador.
     */
    public Administrador(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, mail, numeroCelular, direccion, nickname, password);
    }
    /**
     * Constructor por defecto que llama al constructor de la clase base (Usuario).
     */
    public Administrador() {
        super();
    }
   /**
 * Registra un nuevo empleado solicitando información al usuario, crea un objeto Empleado,
 * lo agrega a una lista y escribe sus datos en un archivo.
 *
 * @param losEmpleados Lista de empleados donde se agregará el nuevo empleado.
 */
public void registrarEmpleado(ArrayList<Empleado> losEmpleados) {
        // Limpia la pantalla para una presentación más clara
        Utilidades.limpPantalla();
        System.out.println("----REGISTRAR EMPLEADO----");
    
        // Solicita información al usuario para crear un nuevo empleado
        String nombre = scanner.nextLine();
        String apellidoPaterno = scanner.nextLine();
        String apellidoMaterno = scanner.nextLine();
        String fechaDeNacimiento = scanner.nextLine();
        String correo = scanner.nextLine();
        String numero = scanner.nextLine();
        String direccion = scanner.nextLine();
    
        // Crea un nuevo objeto Empleado con la información proporcionada
        Empleado nuevoEmpleado = new Empleado(nombre, apellidoPaterno, apellidoMaterno, correo, numero, direccion, fechaDeNacimiento);
    
        // Escribe los datos del nuevo empleado en un archivo
        EscritorDeArchivos.escribirEmpleado(nuevoEmpleado);
    
        // Agrega el nuevo empleado a la lista de empleados
        losEmpleados.add(nuevoEmpleado);
    
        // Limpia la pantalla y muestra un mensaje de éxito
        Utilidades.limpPantalla();
        System.out.println("Se ha registrado un empleado");
    
        // Espera 5 segundos antes de continuar (para dar tiempo al usuario de leer el mensaje)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
}


    // Método para asignar un servicio a un empleado.
    public void asignarServicioAEmpleado(ArrayList<Empleado> losEmpleados){
        int contador = 0;
        int indice,indiceEmpleado;
        System.out.println("----- ASIGNACION DE SERVICIOS -----");
        ArrayList<Servicio> losServicios = new ArrayList<>();
        LectorDeArchivos.llenarArraylistServicios(losServicios);
        if(losServicios.isEmpty()){
            Utilidades.limpPantalla();
            System.out.println("No hay servicios pendientes");
            try{
            Thread.sleep(5000);
            return;
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        for(Servicio s : losServicios){
            System.out.println("-----SERVICIO "+contador+" -----");
            String nombreCliente = s.getElCliente().getNombre();
            String nombreMascota = s.getLaMascota().getNombre();
            System.out.println("Nombre del cliente:"+nombreCliente);
            System.out.println("Nombre de la mascota:"+nombreMascota);
            contador++;
        }
        System.out.println("Ingrese el indice el servicio que quiere asignar:");
        indice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("INFORMACION DEL SERVICIO SELECCIONADO:");
        Servicio servicioBuscado = losServicios.get(indice);
        servicioBuscado.impInfoDelServicio();
        System.out.println("LISTA DE EMPLEADOS DESOCUPADOS:");
        contador = 0;
        for(Empleado e : losEmpleados){
            System.out.println("-----EMPLEADO "+ contador+" -----");
            if(e.getOcupado()){
                System.out.println("Esta ocupado");
                contador++;
                continue;
            }
            e.impInfo();
            contador++;
        }
        System.out.println("Ingrese el indice del empleado que realizara el servicio:");
        indiceEmpleado = scanner.nextInt();
        scanner.nextLine();
        Empleado buscado = losEmpleados.get(indiceEmpleado);
        buscado.setServicioActual(servicioBuscado);
        buscado.realizarServicio();
        Utilidades.limpPantalla();
        System.out.println("Todos los servicios estan listos");
        System.out.println("Nombre del cliente:"+servicioBuscado.getElCliente().getNombre());
        System.out.println("Nombre de la mascota:"+servicioBuscado.getLaMascota().getNombre());
    }
}
