/** 
@author Leo Valencia Santa 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */


 import java.util.ArrayList;

 public class nivel {
 
     // Variables
     String nombre;
     double valorMatricula;
     int edadMinima;
     int edadMaxima;
     ArrayList<nino> estudiantes;
 
     // Constructor básico
     public nivel(String nombre, double valorMatricula, int edadMinima, int edadMaxima) {
         this.nombre = nombre;
         this.valorMatricula = valorMatricula;
         this.edadMinima = edadMinima;
         this.edadMaxima = edadMaxima;
         this.estudiantes = new ArrayList<>();
     }
 
     // Métodos
     public ArrayList<nino> obtenerEstudiantes() {
         return this.estudiantes;
     }
 
     public double calcularValorFinal(nino nino) {
         double descuento = 0;
         if (nino.getCantidadHermanos() >= 1) {
             descuento += 15; // 15% por el primer hermano
             if (nino.getCantidadHermanos() > 1) {
                 descuento += (nino.getCantidadHermanos() - 1) * 5; // 5% por cada hermano adicional
             }
         }
         double valorDescuento = valorMatricula * (descuento / 100);
         double valorFinal = valorMatricula - valorDescuento;
 
         // Agregar el costo de transporte si lo usa
         if (nino.isUsaTransporte()) {
             valorFinal += 400000; // Costo fijo del transporte
         }
 
         return valorFinal;
     }
 
     // Getters y setters
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(double valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public ArrayList<nino> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<nino> estudiantes) {
        this.estudiantes = estudiantes;
    }  
 }
