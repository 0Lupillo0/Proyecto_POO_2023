import java.util.ArrayList;

public class Cliente extends Usuario{
    private float cuenta;
    private ArrayList<Mascota> mascotas;
    public Cliente(String nombre, String apellidoParterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password){
        super(nombre, apellidoParterno, apellidoMaterno, edad, mail, numeroCelular, direccion, nickname, password);
        this.cuenta = 0.0f;
        this.mascotas = null;
    }

    public void registrarUnaMascota(){

    }

}
