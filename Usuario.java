/**
 * Clase Usuario.
 * En este código se define a la clase Usuario, la cual servirá para heredar a aquellas otras clases que interactuaran con el sistema.
 * NOTA: Se plantea heredar de esta clase a una clase Administrador y a otra clase Cliente.
 * @version 22/11/2023
 */
public abstract class Usuario {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String mail;
    private String numeroCelular;
    private String direccion;
    private String nickname;
    private String password;
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.mail = mail;
        this.numeroCelular = numeroCelular;
        this.direccion = direccion;
        this.nickname = nickname;
        this.password = password;
    }

    public Usuario(){
        this.nombre = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.edad = 0;
        this.mail = null;
        this.numeroCelular = null;
        this.direccion = null;
        this.nickname = null;
        this.password = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void impresionDeDatos(){
        System.out.println("Nombre completo: " + getNombre() + getApellidoPaterno() + getApellidoMaterno());
        System.out.println("Edad: " + getEdad());
        System.out.println("Correo electrónico: " + getMail());
        System.out.println("Número celular:" + getNumeroCelular());
        System.out.println("Dirección:" + getDireccion());
        System.out.println("Nickname: " + getNickname());
        System.out.println("Contraseña: " + getPassword());
    }
}
