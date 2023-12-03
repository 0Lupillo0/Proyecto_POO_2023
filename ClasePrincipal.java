/**
 * Clase principal del programa.
 * En esta se define el método principal desde el cual se mandan a llamar los distintos métodos para el despliegue de menus de interacción según sea el caso.
 * @version 30/11/2023
 */
public class ClasePrincipal {
    public static void main(String[] args){
        int opcionSwitch1;
        do{
            opcionSwitch1 = Utilidades.menuPrincipal();
            switch(opcionSwitch1){
                case 1:
                    Utilidades.menuNuevoRegistro(); //Se despliega el menu de interacción para realizar un nuevo registro.
                    break;
                case 2:
                    Utilidades.menuIngresar(); //Se despliega el menu de interacción para ingresar al sistema con un registro ya existente.
                    break;
                case 3:
                    System.out.println("Cerrando sistema..."); //Se imprime este mensaje indicando que se terminara la ejecución del programa.
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo"); //Mensaje indicando que la opción ingresada no es válida.
                }
        }while(opcionSwitch1 != 3);
    }
}
