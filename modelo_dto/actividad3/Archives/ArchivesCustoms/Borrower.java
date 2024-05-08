/*
 * @(#)Borrower.java     17.0.6  15/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package Archives.ArchivesCustoms;

/**
 *  
      Interface cuyo fin es la de permitir la
      implementación de comportamientos que simulan
      la capacidad de ciertos objetos de prestarse
      o devolverse:
      <li> {@code void borrow();}
      <li> {@code void giveBack();}
      <li> {@code Boolean checkIfBorrowed().}
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public interface Borrower {

    /**
     * Objetos que implementan este método tienen la capacidad de 
      ser prestados por cierto periodo {@code n}.
      @param n tiempo prestado.      
      @return void. */
    void borrow(int n);

    /**
     * Objetos que implementan este
       método tienen la capacidad de 
       ser devueltos.       
      @return void. */
    void giveBack();

    /**
     * Objetos que implementan este
       método verifican si están prestados
       o no (varía según la implementación).     
      @return {@code true} si están prestados;
      {@code false} otherwise*/
    Boolean checkIfBorrowed();
}