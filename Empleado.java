/**
 * Clase que representa a un empleado de nuestro Spa de mascotas.
 * Hereda de la clase Usuario.
 *
 * @author Jhonatan Emmanuel Amaya Esquivel
 * @version 06/12/2023
 */
public class Empleado extends Usuario {
    /**
     * Fecha de nacimiento del empleado.
     */
    private String fechaDeNacimiento;
    /**
     * Servicio actual que el empleado está realizando.
     */
    private Servicio servicioActual;
    /**
     * Estado que indica si el empleado está ocupado o no.
     */
    private boolean ocupado;
    /**
     * Constructor que inicializa los atributos del empleado con la información proporcionada.
     *
     * @param nombre           Nombre del empleado.
     * @param apellidoPaterno  Apellido paterno del empleado.
     * @param apellidoMaterno  Apellido materno del empleado.
     * @param mail             Correo electrónico del empleado.
     * @param numeroCelular    Número de celular del empleado.
     * @param direccion        Dirección del empleado.
     * @param fechaDeNacimiento Fecha de nacimiento del empleado.
     */
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String mail, String numeroCelular, String direccion,String fechaDeNacimiento){
        super(nombre, apellidoPaterno, apellidoMaterno,0, mail, numeroCelular, direccion, null, null);
        this.fechaDeNacimiento = fechaDeNacimiento;
        ocupado = false;
    }
    /**
     * Constructor vacío de la clase Empleado.
     */
    public Empleado(){
        super();
    }

    // Métodos de acceso y modificación para los atributos
    /**
     * Establece la fecha de nacimiento del empleado.
     *
     * @param fechaDeNacimiento Fecha de nacimiento a establecer.
     */
    public void setFechaDeNacimiento(String fechaDeNacimiento){
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    /**
     * Obtiene la fecha de nacimiento del empleado.
     *
     * @return Fecha de nacimiento del empleado.
     */
    public String getFechaDeNacimiento(){
        return fechaDeNacimiento;
    }
    /**
     * Establece el servicio actual que el empleado realizará.
     *
     * @param servicioActual Servicio actual a establecer.
     */
    public void setServicioActual(Servicio servicioActual){
        this.servicioActual = servicioActual;
    }
    /**
     * Obtiene el servicio actual que el empleado está realizando.
     *
     * @return Servicio actual del empleado.
     */
    public Servicio getServicioActual(){
        return servicioActual;
    }

    // Métodos específicos de servicios para mascotas
    /**
     * Realiza el servicio de bañar a una mascota.
     *
     * @param laMascota Mascota a bañar.
     */
    public void bañarMascota(Mascota laMascota){
        try{
            System.out.println("Estoy bañando a "+laMascota.getNombre());
            Thread.sleep(3000);
            if(laMascota instanceof Perro){
                ((Perro)laMascota).ladrar();
            }else if(laMascota instanceof Gato){
                ((Gato)laMascota).maullar();
            }
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
    /**
     * Realiza el servicio de cortar el pelo a una mascota.
     *
     * @param laMascota Mascota a la que se le corta el pelo.
     */
    public void cortarPeloMascota(Mascota laMascota){
        try{
            System.out.println("Le estoy cortando el pelo a "+laMascota.getNombre());
            Thread.sleep(3000);
            if(laMascota instanceof Perro){
                ((Perro)laMascota).ladrar();
            }else if(laMascota instanceof Gato){
                ((Gato)laMascota).maullar();
                System.out.println("Ay este servicio era solo para perros 0-0");
            }
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
    /**
     * Realiza el servicio de cortar las uñas a una mascota.
     *
     * @param laMascota Mascota a la que se le cortan las uñas.
     */
    public void cortarUniasMascota(Mascota laMascota){
        try{
            System.out.println("Le estoy cortando las uñas a "+laMascota.getNombre());
            Thread.sleep(3000);
            if(laMascota instanceof Perro){
                ((Perro)laMascota).ladrar();
            }else if(laMascota instanceof Gato){
                ((Gato)laMascota).maullar();
            }
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
     /**
     * Realiza el servicio de cepillar los dientes a una mascota.
     *
     * @param laMascota Mascota a la que se le cepillan los dientes.
     */
    public void cepillarDientesMascota(Mascota laMascota){
        try{
            System.out.println("Le estoy cepillando los dientes a "+laMascota.getNombre());
            Thread.sleep(3000);
            if(laMascota instanceof Perro){
                ((Perro)laMascota).ladrar();
            }else if(laMascota instanceof Gato){
                ((Gato)laMascota).maullar();
            }
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
     /**
     * Obtiene el estado de ocupación del empleado.
     *
     * @return `true` si el empleado está ocupado, `false` si no lo está.
     */
    public boolean getOcupado(){
        return ocupado;
    }
    /**
     * Realiza el servicio actual asignado al empleado.
     * Este método verifica el tipo de servicio y llama al método específico correspondiente.
     */
    public void realizarServicio(){
        if(servicioActual == null){
            System.out.println("El empleado no tiene ningun servicio pendiente");
            return;
        }
        ocupado = true;
        String tipoDeServicio = servicioActual.getTipoDeServicio();
        Mascota laMascota = servicioActual.getLaMascota();
        if(tipoDeServicio.equalsIgnoreCase("Baño")){
            this.bañarMascota(laMascota);
        }else if(tipoDeServicio.equalsIgnoreCase("Pelo")){
            this.cortarPeloMascota(laMascota);
        }else if(tipoDeServicio.equalsIgnoreCase("Unias")){
            this.cortarUniasMascota(laMascota);
        }else if(tipoDeServicio.equalsIgnoreCase("cepillar")){
            this.cepillarDientesMascota(laMascota);
        }else{
            System.out.println("No tenemos ese tipo de servicio");
        }
        ocupado = false;
    }
}