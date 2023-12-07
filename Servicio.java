public class Servicio {
    private String tipoDeServicio;
    private Mascota laMascota;
    private Cliente elCliente;
    private float costoDelServicio;

    public Servicio(String tipoDeServicio,Mascota laMascota, Cliente elCliente,float costoDelServicio){
        this.tipoDeServicio = tipoDeServicio;
        this.laMascota = laMascota;
        this.elCliente = elCliente;
        this.costoDelServicio = costoDelServicio;
    }
    public void setTipoDeServicio(String tipoDeServicio){
        this.tipoDeServicio = tipoDeServicio;
    }
    public String getTipoDeServicio(){
        return tipoDeServicio;
    }
    public void setLaMascota(Mascota laMascota){
        this.laMascota = laMascota;
    }
    public Mascota getLaMascota(){
        return laMascota;
    }
    public void setElCliente(Cliente elCliente){
        this.elCliente = elCliente;
    }
    public Cliente getElCliente(){
        return elCliente;
    }
    public void setCostoDelServicio(float costoDelServicio){
        this.costoDelServicio = costoDelServicio;
    }
    public float getCostoDelServicio(){
        return costoDelServicio;
    }

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
    //Busca el servicio dentro del archivo de servicios
}
