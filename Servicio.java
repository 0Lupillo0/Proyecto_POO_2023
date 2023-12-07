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
    //Busca el servicio dentro del archivo de servicios

}
