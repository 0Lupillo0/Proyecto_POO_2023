import java.io.*;
public class EscritorDeArchivos {
    public static void escribirCliente(Cliente cliente){
        try{
            File archivo = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroClientes.txt");
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
            File archivo = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroAdministradores.txt");
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
            File archivo = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroMascotas.txt");
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
            File archivo = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroMascotas.txt");
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
}
