/** 
@author Leo Valencia Santa 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

 import java.util.ArrayList;
 import java.text.DecimalFormat;
 import javax.swing.JOptionPane;
 
 public class Main {
 
     public static void main(String[] args) {
         
         // Formatear el valor de los costos
         DecimalFormat formater = new DecimalFormat("###,###.##");
 
         // Variables
         ArrayList<nivel> niveles = new ArrayList<>();
         ArrayList<String> resumenEstudiantes = new ArrayList<>();
 
         // Creación de objetos de niveles
         nivel nivel1 = new nivel("Nivel 1", 4300000, 1, 2);
         nivel nivel2 = new nivel("Nivel 2", 3900000, 3, 4);
         nivel nivel3 = new nivel("Nivel 3", 3500000, 5, 5);
 
         // Agregar los niveles a la lista
         niveles.add(nivel1);
         niveles.add(nivel2);
         niveles.add(nivel3);
 
         boolean seguir = true;  // Para controlar el ingreso de más estudiantes
 
         while (seguir) {
             // Ingresar datos del niño
             String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño: ");
             String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + ": ");
             int edad = Integer.parseInt(edadTxt);
             String hermanosTxt = JOptionPane.showInputDialog("Ingrese la cantidad de hermanos de " + nombre + ": ");
             int cantidadHermanos = Integer.parseInt(hermanosTxt);
             int usaTransporte = JOptionPane.showConfirmDialog(null, "¿El niño usará transporte? (Costo adicional: 400.000)", "Transporte", JOptionPane.YES_NO_OPTION);
             
             // Determinar el nivel aplicable
             nivel nivelAplicable = null;
             for (nivel nivel : niveles) {
                 if (edad >= nivel.getEdadMinima() && edad <= nivel.getEdadMaxima()) {
                     nivelAplicable = nivel;
                     break;
                 }
             }
 
             // Si no hay niveles aplicables
             if (nivelAplicable == null) {
                 JOptionPane.showMessageDialog(null, "No hay niveles aplicables para la edad ingresada.");
                 continue;  // Volver a preguntar por un nuevo estudiante
             }
 
             // Crear el objeto Niño
             nino nuevoNino = new nino(nombre, edad, cantidadHermanos, usaTransporte == JOptionPane.YES_OPTION);
 
             // Agregar el niño al nivel
             nivelAplicable.obtenerEstudiantes().add(nuevoNino);
 
             // Calcular el valor final para el niño
             double valorFinal = nivelAplicable.calcularValorFinal(nuevoNino);
             String valorFormateado = formater.format(valorFinal);
 
             // Guardar la información en el ArrayList de resumen
             String resumen = "Nombre: " + nuevoNino.getNombre() + ", Edad: " + nuevoNino.getEdad() +
                              ", Nivel: " + nivelAplicable.getNombre() + ", Valor Total: $" + valorFormateado;
             resumenEstudiantes.add(resumen);  // Agregar resumen a la lista
 
             // Mostrar el valor final formateado a pagar
             JOptionPane.showMessageDialog(null, "El valor final a pagar para " + nuevoNino.getNombre() + " es: $" + valorFormateado);
 
             // Preguntar si desea agregar otro estudiante
             int continuar = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro niño?", "Continuar", JOptionPane.YES_NO_OPTION);
             seguir = (continuar == JOptionPane.YES_OPTION);
         }
 
         // Mostrar el resumen de todos los estudiantes al finalizar
         StringBuilder listaFinal = new StringBuilder("TABLA DEL TOTAL DE ESTUDIANTES INGRESADOS:\n");
         double totalEscuela = 0;
 
         for (nivel nivel : niveles) {
             listaFinal.append("_________________________________________________________________\n");
             listaFinal.append("Nombre Nivel: ").append(nivel.getNombre()).append("\n");
             listaFinal.append("_________________________________________________________________\n");
 
             ArrayList<nino> estudiantesNivel = nivel.obtenerEstudiantes();
             double totalNivel = 0;
 
             if (estudiantesNivel.size() > 0) {
                 for (nino estudiante : estudiantesNivel) {
                     double valorFinal = nivel.calcularValorFinal(estudiante);
                     listaFinal.append("+").append(estudiante.getNombre()).append("(").append(estudiante.getEdad()).append(" años)\n");
                     listaFinal.append(" -Valor Matrícula: ").append(formater.format(nivel.getValorMatricula())).append("\n");
                     listaFinal.append(" -Descuento por hermanos: ").append(formater.format(nivel.getValorMatricula() - valorFinal + (estudiante.isUsaTransporte() ? 400000 : 0))).append("\n");
                     listaFinal.append(" -Costo de transporte: 400.000\n");
                     listaFinal.append("_________________________________________________________________\n");
                     listaFinal.append("TOTAL A PAGAR: ").append(formater.format(valorFinal)).append("\n");
 
                     totalNivel += valorFinal;
                 }
 
                 listaFinal.append("TOTAL NIVEL: ").append(formater.format(totalNivel)).append("\n");
                 totalEscuela += totalNivel;
             } else {
                 listaFinal.append("No hay estudiantes inscritos en este nivel.\n");
             }
             listaFinal.append("_________________________________________________________________\n\n");
         }
 
         listaFinal.append("TOTAL ESCUELA: ").append(formater.format(totalEscuela)).append("\n");
         JOptionPane.showMessageDialog(null, listaFinal.toString());
     }
 }
