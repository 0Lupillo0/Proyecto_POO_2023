import java.io.*;
public class EscritorDeArchivos {
        // Método para escribir información de un Cliente en "RegistroClientes.txt"
    public static void escribirCliente(Cliente cliente){
        try{
            File archivo = new File("RegistroClientes.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
             
            // Se construye la cadena con el formato "cliente:nombre:apellidoPaterno:..."
            String cadena = "cliente:";
            String nombre = cliente.getNombre();
            cadena = cadena + nombre + ":";
            String apellidoPaterno = cliente.getApellidoPaterno();
            cadena = cadena + apellidoPaterno + ":";
            String apellidoMaterno = cliente.getApellidoMaterno();
            cadena = cadena + apellidoMaterno + ":";
            int edad = cliente.getEdad();
            cadena = cadena + edad + ":";
            String mail = cliente.getMail();
            cadena = cadena + mail + ":";
            String numeroCelular = cliente.getNumeroCelular();
            cadena = cadena + numeroCelular + ":";
            String direccion = cliente.getDireccion();
            cadena = cadena + direccion + ":";
            String nickname = cliente.getNickname();
            cadena = cadena + nickname + ":";
            String password = cliente.getPassword();
            cadena =  cadena + password;
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Escribe la información de un administrador en el archivo "RegistroAdministradores.txt".
     *
     * @param administrador Objeto Administrador que contiene la información del administrador a registrar.
     */
    public static void escribirAdministrador(Administrador administrador){
        try {
            File archivo = new File("RegistroAdministradores.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            // Se crea un objeto PrintWriter para escribir en el archivo
            PrintWriter objetoEscritor = new PrintWriter(escritor);

            // Se construye la cadena con el formato "administrador:nombre:apellidoPaterno:..."
            String cadena = "administrador:";
            cadena = cadena + administrador.getNombre() + ":";
            cadena = cadena + administrador.getApellidoPaterno() + ":";
            cadena = cadena + administrador.getApellidoMaterno() + ":";
            cadena = cadena + administrador.getEdad() + ":";
            cadena = cadena + administrador.getMail() + ":";
            cadena = cadena + administrador.getNumeroCelular() + ":";
            cadena = cadena + administrador.getDireccion() + ":";
            cadena = cadena + administrador.getNickname() + ":";
            cadena = cadena + administrador.getPassword();

            // Se escribe la cadena en el archivo y se cierra el recurso
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        } catch(IOException e){
            // Se imprime un mensaje de error en caso de excepción de E/S
            System.out.println("Error: " + e.getMessage());
        }
    }


        /**
     * Escribe la información de un perro y su dueño en el archivo "RegistroMascotas.txt".
     * @param perro         Objeto Perro que contiene la información del perro a registrar.
     * @param nicknameDuenio Nickname del dueño del perro.
     */
    public static void escribirPerro(Perro perro, String nicknameDuenio){
        try {
            // Se crea un nuevo archivo o se abre existente en modo de escritura (append)
            File archivo = new File("RegistroMascotas.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            // Se crea un objeto PrintWriter para escribir en el archivo
            PrintWriter objetoEscritor = new PrintWriter(escritor);

            // Se construye la cadena con el formato "nicknameDuenio:perro:nombreDelPerro:edad:tipoDePelo:altura"
            String cadena = nicknameDuenio + ":";
            cadena = cadena + "perro:";
            cadena = cadena + perro.getNombre() + ":";
            cadena = cadena + perro.getEdad() + ":";
            cadena = cadena + perro.getTipoDePelo() + ":";
            cadena = cadena + perro.getAltura();

            // Se escribe la cadena en el archivo y se cierra el recurso
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        }
        catch(IOException e){
            // Se imprime un mensaje de error en caso de excepción de E/S
            System.out.println(e.toString());
        }
    }


    public static void escribirGato(Gato gato, String nicknameDuenio){
        try{
            File archivo = new File("RegistroMascotas.txt");
            FileWriter escritor = new FileWriter(archivo,true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
            String cadena = nicknameDuenio + ":";
            cadena = cadena + "gato:";
            String nombreDelGato = gato.getNombre();
            cadena = cadena + nombreDelGato + ":";
            int edad = gato.getEdad();
            cadena = cadena + edad + ":";
            String tipoDePelo = gato.getTipoDePelo();
            cadena = cadena + tipoDePelo;
            
            // Se escribe la cadena en el archivo y se cierra el recurso
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public static void escribirEmpleado(Empleado elEmpleado){
        try{
            File archivo = new File("RegistroEmpleados.txt");
            FileWriter escritor = new FileWriter(archivo,true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
            String cadena = new String();
            String nombre = elEmpleado.getNombre();
            cadena = cadena + nombre + ":";
            String apellidoPaterno = elEmpleado.getApellidoPaterno();
            cadena = cadena + apellidoPaterno + ":";
            String apellidoMaterno = elEmpleado.getApellidoMaterno();
            cadena = cadena + apellidoMaterno + ":";
            String fechaDeNacimiento = elEmpleado.getFechaDeNacimiento();
            cadena = cadena + fechaDeNacimiento + ":";
            String correo = elEmpleado.getMail();
            cadena = cadena + correo + ":";
            String numero = elEmpleado.getNumeroCelular();
            cadena = cadena + numero + ":";
            String direccion = elEmpleado.getDireccion();
            cadena = cadena + direccion;

            objetoEscritor.println(cadena);
            objetoEscritor.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }

      /**
     * Escribe la información de un servicio en el archivo "RegistroServicios.txt".
     *
     * @param elServicio Objeto Servicio que contiene la información del servicio a registrar.
     */
    public static void escribirServicio(Servicio elServicio){
        try {
            // Se crea un nuevo archivo o se abre existente en modo de escritura (append)
            File archivo = new File("RegistroServicios.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            // Se crea un objeto PrintWriter para escribir en el archivo
            PrintWriter objetoEscritor = new PrintWriter(escritor);

            // Se construye la cadena con el formato "tipoDeServicio:nicknameCliente:nombreMascota:costoDelServicio"
            String cadena = "";
            cadena = cadena + elServicio.getTipoDeServicio() + ":";
            cadena = cadena + elServicio.getElCliente().getNickname() + ":";
            cadena = cadena + elServicio.getLaMascota().getNombre() + ":";
            cadena = cadena + elServicio.getCostoDelServicio();

            // Se escribe la cadena en el archivo y se cierra el recurso
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        } catch(IOException e){
            // Se imprime un mensaje de error en caso de excepción de E/S
            System.out.println(e.toString());
        }
    }
}
