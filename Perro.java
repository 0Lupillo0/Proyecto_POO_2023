public class Perro extends Mascota{
    private String altura;
    public Perro(String nombre, int edad, String tipoDePelo, String altura){
        super(nombre, edad, tipoDePelo);
        this.altura = altura;
    }

    public Perro(){
        super();
        this.altura = null;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
}
