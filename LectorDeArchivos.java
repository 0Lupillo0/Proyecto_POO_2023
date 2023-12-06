import java.io.*;
import java.util.ArrayList;
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
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoClientes = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
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
                String[] datos = new String[10];
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while(particion.hasMoreTokens()){
                    datos[i] = particion.nextToken();
                    i++;
                }
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoAdmins = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return encontradoAdmins;
    }

    public static void llenarArraylistClientes(ArrayList<Cliente> clientes){
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroClientes.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                Cliente actual = new Cliente();
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i <= datos; i++){
                    if(i == 0){
                        particion.nextToken();
                    } else if (i == 1) {
                        actual.setNombre(particion.nextToken());
                    } else if (i == 2){
                        actual.setApellidoPaterno(particion.nextToken());
                    } else if (i == 3) {
                        actual.setApellidoMaterno(particion.nextToken());
                    } else if (i == 4) {
                        actual.setEdad(Integer.parseInt(particion.nextToken()));
                    } else if (i == 5) {
                        actual.setMail(particion.nextToken());
                    } else if (i == 6){
                        actual.setNumeroCelular(particion.nextToken());
                    } else if (i == 7) {
                        actual.setDireccion(particion.nextToken());
                    } else if(i == 8){
                        actual.setNickname(particion.nextToken());
                    } else if (i == 9) {
                        actual.setPassword(particion.nextToken());
                    }
                }
                clientes.add(actual);
                lineaLeida = bufferEntrada.readLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosBanioPerro(){
        System.out.println("----------------------Precios Baño----------------------------");
        System.out.println("|Tamaño|Precio Base|Sin pelo|Pelo corto|Pelo medio|Pelo largo|");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioBaniosPerro.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida!= null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosPeloPerro(){
        System.out.println("--------------Precios Corte de Pelo---------------");
        System.out.println("|Tamaño|Sin pelo|Pelo corto|Pelo medio|Pelo largo|");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioPeloPerro.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosUniasPerro(){
        System.out.println("--------------Precios Corte de Uñas---------------");
        System.out.println("|Tamaño|Precio|");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioUniaPerro.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosDentalPerro(){
        System.out.println("--------------Precios Cepillado Dental---------------");
        System.out.println("|Tamaño|Precio|");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioDentalPerro.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosBaniosGato(){
        System.out.println("--------------Precios Baño---------------");
        System.out.println("|Precio base|Sin pelo|Pelo corto|Pelo largo");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioBaniosGato.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPrecioUniasGato(){
        System.out.println("-----Precio Corte de Uñas-----");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioUniaGato.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPrecioDentalGato(){
        System.out.println("-----Precio Cepillado Dental-----");
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PrecioDentalGato.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i < datos; i++){
                    System.out.print("|" + particion.nextToken() + "|");
                }
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cargarMascotasParaCliente(ArrayList<Cliente> clientes) {
        try {
            File archivoMascotas = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroMascotas.txt");
            FileReader lectorMascotas = new FileReader(archivoMascotas);
            BufferedReader bufferEntradaMascotas = new BufferedReader(lectorMascotas);
            String lineaMascota = bufferEntradaMascotas.readLine();
            while (lineaMascota != null) {
                StringTokenizer particionMascota = new StringTokenizer(lineaMascota, ":");
                String nicknameDuenio = particionMascota.nextToken();
                String tipoMascota = particionMascota.nextToken();
                if (tipoMascota.equalsIgnoreCase("perro")) {
                    Perro perro = new Perro();
                    perro.setNombre(particionMascota.nextToken());
                    perro.setEdad(Integer.parseInt(particionMascota.nextToken()));
                    perro.setTipoDePelo(particionMascota.nextToken());
                    perro.setAltura(particionMascota.nextToken());
                    for(Cliente actual : clientes){
                        if(actual.getNickname().equals(nicknameDuenio)){
                            actual.getMascotas().add(perro);
                        }
                    }
                } else if (tipoMascota.equalsIgnoreCase("gato")) {
                    Gato gato = new Gato();
                    gato.setNombre(particionMascota.nextToken());
                    gato.setEdad(Integer.parseInt(particionMascota.nextToken()));
                    gato.setTipoDePelo(particionMascota.nextToken());
                    for(Cliente actual : clientes){
                        if(actual.getNickname().equals(nicknameDuenio)){
                            actual.getMascotas().add(gato);
                        }
                    }
                }
                lineaMascota = bufferEntradaMascotas.readLine();
            }
            bufferEntradaMascotas.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

