import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LectorDeArchivos {
    public static boolean buscaNickPassClientes(String nickname, String password){
        boolean encontradoClientes = false;
        try{
            File archivoClientes = new File("RegistroClientes.txt");
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
            File archivoClientes = new File("RegistroAdministradores.txt");
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
            File archivoClientes = new File("RegistroClientes.txt");
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
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void llenarArraylistAdministradores(ArrayList<Administrador> losAdmins){
        try{
            File archivoClientes = new File("RegistroAdministradores.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                Administrador actual = new Administrador();
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
                losAdmins.add(actual);
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    public static void llenarArraylistEmpleados(ArrayList<Empleado> losEmpleados){
        try{
            File archivoClientes = new File("RegistroEmpleados.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                Empleado actual = new Empleado();
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i <= datos; i++){
                    if(i == 0){
                        actual.setNombre(particion.nextToken());
                    } else if (i == 1) {
                        actual.setApellidoPaterno(particion.nextToken());
                    } else if (i == 2){
                        actual.setApellidoMaterno(particion.nextToken());
                    } else if (i == 3) {
                        actual.setFechaDeNacimiento(particion.nextToken());
                    } else if (i == 4) {
                        actual.setMail(particion.nextToken());
                    } else if (i == 5) {
                        actual.setNumeroCelular(particion.nextToken());
                    } else if (i == 6){
                        actual.setDireccion(particion.nextToken());
                    }
                }
                losEmpleados.add(actual);
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosBanioPerro(){
        System.out.println("----------------------Precios Baño----------------------------");
        System.out.println("|Tamaño|Precio Base|Sin pelo|Pelo corto|Pelo medio|Pelo largo|");
        try{
            File archivoClientes = new File("PrecioBaniosPerro.txt");
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
            bufferEntrada.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosPeloPerro(){
        System.out.println("--------------Precios Corte de Pelo---------------");
        System.out.println("|Tamaño|Sin pelo|Pelo corto|Pelo medio|Pelo largo|");
        try{
            File archivoClientes = new File("PrecioPeloPerro.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosUniasPerro(){
        System.out.println("--------------Precios Corte de Uñas---------------");
        System.out.println("|Tamaño|Precio|");
        try{
            File archivoClientes = new File("PrecioUniaPerro.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosDentalPerro(){
        System.out.println("--------------Precios Cepillado Dental---------------");
        System.out.println("|Tamaño|Precio|");
        try{
            File archivoClientes = new File("PrecioDentalPerro.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPreciosBaniosGato(){
        System.out.println("--------------Precios Baño---------------");
        System.out.println("|Precio base|Sin pelo|Pelo corto|Pelo largo");
        try{
            File archivoClientes = new File("PrecioBaniosGato.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPrecioUniasGato(){
        System.out.println("-----Precio Corte de Uñas-----");
        try{
            File archivoClientes = new File("PrecioUniaGato.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void leerPrecioDentalGato(){
        System.out.println("-----Precio Cepillado Dental-----");
        try{
            File archivoClientes = new File("PrecioDentalGato.txt");
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
            bufferEntrada.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cargarMascotasParaCliente(ArrayList<Cliente> clientes) {
        try {
            File archivoMascotas = new File("RegistroMascotas.txt");
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

    public static float buscarPrecio(Mascota laMascota, String tipoDeServicio) {
        float precioTotal = 0;
        try {
            if (tipoDeServicio.equalsIgnoreCase("Baño")) {
                if (laMascota instanceof Perro) {
                    // Leer archivos para baño de perros
                    String tamanio = ((Perro) laMascota).getAltura();// Linea de casteo que retorna el tamaño del perro
                    File archivoClientes = new File("PrecioBaniosPerro.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                        precioTotal += Float.parseFloat(particion.nextToken());
                        bufferEntrada.close();
                        return precioTotal;
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                } else if (laMascota instanceof Gato) {
                    // Leer archivos para baño de gato
                    File archivoClientes = new File("PrecioBaniosGato.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while (lineaLeida != null) {
                        StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                        int datos = particion.countTokens();
                        for (int i = 0; i <= datos; i++) {
                            if (i == 0) {
                                precioTotal += Float.parseFloat(particion.nextToken());
                            }
                        }
                        lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                    return precioTotal;
                }
            } else if (tipoDeServicio.equalsIgnoreCase("Pelo")) {
                if (laMascota instanceof Perro) {
                    // Leer archivos de corte de pelo de los perros
                    String tamanio = ((Perro) laMascota).getAltura();
                    File archivoClientes = new File("PrecioPeloPerro.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                          precioTotal += Float.parseFloat(particion.nextToken());
                          bufferEntrada.close();
                          return precioTotal;
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                } else if (laMascota instanceof Gato) {
                    System.out.println("No se puede cortar el pelo de un gato");
                }
            } else if (tipoDeServicio.equalsIgnoreCase("Unias")) {
                if (laMascota instanceof Perro) {
                    // Leer archivo de precio uñas perro
                    String tamanio = ((Perro) laMascota).getAltura();
                    File archivoClientes = new File("PrecioUniaPerro.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                          precioTotal += Float.parseFloat(particion.nextToken());
                          bufferEntrada.close();
                          return precioTotal;
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                } else if (laMascota instanceof Gato) {
                    // Leer archivo de precio uñas gato
                    File archivoClientes = new File("PrecioUniasGato.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    precioTotal += Float.parseFloat(lineaLeida);
                    bufferEntrada.close();
                    return precioTotal;
                }
            } else if (tipoDeServicio.equalsIgnoreCase("Cepillar")) {
                if (laMascota instanceof Perro) {
                    // Leer archivo para cepillar dientes de perros
                    String tamanio = ((Perro) laMascota).getAltura();
                    File archivoClientes = new File("PrecioDentalGato.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                          precioTotal += Float.parseFloat(particion.nextToken());
                          bufferEntrada.close();
                          return precioTotal;
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                } else if (laMascota instanceof Gato) {
                    // Leer archivos para cepillar dientes de gato
                    File archivoClientes = new File("PrecioDentalGato.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    precioTotal += Float.parseFloat(lineaLeida);
                    bufferEntrada.close();
                    return precioTotal;
                }
            } else {
                System.out.println("Error inesperado.");
            }
        } catch (IOException e) {
            System.out.println("Error" + e.toString());
        }
        return precioTotal; // Puede que necesites agregar un valor de retorno apropiado en caso de que no entre en ningún caso.
    }
    
}
