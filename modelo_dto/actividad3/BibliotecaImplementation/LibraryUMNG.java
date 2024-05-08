/*
 * @(#)LibraryUMNG.java  17.0.6 22/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package BibliotecaImplementation;

import Archives.PublicationsImplementation.*;
import java.util.ArrayList;

/**
 * 
       Clase que simula el comportamiento de la 
       biblioteca de la Universidad Militar Nueva
       Granada. 
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class LibraryUMNG {

    /**  
        Sala de la biblioteca encargada de los libros.*/
    private Sala<Libro> salaLibros = new Sala<>();

    /**  
        Sala de la biblioteca encarga de las revistas.*/
    private Sala<Revista> salaRevistas = new Sala<>();

    /**
      * Método que permite insertar elementos de tipo revista 
        al componente {@code salaRevistas}.
        @param m revista que se quiere insertar.   
        @return void. */
    public void insertPublication(Revista m){
        salaRevistas.insertElement(m);
    }

    /**
      * Método que permite insertar elementos de tipo libro 
        al componente {@code salaLibros}.
        @param m libro que se quiere insertar.   
        @return void. */
    public void insertPublication(Libro m){
        salaLibros.insertElement(m);
    } 

    /**
      * Método que permite obtener el elemento de tipo {@link Libro} 
        cuyo código equivalga al parámetro:
        @param codigo del libro que se quiere obtener.   
        @return el libro que se quiere encontrar, o {@code null}
        si ese no es el caso. */
    public Libro getLibro(int codigo){
        return salaLibros.getElement(codigo);
    }

    /**
      * Método que permite obtener el elemento de tipo {@link Revista} 
        cuyo código equivalga al parámetro:
        @param codigo de la revista que se quiere obtener.   
        @return la revista que se quiere encontrar, o {@code null}
        si ese no es el caso. */
    public Revista getRevista(int codigo){
        return salaRevistas.getElement(codigo);
    }

    /**
      * Retorna una representación semi-default de: 
        @param x revista que se quiere representar.   
        @return representación semi-default de {@code x}. */
    public String getDefaultRepresentation(Revista x){
        return "La revista con título "+x.getTitulo()
        +" y código "+x.getCodigo()+" tiene: "
        +"\nNúmero: "+x.getNumero()
        +"\nPeriodicidad: "+x.getPeriodicidad()
        +"\nAño de publicación: "+x.getYearOfPublication()
        +".";
    }

    /**
      * Retorna una representación semi-default de: 
        @param x el libro que se quiere representar.   
        @return representación semi-default de {@code x}. */
    public String getDefaultRepresentation(Libro x){
        return "El libro con título "+x.getTitulo()
        +" y código "+x.getCodigo()+" tiene:"
        +"\nAutor: "+x.getAutor().getNombreAutor()
        +"\n\t-> País de origen del autor: "
        +x.getAutor().getPaisOrigen().getNombrePais()
        +";\n\t-> Código estatal: "+x.getAutor().getPaisOrigen().getCodigo()
        +";\nAño de publicación: "+x.getYearOfPublication()
        +((x.checkIfBorrowed())?
        ";\nFecha de prestamo: "+x.getFechaPrestamo()
        :".");
    }

    /**
      * Permite obtener un catálogo de los libros que no se 
        encuentran prestados. 
        @return ArrayList compuesto de los libros que no se
        encuentran prestados. */
    public ArrayList<Libro> getCatalogoLibrosNoPrestados(){
        return salaLibros.getList(p->!p.checkIfBorrowed());
    }

    /**
      * Permite obtener un catálogo de los libros que se 
        encuentran prestados. 
        @return ArrayList compuesto de los libros que se
        encuentran prestados. */
    public ArrayList<Libro> getCatalogoLibrosPrestados(){
        return salaLibros.getList(p->p.checkIfBorrowed());
    }

    /**
      * Permite obtener un catálogo de las revistas.
        @return ArrayList compuesto de las revistas. */
    public ArrayList<Revista> getCatalogoRevistas(){
        return salaRevistas.getList(p->true);
    }
}