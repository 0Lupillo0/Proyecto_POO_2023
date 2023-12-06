import java.io.*;
public class Servicio {
    private String tipoDeServicio;

    public Servicio(String tipoDeServicio){
        this.tipoDeServicio = tipoDeServicio;
    }
    public void setTipoDeServicio(String tipoDeServicio){
        this.tipoDeServicio = tipoDeServicio;
    }
    public String getTipoDeServicio(){
        return tipoDeServicio;
    }

    //Busca el servicio dentro del archivo de servicios
    //public Servicio buscarServicio(){
        //agregar un lector de archivos y obtener el servicio

    //}

}
