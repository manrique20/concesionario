/*
 * @(#)Revista.java  17.0.6 21/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package Archives.PublicationsImplementation;

import Archives.ArchivesCustoms.Publication;
import java.util.InputMismatchException;

/**
 * 
        Clase hija de {@link Publication}, esta posee
        el propósito de simular revistas. 
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class Revista extends Publication {

    /**
     * 
       Clase enum empleada para establecer 
       periodicidades estándar (al menos 
       periodicidades académicas). 
     * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
    public static enum Periodicidad {

        DIARIO("Diario"),
        SEMANARIO("Semanario"),
        QUINCENAL("Quincenal"),
        MENSUAL("Mensual"),
        BIMESTRAL("Bimestral"),
        CUATRIMESTRAL("Cuatrimestral"),
        TRIMESTRAL("Trimestral"),
        SEMESTRAL("Semestral"),
        ANUAL("Anual"),
        BIENARIO("Bienario");

        /**  
        Cadena que representa cada enum type. */
        private String periodicidad;

        /**
         * Sets {@code periodicidad}.      
           @param periodicidad */
        private Periodicidad(String periodicidad){
            this.periodicidad = periodicidad;
        }

        @Override
        public String toString(){
            return periodicidad;
        }
    }

    /**  
       Número de la revista. */
    private int numero;

    /**  
       Periodicidad de la revista. */
    private Periodicidad periodicidad;

    /**
     * Sets {@code titulo}, {@code yearOfPublication}, 
       {@code numero}, {@code codigo}, and {@code periodicidad}.     
       @param titulo título de la publicación.
       @param yearOfPublication año de publicación.
       @param numero numero de la revista.
       @param codigo código de identificación de la revista. 
       @param periodicidad periodicidad de la revista. */
    public Revista(String titulo, int yearOfPublication, 
    int numero, int codigo, Periodicidad periodicidad){
        super(titulo, yearOfPublication, codigo);
        if (numero < 0) throw new InputMismatchException("Numbers below zero are not allowed!");
        this.numero = numero;
        this.periodicidad = periodicidad; 
    }

    /**
     * Método get para obtener el {@code numero}
       de la revista.      
       @return {@code numero}. */
    public int getNumero(){
        return numero;
    }

    /**
     * Método get para obtener la {@code periodicidad}
       de la revista.      
       @return {@code periodicidad}. */
    public Periodicidad getPeriodicidad(){
        return periodicidad;
    }
}