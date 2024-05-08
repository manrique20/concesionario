/*
 * @(#)Shop.java     17.0.6  28/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package actividad2.ejercicio1.Customs;

import java.util.Arrays;
import java.util.function.*;
import javax.lang.model.type.NullType;

/**
 *  
        Clase génerica cuya funcionalidad es la de dar la
        posibilidad de crear instancias que se deben implementenar
        compositivamente para la simulación del comportamiento de
        tiendas que poseen la cualidad de tener inventarios
        binarios (solo existen dos tipos de mercancía).

        <li> Su dominio de acción es para subclasses de {@link Codigo}.
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public class Shop <T extends Codigo> {

    /**  
    Indice que determina hasta que posición se da la sección
    del primer tipo de mercancías.*/
    private int index;

    /**  
    Arreglo estático que almacena las mercancías en cuestión.*/
    private T[] inventario;

    /**
     * Permite inicializar (set) el {@code index}.     
        @param index
        @return void. */
    public void setIndex(int index){
        while(index>inventario.length || index<0){
            index=SafeInput.getSafeInt("¡Error!\nIntentelo de nuevo: ");
        }
        this.index=index;
    }

    /**
     * Permite obtener {@code index}.     
        @return integro, que es {@code index} */
    public int getIndex(){
        return index;
    }

    /**
     * Permite buscar una mercancía en específico según el
       código de esta.     
        @param codigo integro de identificación de la mercancía.
        @return void. */
    public void search(int codigo){
        var checker1 = new Object(){boolean ordinal=false;};
        var checker2 = new Object(){boolean ordinal=false;};
        Thread m1 = new Thread(
            ()->{
                var x=Arrays.copyOfRange(inventario, 0, index);
                Arrays.sort(x);
                int L=0, R=x.length-1, m;
                label: while(L<=R){
                    m=(L+R)/2;
                    if (x[m].codigo<codigo){
                        L=m+1;
                        continue label;
                    } 
                    if (x[m].codigo>codigo){
                        R=m-1;
                        continue label;
                    } 
                    System.out.println("Elemento buscado-> "
                    +x[m]);
                    return;
                }
                checker2.ordinal=true;
            }
        ),
        m2 = new Thread(
            ()->{
                var x=Arrays.copyOfRange(inventario, index, inventario.length);
                Arrays.sort(x);
                int L=0, R=x.length-1, m;
                label: while(L<=R){
                    m=(L+R)/2;
                    if (x[m].codigo<codigo){
                        L=m+1;
                        continue label;
                    } 
                    if (x[m].codigo>codigo){
                        R=m-1;
                        continue label;
                    } 
                    System.out.println("Elemento buscado-> "
                    +x[m]);
                    return;
                }
                checker1.ordinal=true;
                try {
                    m1.join();
                } catch (InterruptedException e) {
                }
                if (checker1.ordinal && checker2.ordinal){
                    System.out.println("Element not found!");
                    return;
                }
            }
        );
        m1.start();m2.start();
    }

    /**
     * Permite inicializar el tamaño del inventario.   
        @param m interfaze funcional que debe pasar lambdas 
        para sobreescribir según el tipo de mercancías. 
        @param n integro que determinará el tamaño del {@code inventario}.
        @return void. */
    public void setSizeInventario(Function<Integer, T[]> m, int n){
        inventario = m.apply(n);
    };

    /**
     * Permite inicializar elementos de {@code inventario}.   
        @param probe interfaze funcional que debe pasar lambdas para 
        simular sobreescritura. 
        @param m elemento a ingresar. 
        @param i indice en donde se quiere ingresar el elemnto.
        @return void. */
    public void setElementsInventario(Function<NullType, Boolean> probe, T m, int i){
        if (i>=inventario.length || m==null){
            System.out.println("Either you wrote off bounds or you inserted a null object!");
            return;
        }
        if(probe.apply(null)){
            return;
        }
        if (inventario[i]!=null){
            if (SafeInput.getSafeChar("Ya existe un elemento en esta posición"
            +"\n¿Seguro quiere cambiar sus propiedades? (respsonda 'y' si ese es el caso)")=='y'){
                inventario[i]=m;
                return;
            }
            return; 
        }
        inventario[i]=m;
    }

    /**
     * Permite obtener {@code inventario}.     
        @return {@code inventario}*/
    public T[] getInventario(){
        return inventario;
    }

    /**
     * Permite obtener el catálogo de los elementos
       según su tipaje (antes o después de {@code index}).
       @param tester integro que determina que catálogo se
        quiere ver (0 es después de {@code index}, 1 es antes,
        y cualquier otro lanza un mensaje).
       @return void*/
    public void getCatalogo(int tester){
        switch(tester){
            case 0: {
                for (int i=index; i<inventario.length; i++){
                    System.out.println((i-index+1)+". "+inventario[i]
                    +".\n");
                }
                return; 
            }
            case 1: {
                for (int i=0; i<index; i++){
                    System.out.println(i+". "+inventario[i]
                    +".\n");
                }
            }
            default:{
                System.out.println("Creo que no quieres ver el inventario");
                return;
            }
        }
    }
}