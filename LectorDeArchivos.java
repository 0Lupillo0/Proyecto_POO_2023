import java.io.*;
import java.util.StringTokenizer;


public class LectorDeArchivos {
    public static boolean buscaNickPassClientes(String nickname, String password){
        boolean encontradoClientes = false;
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroClientes.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                String[] datos = new String[10];
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while(particion.hasMoreTokens()){
                    datos[i] = particion.nextToken();
                    i++;
                }
                //Estas líneas sirven solo para comprobar que si se está revisando el nickname y el password.
                System.out.println(datos[8]);
                System.out.println(datos[9]);
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoClientes = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return encontradoClientes;
    }

    public static boolean buscaNickPassAdmins(String nickname, String password){
        boolean encontradoAdmins = false;
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroAdministradores.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                String[] datos = new String[11];
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while(particion.hasMoreTokens()){
                    datos[i] = particion.nextToken();
                    i++;
                }
                //Estas líneas sirven solo para comprobar que si se está revisando el nickname y el password.
                System.out.println(datos[8]);
                System.out.println(datos[9]);
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoAdmins = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return encontradoAdmins;
    }
}
