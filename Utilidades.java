import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Menus.
 * En esta clase se definen métodos estáticos para desplegar los distintos menus del sistema.
 * @version 02/12/2023
 */
public class Utilidades {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Administrador> administradores = new ArrayList<>();
    //public static ArrayList<Empleado> empleados = new ArrayList<>(); //De momento no se usa pero hay que ver
    /**
     * Este método imprime el menu principal de la aplicación.
     * @return Valor entero para la sentencia switch que sigue a la llamada al método.
     */
    public static int menuPrincipal(){
        int opcionMenuPrincipal;
        System.out.println("----ESTETICA DE MASCOTAS FI----");
        System.out.println("1. Nuevo registro");
        System.out.println("2. Ingresar");
        System.out.println("3. Salir del sistema");
        opcionMenuPrincipal = scanner.nextInt();
        scanner.nextLine();
        return opcionMenuPrincipal;
    }

    /**
     * Este método imprime el menu para capturar los datos de un nuevo registro en el sistema
     */
    public static void menuNuevoRegistro(){
        limpPantalla();
        boolean passwordsIguales = false;
        boolean datosCorrectos = false;
        boolean coincidenciaNickPass = true;
        String nombre = null, apellidoPaterno = null, apellidoMaterno = null, correo = null, numeroCelular = null, direccion = null, nickname = null, password1 = null, password2 = null;
        int edad = 0;
        //Este proceso consta de 3 filtros para realizar el registro de un nuevo administrados o usuario.
        while(!passwordsIguales || !datosCorrectos || coincidenciaNickPass){
            System.out.println("----NUEVO REGISTRO----");
            System.out.println("Ingresa tu nombre: ");
            nombre = scanner.nextLine();
            System.out.println("Ingresa tu apellido paterno: ");
            apellidoPaterno = scanner.nextLine();
            System.out.println("Ingresa tu apellido materno:");
            apellidoMaterno = scanner.nextLine();
            System.out.println("Ingresa tu edad:");
            edad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingresa un correo electrónico:");
            correo = scanner.nextLine();
            System.out.println("Ingresa un número celular:");
            numeroCelular = scanner.nextLine();
            System.out.println("Ingresa una dirección:");
            direccion = scanner.nextLine();
            System.out.println("Ingresa un nickname:");
            nickname = scanner.nextLine();
            System.out.println("Ingresa una contraseña:");
            password1 = scanner.nextLine();
            System.out.println("Confirma la contraseña ingresándola otra vez");
            password2 = scanner.nextLine();
            //Primer filtro, confirmación de contraseñas.
            if(password1.equals(password2)){
                passwordsIguales = true;
                boolean nickPassClientes = LectorDeArchivos.buscaNickPassClientes(nickname, password2);
                boolean nickPassAdmins = LectorDeArchivos.buscaNickPassAdmins(nickname, password2);
                //Segundo filtro, verificación de nickname y password ya registrados en el sistema.
                if (nickPassClientes || nickPassAdmins) {
                    coincidenciaNickPass = true;
                    limpPantalla();
                    System.out.println("El nickname y la contraseña ya existen en el sistema. Por favor, elige otros.");
                } else {
                    coincidenciaNickPass = false;
                    limpPantalla();
                    Utilidades.impresionDeDatosMenu(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2);
                    System.out.println("¿Los datos ingresados son correctos?");
                    System.out.println("Si - No");
                    String validacionDatos = scanner.nextLine();
                    //Tercer filtro, validación de datos por parte del usuario.
                    if(validacionDatos.equalsIgnoreCase("Si")){
                        datosCorrectos = true;
                    } else if (validacionDatos.equalsIgnoreCase("No")) {
                        System.out.println("Entendido, reingresa los datos.");
                    }
                }
            } else{
                passwordsIguales = false;
                limpPantalla();
                System.out.println("Las contraseñas no coinciden.");
                System.out.println("Reingresa los datos.");
            }
        }
        boolean registroValido = false;
        while(!registroValido){
            System.out.println("¿Los datos ingresados corresponden a un cliente o a un administrador?");
            String tipoDeCuenta = scanner.nextLine();
            if(tipoDeCuenta.equalsIgnoreCase("Cliente")){
                registroValido = true;
                limpPantalla();
                System.out.println("Se registrara un cliente.");
                Cliente nuevoCliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2);
                EscritorDeArchivos.escribirCliente(nuevoCliente);
                clientes.add(nuevoCliente);
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }

            } else if (tipoDeCuenta.equalsIgnoreCase("Administrador")) {
                registroValido = true;
                limpPantalla();
                System.out.println("Se registrara un administrador.");
                Administrador nuevoAdministrador = new Administrador(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2);
                EscritorDeArchivos.escribirAdministrador(nuevoAdministrador);
                administradores.add(nuevoAdministrador);
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            } else {
                limpPantalla();
                System.out.println("Opción de registro no valida, intenta de nuevo.");
            }
        }
    }

    /**
     * Este método imprime el menu para ingresar al sistema con un nickname y una contraseña registrados.
     */
    public static void menuIngresar(ArrayList<Empleado> losEmpleados){
        String nickname;
        String password;
        boolean ingresoValido = false;
        boolean datosCorrectosCliente = false;
        boolean datosCorrectosAdministrador = false;
        LectorDeArchivos.llenarArraylistClientes(clientes);
        LectorDeArchivos.llenarArraylistAdministradores(administradores);
        while(!ingresoValido){
            limpPantalla();
            System.out.println("----INGRESAR----");
            System.out.println("Ingresar como:");
            System.out.println("- Cliente");
            System.out.println("- Administrador");
            String opcionMenuIngresar = scanner.nextLine();
            if(opcionMenuIngresar.equalsIgnoreCase("Cliente")){
                ingresoValido = true;
                limpPantalla();
                while(!datosCorrectosCliente){
                    System.out.println("----CLIENTE----");
                    System.out.println("Ingresa tu nickname:");
                    nickname = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    password = scanner.nextLine();
                    boolean encontrado = LectorDeArchivos.buscaNickPassClientes(nickname, password);
                    if(encontrado){
                        datosCorrectosCliente = true;
                        limpPantalla();
                        System.out.println("Bienvenido " + nickname);
                        for (Cliente actual : clientes) {
                            if(actual.getNickname().equals(nickname) && actual.getPassword().equals(password)){
                                menuCliente(actual);
                            }
                        }
                        clientes.removeAll(clientes);
                    } else{
                        limpPantalla();
                        System.out.println("Nickname y/o contraseña no encontrados.");
                        System.out.println("Porfavor, ingrese bien sus datos.");
                    }
                }
            } else if (opcionMenuIngresar.equalsIgnoreCase("Administrador")) {
                ingresoValido = true;
                limpPantalla();
                while (!datosCorrectosAdministrador) {
                    System.out.println("----ADMINISTRADOR----");
                    System.out.println("Ingresa tu nickname: ");
                    nickname = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    password = scanner.nextLine();
                    boolean encontrado = LectorDeArchivos.buscaNickPassAdmins(nickname, password);
                    if (encontrado) {
                        datosCorrectosAdministrador = true;
                        limpPantalla();
                        System.out.println("Bienvenido " + nickname);
                        for (Administrador actual : administradores) {
                            if(actual.getNickname().equals(nickname) && actual.getPassword().equals(password)){
                                menuAdministrador(actual, losEmpleados);
                            }
                        }
                        administradores.removeAll(administradores);
                    } else {
                        limpPantalla();
                        System.out.println("Nickname y/o contraseña no encontrados.");
                        System.out.println("Porfavor, ingrese bien sus datos.");
                    }
                }
            } else{
                limpPantalla();
                System.out.println("Opción de ingreso no valida, intenta de nuevo.");
            }
        }
    }

    public static void menuCliente(Cliente cliente){
        int opcionCliente;
        do{
            System.out.println("----CLIENTE----");
            System.out.println("1. Registrar una mascota");
            System.out.println("2. Reservar un servicio especial o combo para mascota");
            System.out.println("3. Ver historial de servicio adquiridos");
            System.out.println("4. Ver precios de servicios");
            System.out.println("5. Salir de la sesión");
            opcionCliente = scanner.nextInt();
            scanner.nextLine();
            switch(opcionCliente){
                case 1:
                    cliente.registrarUnaMascota();
                    break;
                case 2:
                    LectorDeArchivos.cargarMascotasParaCliente(clientes);
                    cliente.reservarServicio();
                    break;
                case 3:
                    cliente.verHistorialDeServicios();
                    break;
                case 4:
                    cliente.verPreciosDeServicios();
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }while(opcionCliente!=5);
    }

    public static void impresionDeDatosMenu(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String correo, String numeroCelular, String direccion, String nickname, String password){
        System.out.println("----DATOS INGRESADOS----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Edad: " + edad);
        System.out.println("Correo electrónico: " + correo);
        System.out.println("Número celular: " + numeroCelular);
        System.out.println("Dirección: " + direccion);
        System.out.println("Nickname: " + nickname);
        System.out.println("Contraseña: " + password);
    }

    public static void limpPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al intentar limpiar la pantalla: " + e.getMessage());
        }
    }
    

    public static void menuAdministrador(Administrador elAdmin,ArrayList<Empleado> losEmpleados){
        int opcionAdmin;
        do{
            System.out.println("----ADMINISTRADOR----");
            System.out.println("1. Registrar un empleado");
            System.out.println("2. Asignar un servicio a un empleado");
            System.out.println("3. Cobrar una orden de servicios");
            System.out.println("4. Salir de la sesión");
            opcionAdmin = scanner.nextInt();
            scanner.nextLine();
            switch(opcionAdmin){
                case 1:
                    elAdmin.registrarEmpleado(losEmpleados);
                    break;
                case 2:
                    //Debe mandar a un metodo que asigna un servicio a un empleado
                    break;
                case 3:
                    //Debe mandar a un metodo que cobra una orden de servicios
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }while(opcionAdmin!=4);
    }
}
