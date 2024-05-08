/*
 * @(#)Sala.java  17.0.6 22/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package BibliotecaImplementation;

import java.util.ArrayList;
import java.util.function.Predicate;

import actividad2.ejercicio1.Customs.Codigo;

/**
 * 
       Clase genérica cuya intención es la de
       simular las salas dentro de una biblioteca,
       o cualquier sitio que requiera la organización
       de instancias de clases derivadas de {@link Codigo}.
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class Sala<T extends Codigo>{

    /**  
        ArrayList que contendra los objetos. */
    private ArrayList<T> inventario = new ArrayList<>();

    /**
      * Método que permite insertar elementos a
        {@code inventario}.
        @param m elemento a insertar.   
        @return void. */
    public void insertElement(T m){
        inventario.add(m); 
        inventario.sort(null);
    }

    /**
      * Método que permite buscar un elemento en específico
        a partir de su código. 
        {@code inventario}.
        @param codigo del elemento que se quiere encontrar.   
        @return el elemento buscado, o {@code null}
        si el elemento no se encuentra. */
    public T getElement(int codigo){
        int L = 0, R = inventario.size()-1, m;
        label: while(L<=R){
            m = (L+R)/2;
            if(inventario.get(m).getCodigo() == codigo) return inventario.get(m);
            if (inventario.get(m).getCodigo()<codigo) {
                L = m+1;
                continue label;
            }
            if (inventario.get(m).getCodigo()>codigo){
                R = m-1;
                continue label;
            }
        }
        return null;
    }
    
    /**
     * Método para obtener un ArrayList compuesto de 
       los elementos que cumplan con la especificación 
       dada en: 
       @param specifier condición que deben cumplir los 
       elementos.      
       @return {@code ArrayList} de los elementos que
       cumplen con {@code specifier}.*/
    public ArrayList<T> getList(Predicate<T> specifier){
        ArrayList<T> temp_holder = new ArrayList<>(1);
        inventario.forEach(
            p->{
                if (specifier.test(p)) temp_holder.add(p);
            }
        );
        return temp_holder;
    }
}