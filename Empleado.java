public class Empleado extends Usuario {
    private String fechaDeNacimiento;
    private Servicio servicioActual;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String mail, String numeroCelular, String direccion,String fechaDeNacimiento){
        super(nombre, apellidoPaterno, apellidoMaterno,0, mail, numeroCelular, direccion, null, null);
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public Empleado(){
        super();
    }
    public void setFechaDeNacimiento(String fechaDeNacimiento){
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getFechaDeNacimiento(){
        return fechaDeNacimiento;
    }
    public void setServicioActual(Servicio servicioActual){
        this.servicioActual = servicioActual;
    }
    public Servicio getServicioActual(){
        return servicioActual;
    }
}
