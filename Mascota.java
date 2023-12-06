public abstract class Mascota {
    private String nombre;
    private int edad;
    private String tipoDePelo;

    public Mascota(String nombre, int edad, String tipoDePelo){
        this.nombre = nombre;
        this.edad = edad;
        this.tipoDePelo = tipoDePelo;
    }

    public Mascota(){
        this.nombre = null;
        this.edad = 0;
        this.tipoDePelo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoDePelo() {
        return tipoDePelo;
    }

    public void setTipoDePelo(String tipoDePelo) {
        this.tipoDePelo = tipoDePelo;
    }
}
