/** 
@author Leo Valencia Santa 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

 public class nino {
    
    // Variables
    String nombre;
    int edad;
    int cantidadHermanos;
    boolean usaTransporte;

    // Constructor básico
    public nino(String nombre, int edad, int cantidadHermanos, boolean usaTransporte) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadHermanos = cantidadHermanos;
        this.usaTransporte = usaTransporte;
    }

    // Getters y setters
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

    public int getCantidadHermanos() {
        return cantidadHermanos;
    }

    public void setCantidadHermanos(int cantidadHermanos) {
        this.cantidadHermanos = cantidadHermanos;
    }

    public boolean isUsaTransporte() {
        return usaTransporte;
    }

    public void setUsaTransporte(boolean usaTransporte) {
        this.usaTransporte = usaTransporte;
    }
}