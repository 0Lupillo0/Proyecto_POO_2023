import java.util.Scanner;

/**
 * Clase Menus.
 * En esta clase se definen métodos estáticos para desplegar los distintos menus del sistema.
 * @version 02/12/2023
 */
public class Utilidades {
    public static Scanner scanner = new Scanner(System.in);
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
        System.out.println("----NUEVO REGISTRO----");
        boolean passwordsIguales = false;
        boolean datosCorrectos = false;
        boolean coincidenciaNickPass = false;
        String nombre = null, apellidoPaterno = null, apellidoMaterno = null, correo = null, numeroCelular = null, direccion = null, nickname = null, password1 = null, password2 = null;
        int edad = 0;
        while(!datosCorrectos){
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
            System.out.println("¿Los datos ingresados son correctos?");
            System.out.println("Si - No");
            String validacionDatos = scanner.nextLine();
            if(validacionDatos.equalsIgnoreCase("Si")){
                datosCorrectos = true;
            } else if (validacionDatos.equalsIgnoreCase("No")) {
                datosCorrectos = false;
                System.out.println("Entendido, reingresa los datos.");
            }
        }
        while(!passwordsIguales){
            System.out.println("Ingresa un nickname:");
            nickname = scanner.nextLine();
            System.out.println("Ingresa una contraseña:");
            password1 = scanner.nextLine();
            System.out.println("Confirma la contraseña ingresándola otra vez");
            password2 = scanner.nextLine();
            if(password1.equals(password2)){
                passwordsIguales = true;
                //La idea seria meter el filtro para revisar que el nickname y la contraseña no esten ya registrados. Se podria hacer un if que evalue el valor de los boolean de abajo, los metodos retornan valores booleanos.
                boolean nickPassClientes = LectorDeArchivos.buscaNickPassClientes(nickname, password2);
                boolean nickPassAdmins = LectorDeArchivos.buscaNickPassAdmins(nickname, password2);
                Utilidades.impresionDeDatosMenu(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2);
            } else{
                passwordsIguales = false;
                System.out.println("Las contraseñas no coinciden.");
                System.out.println("Vuelve a intentarlo.");
            }
        }
        System.out.println("¿Los datos ingresados corresponden a un cliente o a un administrador?");
        String tipoDeCuenta = scanner.nextLine();
        if(tipoDeCuenta.equalsIgnoreCase("Cliente")){
            System.out.println("Se registrara un cliente.");
            Cliente nuevoCliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2);
            EscritorDeArchivos.escribirCliente(nuevoCliente);

        } else if (tipoDeCuenta.equalsIgnoreCase("Administrador")) {
            System.out.println("Se registrara un administrador.");
            System.out.println("Ingresa un ID para el nuevo administrador:");
            String idAdministrador = scanner.nextLine();
            Administrador nuevoAdministrador = new Administrador(nombre, apellidoPaterno, apellidoMaterno, edad, correo, numeroCelular, direccion, nickname, password2, idAdministrador);
            EscritorDeArchivos.escribirAdministrador(nuevoAdministrador);
        }
    }

    /**
     * Este método imprime el menu para ingresar al sistema con un nickname y una contraseña registrados.
     */
    public static void menuIngresar(){
        System.out.println("----INGRESAR----");
        System.out.println("Ingresar como:");
        System.out.println("- Cliente");
        System.out.println("- Administrador");
        String opcionMenuIngresar = scanner.nextLine();
        if(opcionMenuIngresar.equalsIgnoreCase("Cliente")){
            System.out.println("----CLIENTE----");
        } else if (opcionMenuIngresar.equalsIgnoreCase("Administrador")) {
            System.out.println("----ADMINISTRADOR----");
        }
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
}
