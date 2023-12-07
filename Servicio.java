/**
 * Clase que representa un servicio ofrecido por nuestro Spa de mascotas.
 *
 * @author Jhonatan Emmanuel Amaya Esquivel 
 * @version 06/12/2023
 */
public class Servicio {
    /**
     * Tipo de servicio que se ofrece a la mascota.
     */
    private String tipoDeServicio;
    /**
     * Mascota a la que se le brinda el servicio.
     */
    private Mascota laMascota;
    /**
     * Cliente que solicita el servicio para su mascota.
     */
    private Cliente elCliente;
    /**
     * Costo asociado al servicio.
     */
    private float costoDelServicio;
    /**
     * Constructor que inicializa los atributos del servicio con la información proporcionada.
     *
     * @param tipoDeServicio    Tipo de servicio a ofrecer.
     * @param laMascota         Mascota a la que se le brinda el servicio.
     * @param elCliente         Cliente que solicita el servicio.
     * @param costoDelServicio  Costo asociado al servicio.
     */
    public Servicio(String tipoDeServicio,Mascota laMascota, Cliente elCliente,float costoDelServicio){
        this.tipoDeServicio = tipoDeServicio;
        this.laMascota = laMascota;
        this.elCliente = elCliente;
        this.costoDelServicio = costoDelServicio;
    }
    /**
     * Constructor vacío de la clase Servicio.
     */
    public Servicio(){
    }

    // Métodos de acceso y modificación para los atributos
    /**
     * Establece el tipo de servicio ofrecido.
     *
     * @param tipoDeServicio Tipo de servicio a establecer.
     */
    public void setTipoDeServicio(String tipoDeServicio){
        this.tipoDeServicio = tipoDeServicio;
    }
    /**
     * Obtiene el tipo de servicio ofrecido.
     *
     * @return Tipo de servicio ofrecido.
     */
    public String getTipoDeServicio(){
        return tipoDeServicio;
    }
    /**
     * Establece la mascota a la que se le brinda el servicio.
     *
     * @param laMascota Mascota a establecer.
     */
    public void setLaMascota(Mascota laMascota){
        this.laMascota = laMascota;
    }
    /**
     * Obtiene la mascota a la que se le brinda el servicio.
     *
     * @return Mascota a la que se le brinda el servicio.
     */
    public Mascota getLaMascota(){
        return laMascota;
    }
    /**
     * Establece el cliente que solicita el servicio.
     *
     * @param elCliente Cliente a establecer.
     */
    public void setElCliente(Cliente elCliente){
        this.elCliente = elCliente;
    }
    /**
     * Obtiene el cliente que solicita el servicio.
     *
     * @return Cliente que solicita el servicio.
     */
    public Cliente getElCliente(){
        return elCliente;
    }
    /**
     * Establece el costo asociado al servicio.
     *
     * @param costoDelServicio Costo asociado al servicio.
     */
    public void setCostoDelServicio(float costoDelServicio){
        this.costoDelServicio = costoDelServicio;
    }
    /**
     * Obtiene el costo asociado al servicio.
     *
     * @return Costo asociado al servicio.
     */
    public float getCostoDelServicio(){
        return costoDelServicio;
    }

    /**
     * Imprime en consola la información detallada del servicio.
     * Muestra información sobre el cliente, la mascota y detalles específicos según el tipo de mascota.
     */
    public void impInfoDelServicio(){
        System.out.println("-----DATOS DEL SERVICIO-----");
        System.out.println("Nombre del cliente:"+elCliente.getNombre()+" "+elCliente.getApellidoPaterno()+" "+elCliente.getApellidoMaterno());
        System.out.println("Nombre de la mascota:"+laMascota.getNombre());
        System.out.println("Edad de la mascota:"+laMascota.getEdad());
        System.out.println("Largo del pelo"+laMascota.getTipoDePelo());
        if(laMascota instanceof Perro){
            System.out.println("Tipo de mascota:Perro");
            System.out.println("Altura:"+((Perro)laMascota).getAltura());
        }else if(laMascota instanceof Gato){
            System.out.println("Tipo de mascota:Gato");
        }
    }
}