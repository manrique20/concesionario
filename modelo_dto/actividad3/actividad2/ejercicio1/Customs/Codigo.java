/*
 * @(#)Codigo.java     17.0.6  28/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
*/

package actividad2.ejercicio1.Customs;

/**
 *  
      Clase abstracta que implementa la interface
      {@code Comparable}. 
      <li> Esta se usa con el fin de atribuir comportamientos
      comunes entre las clases que utilizan números de identificación,
      {@code codigo}, y se comparan entre sí según el susodicho. 
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public abstract class Codigo implements Comparable<Codigo>{

   /**  
   Identificador -ojalá único- de un objeto derivado de {@code Codigo}.*/
   protected int codigo;
   
   /**
   * Permite obtener el codigo del objeto.     
     @return integro, que es el codigo del objeto. */
   public int getCodigo(){
     return codigo;
   }
   
   @Override
   public int compareTo(Codigo n){
        return (codigo==n.codigo)?0:(codigo<n.codigo)?-1:1;
   }
}