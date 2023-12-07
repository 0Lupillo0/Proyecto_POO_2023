import java.io.*;
public class EscritorDeArchivos {
    public static void escribirCliente(Cliente cliente){
        try{
            File archivo = new File("RegistroClientes.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
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

    public static void escribirAdministrador(Administrador administrador){
        try{
            File archivo = new File("RegistroAdministradores.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
            String cadena = "administrador:";
            String nombre = administrador.getNombre();
            cadena = cadena + nombre + ":";
            String apellidoPaterno = administrador.getApellidoPaterno();
            cadena = cadena + apellidoPaterno + ":";
            String apellidoMaterno = administrador.getApellidoMaterno();
            cadena = cadena + apellidoMaterno + ":";
            int edad = administrador.getEdad();
            cadena = cadena + edad + ":";
            String mail = administrador.getMail();
            cadena = cadena + mail + ":";
            String numeroCelular = administrador.getNumeroCelular();
            cadena = cadena + numeroCelular + ":";
            String direccion = administrador.getDireccion();
            cadena = cadena + direccion + ":";
            String nickname = administrador.getNickname();
            cadena = cadena + nickname + ":";
            String password = administrador.getPassword();
            cadena =  cadena + password;
            objetoEscritor.println(cadena);
            objetoEscritor.close();
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void escribirPerro(Perro perro, String nicknameDuenio){
        try{
            File archivo = new File("RegistroMascotas.txt");
            FileWriter escritor = new FileWriter(archivo,true);
            PrintWriter objetoEscritor = new PrintWriter(escritor);
            String cadena = nicknameDuenio + ":";
            cadena = cadena + "perro:";
            String nombreDelPerro = perro.getNombre();
            cadena = cadena + nombreDelPerro + ":";
            int edad = perro.getEdad();
            cadena = cadena + edad + ":";
            String tipoDePelo = perro.getTipoDePelo();
            cadena = cadena + tipoDePelo + ":";
            String altura = perro.getAltura();
            cadena = cadena + altura;

            objetoEscritor.println(cadena);
            objetoEscritor.close();
        }
        catch(IOException e){
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

    public static void escribirServicio(Servicio elServicio){
        String historialDeServicios = "HistorialDeServicios.txt";
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(historialDeServicios))) {
            // Escribir el objeto en el archivo
            File historialDeServicios = new File("HistorialDeServicios.txt");
            oos.writeObject(elServicio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
