import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LectorDeArchivos {

    /**
     * Busca un cliente en el archivo "RegistroClientes.txt" por su nombre de usuario (nickname) y contraseña.
     * @param nickname Nombre de usuario del cliente.
     * @param password Contraseña del cliente.
     * @return true si el cliente es encontrado, false en caso contrario.
     */
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

    /**
     * Busca un administrador por su nickname y password en el archivo "RegistroAdministradores.txt".
     * @param nickname El nickname del administrador a buscar.
     * @param password La contraseña del administrador a buscar.
     * @return true si se encuentra un administrador con las credenciales dadas, false de lo contrario.
     */
    public static boolean buscaNickPassAdmins(String nickname, String password) {
        // Variable para indicar si se encontró un administrador con las credenciales dadas.
        boolean encontradoAdmins = false;

        try {
            // Se crea un objeto File para el archivo de administradores.
            File archivoClientes = new File("RegistroAdministradores.txt");

            // Se crean objetos FileReader y BufferedReader para leer el archivo.
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);

            // Se lee la primera línea del archivo.
            String lineaLeida = bufferEntrada.readLine();

            // Se recorre cada línea del archivo.
            while (lineaLeida != null) {
                // Se crea un array de Strings para almacenar los datos de la línea actual.
                String[] datos = new String[10];

                // Se utiliza StringTokenizer para dividir la línea en partes usando el delimitador ":".
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while (particion.hasMoreTokens()) {
                    datos[i] = particion.nextToken();
                    i++;
                }

                // Se compara el nickname y password con los datos de la línea actual.
                if (datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)) {
                    // Se marca como encontrado si las credenciales coinciden.
                    encontradoAdmins = true;
                }
                // Se lee la siguiente línea del archivo.
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Se retorna el resultado de la búsqueda.
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

    /**
     * Lee el archivo "RegistroAdministradores.txt" y llena un ArrayList de objetos Administrador con la información de los administradores.
     * @param losAdmins ArrayList que se llenará con objetos Administrador.
     */
    public static void llenarArraylistAdministradores(ArrayList<Administrador> losAdmins) {
        try {
            // Se crea un objeto File para el archivo de administradores.
            File archivoClientes = new File("RegistroAdministradores.txt");

            // Se crean objetos FileReader y BufferedReader para leer el archivo.
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);

            // Se lee la primera línea del archivo.
            String lineaLeida = bufferEntrada.readLine();

            // Se recorre cada línea del archivo.
            while (lineaLeida != null) {
                // Se crea un objeto Administrador para almacenar la información de la línea actual.
                Administrador actual = new Administrador();

                // Se utiliza StringTokenizer para dividir la línea en partes usando el delimitador ":".
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");

                // Se recorren las partes y se asignan los valores correspondientes al objeto Administrador.
                int datos = particion.countTokens();
                for (int i = 0; i <= datos; i++) {
                    if (i == 0) {
                        particion.nextToken();
                    } else if (i == 1) {
                        actual.setNombre(particion.nextToken());
                    } else if (i == 2) {
                        actual.setApellidoPaterno(particion.nextToken());
                    } else if (i == 3) {
                        actual.setApellidoMaterno(particion.nextToken());
                    } else if (i == 4) {
                        actual.setEdad(Integer.parseInt(particion.nextToken()));
                    } else if (i == 5) {
                        actual.setMail(particion.nextToken());
                    } else if (i == 6) {
                        actual.setNumeroCelular(particion.nextToken());
                    } else if (i == 7) {
                        actual.setDireccion(particion.nextToken());
                    } else if (i == 8) {
                        actual.setNickname(particion.nextToken());
                    } else if (i == 9) {
                        actual.setPassword(particion.nextToken());
                    }
                }

                // Se añade el objeto Administrador al ArrayList.
                losAdmins.add(actual);

                // Se lee la siguiente línea del archivo.
                lineaLeida = bufferEntrada.readLine();
            }

            // Se cierra el BufferedReader.
            bufferEntrada.close();
        } catch (IOException e) {
            // Se maneja la excepción de entrada/salida imprimiendo un mensaje de error.
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

    /**
     * Lee y muestra los precios para el corte de uñas de gatos desde el archivo "PrecioUniaGato.txt".
     */
    public static void leerPrecioUniasGato() {
        // Mensaje informativo para indicar la sección de precios para el corte de uñas.
        System.out.println("-----Precio Corte de Uñas-----");

        try {
            File archivoClientes = new File("PrecioUniaGato.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);

            // Se lee la primera línea del archivo.
            String lineaLeida = bufferEntrada.readLine();

            // Se recorre cada línea del archivo.
            while (lineaLeida != null) {
                // Se utiliza StringTokenizer para dividir la línea en partes usando el delimitador ":".
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                // Se cuenta el número de tokens en la línea.
                int datos = particion.countTokens();
                // Se recorre cada token e imprime en formato de tabla.
                for (int i = 0; i < datos; i++) {
                    System.out.print("|" + particion.nextToken() + "|");
                }
                // Se imprime una nueva línea después de cada línea del archivo.
                System.out.println();
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * Lee y muestra los precios de cepillado dental para gatos desde el archivo "PrecioDentalGato.txt".
     */
    public static void leerPrecioDentalGato() {
        System.out.println("-----Precio Cepillado Dental-----");
        try {
            // Se crea un objeto File para el archivo de precios de cepillado dental de gatos.
            File archivoClientes = new File("PrecioDentalGato.txt");

            // Se crean objetos FileReader y BufferedReader para leer el archivo.
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);

            // Se lee la primera línea del archivo.
            String lineaLeida = bufferEntrada.readLine();

            // Se recorre cada línea del archivo.
            while (lineaLeida != null) {
                // Se utiliza StringTokenizer para dividir la línea en partes usando el delimitador ":".
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                // Se cuenta el número de tokens en la línea.
                int datos = particion.countTokens();
                // Se recorre cada token e imprime en formato de tabla.
                for (int i = 0; i < datos; i++) {
                    System.out.print("|" + particion.nextToken() + "|");
                }
                // Se imprime una nueva línea después de cada línea del archivo.
                System.out.println();
                // Se lee la siguiente línea del archivo.
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * Lee el archivo "RegistroMascotas.txt" y asigna las mascotas correspondientes a cada cliente en el ArrayList de clientes.
     * @param clientes ArrayList de clientes.
     */
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

    public static void leerPrecio(String tamanioBuscado){
        try (BufferedReader br = new BufferedReader(new FileReader("PrecioBaniosPerro.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando el delimitador ":"
                String[] partes = linea.split(":");
                
                // Verificar si el tamaño coincide con el buscado
                if (partes.length > 0 && partes[0].equals(tamanioBuscado)) {
                    // Obtener el número correspondiente
                    if (partes.length > 1) {
                        double numero = Double.parseDouble(partes[1]);
                        System.out.println("Precio base para " + tamanioBuscado + ": " + numero);
                    } else {
                        System.out.println("No se encontró un precio para " + tamanioBuscado);
                    }
                    break; // Puedes salir del bucle si solo estás buscando uno
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calcula y retorna el precio total de un servicio para una mascota específica, leyendo archivos de precios según el tipo de servicio y mascota.
     * @param laMascota Mascota para la que se calculará el precio del servicio.
     * @param tipoDeServicio Tipo de servicio (banio, pelo, unias, cepillado).
     * @return Precio total del servicio.
     */
    public static float buscarPrecio(Mascota laMascota, String tipoDeServicio) {
        float precioTotal = 0;
        try {
            if (tipoDeServicio.equalsIgnoreCase("banio")) {
                if (laMascota instanceof Perro) {
                    // Leer archivos para baño de perros
                    String tipoDePelo = laMascota.getTipoDePelo();
                    String tamanio = ((Perro) laMascota).getAltura();// Linea de casteo que retorna el tamaño del perro
                    File archivoClientes = new File("PrecioBaniosPerro.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                        int datos = particion.countTokens();
                        for (int i = 0; i <= datos; i++) {
                            if (i == 0) {
                                precioTotal += Float.parseFloat(particion.nextToken());
                            }else if(i == 1){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("sin pelo")){
                                    precioTotal += precio;
                                }
                            }else if(i == 2){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo corto")){
                                    precioTotal += precio;
                                }
                            }else if(i == 3){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo medio")){
                                    precioTotal += precio;
                                }
                            }else if(i == 4){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo largo")){
                                    precioTotal += precio;
                                }
                            }
                        }
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                    return precioTotal;
                } else if (laMascota instanceof Gato) {
                    // Leer archivos para baño de gato
                    String tipoDePelo = laMascota.getTipoDePelo();
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
                            }else if(i == 1){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("sin pelo")){
                                    precioTotal += precio;
                                }
                            }else if(i == 2){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo medio")){
                                    precioTotal += precio;
                                }
                            }else if(i == 3){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo largo")){
                                    precioTotal += precio;
                                }
                            }
                        }
                        lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                    return precioTotal;
                }
            } else if (tipoDeServicio.equalsIgnoreCase("pelo")) {
                if (laMascota instanceof Perro) {
                    // Leer archivos de corte de pelo de los perros
                    String tipoDePelo = laMascota.getTipoDePelo();
                    String tamanio = ((Perro) laMascota).getAltura();
                    File archivoClientes = new File("PrecioPeloPerro.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    while(lineaLeida != null){
                      StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                      String tam = particion.nextToken();
                      if(tamanio.equalsIgnoreCase(tam)){
                        int datos = particion.countTokens();
                        for (int i = 0; i <= datos; i++) {
                            if(i == 0){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("sin pelo")){
                                    precioTotal += precio;
                                }
                            }else if(i == 1){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo corto")){
                                    precioTotal += precio;
                                }
                            }else if(i == 2){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo medio")){
                                    precioTotal += precio;
                                }
                            }else if(i == 3){
                                float precio = Float.parseFloat(particion.nextToken());
                                if(tipoDePelo.equalsIgnoreCase("pelo largo")){
                                    precioTotal += precio;
                                }
                            }
                        }
                      }
                      lineaLeida = bufferEntrada.readLine();
                    }
                    bufferEntrada.close();
                    return precioTotal;
                } else if (laMascota instanceof Gato) {
                    System.out.println("No se puede cortar el pelo de un gato");
                }
            } else if (tipoDeServicio.equalsIgnoreCase("unias")) {
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
                    File archivoClientes = new File("PrecioUniaGato.txt");
                    FileReader lector = new FileReader(archivoClientes);
                    BufferedReader bufferEntrada = new BufferedReader(lector);
                    String lineaLeida = bufferEntrada.readLine();
                    precioTotal += Float.parseFloat(lineaLeida);
                    bufferEntrada.close();
                    return precioTotal;
                }
            } else if (tipoDeServicio.equalsIgnoreCase("cepillado")) {
                if (laMascota instanceof Perro) {
                    // Leer archivo para cepillar dientes de perros
                    String tamanio = ((Perro) laMascota).getAltura();
                    File archivoClientes = new File("PrecioDentalPerro.txt");
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
        return precioTotal;
    }

    /**
     * Lee el archivo "RegistroServicios.txt" y llena un ArrayList de objetos Servicio con la información de los servicios realizados.
     * @param servicios ArrayList de servicios.
     */
    public static void llenarArraylistServicios(ArrayList<Servicio> servicios){
        try{
            String nombreDelCliente, nombreDeLaMascota;
            File archivoServicios = new File("RegistroServicios.txt");
            FileReader lector = new FileReader(archivoServicios);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            ArrayList<Cliente> objetosCliente = new ArrayList<>();
            LectorDeArchivos.llenarArraylistClientes(objetosCliente);
            while(lineaLeida != null){
                Servicio actual = new Servicio();
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                int datos = particion.countTokens();
                for(int i = 0; i <= datos; i++){
                    if(i == 0){
                        actual.setTipoDeServicio(particion.nextToken());
                    } else if (i == 1) {
                        nombreDelCliente = particion.nextToken();
                    }else if(i == 2){
                        nombreDeLaMascota = particion.nextToken();
                    }else if (i == 3){
                        float precio = Float.parseFloat(particion.nextToken());
                        actual.setCostoDelServicio(precio);
                    }
                }
                servicios.add(actual);
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
