/*
 * @(#)Publication.java     17.0.6  21/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

package Archives.ArchivesCustoms;

import java.util.InputMismatchException;

import actividad2.ejercicio1.Customs.Codigo;

/**
 * 
       Publication es una extensión de la clase 
       {@link Codigo} cuya finalidad es la
       de simular las propiedades generales 
       de una publicación cualquiera. 
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public abstract class Publication extends Codigo {

    /**  
        Año de publicación. */
    protected int yearOfPublication;

    /**  
        Título de la publicación. */
    protected String titulo;

    /**
     *  Sets {@code titulo, yearOfPublication, and codigo}.
          @param titulo título de la publicación     
          @param yearOfPublication año de publicación
          @param codigo código de identificación de la publicación
          @throws InputMismatchException cuando se insertan
          valores negativos para {@code yearOfPublication} y
          {@code código}*/ 
    public Publication(String titulo, int yearOfPublication, int codigo){
        if (yearOfPublication < 0
        ||codigo <0) 
        throw new InputMismatchException("Numbers below 0 are not allowed!");
        this.yearOfPublication = yearOfPublication;
        this.titulo = titulo.strip();
        this.codigo = codigo;
    }

    /**
     * Método get de {@code yearOfPublication}. 
       @return año de publicación del objeto*/
    public int getYearOfPublication(){
        return yearOfPublication;
    }

    /**
     * Método get de {@code titulo}. 
       @return título de la publicación.*/
    public String getTitulo(){
        return titulo;
    }

    @Override
    public String toString(){
        return "Título: "+titulo+" | Código: "+codigo;
    }
}