public class Empleado extends Usuario {
    private String fechaDeNacimiento;
    private Servicio servicioActual;
    private boolean ocupado;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String mail, String numeroCelular, String direccion,String fechaDeNacimiento){
        super(nombre, apellidoPaterno, apellidoMaterno,0, mail, numeroCelular, direccion, null, null);
        this.fechaDeNacimiento = fechaDeNacimiento;
        ocupado = false;
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
    public boolean getOcupado(){
        return ocupado;
    }
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
