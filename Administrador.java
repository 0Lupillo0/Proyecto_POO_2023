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
        Utilidades.limpPantalla();
        System.out.println("Se ha registrado un empleado");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

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
