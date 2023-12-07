import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario{
    private float cuenta;
    private ArrayList<Mascota> mascotas;
    Scanner scanner = new Scanner(System.in);
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password){
        super(nombre, apellidoPaterno, apellidoMaterno, edad, mail, numeroCelular, direccion, nickname, password);
        this.cuenta = 0.0f;
        this.mascotas = new ArrayList<>();
    }

    public Cliente(){
        super();
        this.cuenta = 0.0f;
        this.mascotas = new ArrayList<>();
    }

    public void registrarUnaMascota(){
        boolean mascotaValida = false;
        while(!mascotaValida){
            System.out.println("----REGISTRAR MASCOTA----");
            System.out.println("Ingrese que desea registrar:");
            System.out.println("Perro - Gato");
            String tipoDeMascota = scanner.nextLine();
            if(tipoDeMascota.equalsIgnoreCase("Perro")){
                mascotaValida = true;
                System.out.println("----PERRO----");
                System.out.println("Ingresa el nombre del perro:");
                String nombrePerro = scanner.nextLine();
                System.out.println("Ingresa la edad del perro en años:");
                int edadPerro = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingresa el tipo de pelo del perro, a continuación se muestran referencias:");
                System.out.println("- Sin pelo (Ej. Xoloitzcuintle, Terrier americano)");
                System.out.println("- Pelo corto (Ej. Dóberman, Pitbull, Bulldog, Beagle)");
                System.out.println("- Pelo medio (Ej. Maltés, Husky, Pastor alemán, Border collie)");
                System.out.println("- Pelo largo (Ej.Collie de pelo largo (Lassie), Galgo albano, Yorkshire terrier, Komondor).");
                String tipoDePeloPerro = scanner.nextLine();
                System.out.println("Ingresa la altura del perro, a continuación se presentan referencias:");
                System.out.println("- Miniatura (25cm o menos)");
                System.out.println("- Pequeño (25cm a 40cm)");
                System.out.println("- Mediano (40cm a 60cm)");
                System.out.println("- Grande (60cm a 80cm)");
                System.out.println("- Gigante (80cm o más)");
                String alturaPerro = scanner.nextLine();
                Perro nuevoPerro = new Perro(nombrePerro, edadPerro, tipoDePeloPerro, alturaPerro);
                getMascotas().add(nuevoPerro);
                String nicknameDuenio = getNickname();
                EscritorDeArchivos.escribirPerro(nuevoPerro, nicknameDuenio);

            } else if (tipoDeMascota.equalsIgnoreCase("Gato")) {
                mascotaValida = true;
                System.out.println("----GATO----");
                System.out.println("Ingresa el nombre del gato:");
                String nombreGato = scanner.nextLine();
                System.out.println("Ingresa la edad del gato en años:");
                int edadGato = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingresa el tipo de pelo del gato, a continuación se presentan referencias:");
                System.out.println("Sin pelo (Ej.Esfinge, Elfo, Bambino);");
                System.out.println("Pelo medio (Ej. Gato doméstico americano, Siamés, Escocés)");
                System.out.println("Pelo largo(Ej.Persa, Angora, Him).");
                String tipoDePeloGato = scanner.nextLine();
                Gato nuevoGato = new Gato(nombreGato, edadGato, tipoDePeloGato);
                getMascotas().add(nuevoGato);
                String nicknameDuenio = getNickname();
                EscritorDeArchivos.escribirGato(nuevoGato, nicknameDuenio);
            } else{
                System.out.println("Opción de registro no valida, intenta de nuevo.");
            }
        }
    }

    public void reservarServicio(){
       if(mascotas.isEmpty()){
           System.out.println("No hay mascotas registradas, registra al menos una para continuar.");
       } else{
           System.out.println("----SOLICITUD DE SERVICIO PARA MASCOTA----");
           System.out.println("Lista de mascotas registradas de: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno());
           int indice = 0;
           for(Mascota actual : mascotas){
               System.out.println("Mascota: " + indice);
               if(actual instanceof Perro){
                   Perro perroActual = (Perro)actual;
                   System.out.println("Nombre: " + perroActual.getNombre());
                   System.out.println("Edad: " + perroActual.getEdad() + " años.");
                   System.out.println("Tipo de pelo: " + perroActual.getTipoDePelo());
                   System.out.println("Altura: " + perroActual.getAltura());
                   System.out.println("Tipo de mascota: Perro");
               } else if (actual instanceof Gato) {
                   System.out.println("Nombre: " + actual.getNombre());
                   System.out.println("Edad: " + actual.getEdad());
                   System.out.println("Tipo de pelo: " + actual.getTipoDePelo());
                   System.out.println("Tipo de mascota: Gato");
               }
               indice++;
           }
           System.out.println("Ingresa el indice correspondiente a la mascota a la cual se le quiere reservar un servicio.");
           int seleccionIndice = scanner.nextInt();
           scanner.nextLine();
           int tamanioLista = mascotas.size();
           if(seleccionIndice > tamanioLista){
               System.out.println("Indice no válido, intente de nuevo.");
           } else {
               Mascota eleccion = mascotas.get(seleccionIndice);
               if(eleccion instanceof Perro){
                   Perro perro = (Perro)eleccion;
                   System.out.println("Nombre: " + perro.getNombre());
                   System.out.println("Edad: " + perro.getEdad() + " años.");
                   System.out.println("Tipo de pelo: " + perro.getTipoDePelo());
                   System.out.println("Altura: " + perro.getAltura());
                   System.out.println("Lista de precios para perro " + perro.getAltura().toLowerCase());
                   LectorDeArchivos.leerPreciosBanioPerro();
                   LectorDeArchivos.leerPreciosDentalPerro();
                   LectorDeArchivos.leerPreciosUniasPerro();
                   LectorDeArchivos.leerPreciosPeloPerro();
                   //Lee el servicio elegido por el cliente
                   System.out.println("Ingrese el numero que corresponda al tipo de servicio que requiere");
                   System.out.println("1.-Baño.");
                   System.out.println("2.-Cepillado dental.");
                   System.out.println("3.-Corte de uñas.");
                   System.out.println("4.-Corte de pelo.");
                   int opcion = 0;
                   String tipoDeServicio = new String();
                   opcion = scanner.nextInt();
                   scanner.nextLine();
                   if(opcion == 1){
                    tipoDeServicio = "banio";
                   }else if(opcion == 2){
                    tipoDeServicio = "cepillado";
                   }else if(opcion == 3){
                    tipoDeServicio = "unias";
                   }else if(opcion ==4){
                    tipoDeServicio = "pelo";
                   }else{
                    System.out.println("Opción no valida.");
                   }

                   float precioTotal = LectorDeArchivos.buscarPrecio(perro, tipoDeServicio);
                   Servicio elServicio = new Servicio(tipoDeServicio, perro, this, precioTotal);
                   EscritorDeArchivos.escribirServicio(elServicio);
                   Utilidades.limpPantalla();
                   System.out.println("Servicio registrado con exito.");
                   mascotas.clear();


               } else if (eleccion instanceof Gato) {
                   Gato gato = (Gato)eleccion;
                   System.out.println("Nombre: " + eleccion.getNombre());
                   System.out.println("Edad: " + eleccion.getEdad());
                   System.out.println("Tipo de pelo: " + eleccion.getTipoDePelo());
                   System.out.println("Lista de precios para gato");
                   LectorDeArchivos.leerPreciosBaniosGato();
                   LectorDeArchivos.leerPrecioUniasGato();
                   LectorDeArchivos.leerPrecioDentalGato();

                   System.out.println("Ingrese el numero que corresponda al tipo de servicio que requiere");
                   System.out.println("1.-Baño.");
                   System.out.println("2.-Cepillado dental.");
                   System.out.println("3.-Corte de uñas.");
                   int opcion = 0;
                   String tipoDeServicio = new String();
                   opcion = scanner.nextInt();
                   scanner.nextLine();
                   if(opcion == 1){
                    tipoDeServicio = "banio";
                   }else if(opcion == 2){
                    tipoDeServicio = "cepillado";
                   }else if(opcion == 3){
                    tipoDeServicio = "unias";
                   }else{
                    System.out.println("Opción no valida.");
                   }

                   float precioTotal = LectorDeArchivos.buscarPrecio(gato, tipoDeServicio);
                   Servicio elServicio = new Servicio(tipoDeServicio, gato, this, precioTotal);
                   EscritorDeArchivos.escribirServicio(elServicio);
                   Utilidades.limpPantalla();
                   System.out.println("Servicio registrado con exito.");
                   mascotas.clear();
               }
           }

       }
    }

    public void verHistorialDeServicios(){
        System.out.println("----HISTORIAL DE SERVICIOS----");
    }

    public void verPreciosDeServicios(){
        System.out.println("PRECIOS PERRO:");
        LectorDeArchivos.leerPreciosBanioPerro();
        LectorDeArchivos.leerPreciosPeloPerro();
        LectorDeArchivos.leerPreciosUniasPerro();
        LectorDeArchivos.leerPreciosDentalPerro();
        System.out.println("PRECIOS GATO:");
        LectorDeArchivos.leerPreciosBaniosGato();
        LectorDeArchivos.leerPrecioUniasGato();
        LectorDeArchivos.leerPrecioDentalGato();
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
