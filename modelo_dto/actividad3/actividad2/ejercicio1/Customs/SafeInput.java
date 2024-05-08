/*
 * @(#)SafeInput.java     17.0.6  24/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

 
package actividad2.ejercicio1.Customs;

import java.util.Scanner; 

/**
 *  
        Clase final de utilidad cuyo propósito es el
        de ofrecer funcionalidades generales para manejar 
        input de manera segura. 
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public final class SafeInput {

    /**  
    Miembro estático que utiliza la clase {@code SafeInput} para manejar input.*/
    static private Scanner reader;

    /**
     * Permite obtener un integro de forma segura del usuario. 
        @return integro ingresado por el usuario. */
    static public int getSafeInt(){
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextInt();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un integro de forma segura del usuario
       mientras se imprime un mensaje {@code b}. 
       @param  b cadena que se quiere imprimir.
       @return integro ingresado por el usuario. */
    static public int getSafeInt(String b){
        System.out.print(b);
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextInt();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }
    
    /**
     * Permite obtener un double de forma segura del usuario. 
        @return double ingresado por el usuario. */
    static public double getSafeDouble(){
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextDouble();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un double de forma segura del usuario
       mientras se imprime un mensaje {@code b}. 
       @param  b cadena que se quiere imprimir.
       @return double ingresado por el usuario. */
    static public double getSafeDouble(String b){
        System.out.print(b);
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextDouble();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un cadena de forma segura del usuario. 
        @return cadena ingresada por el usuario. */
    static public String getSafeString(){
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextLine();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un cadena de forma segura del usuario
       mientras se imprime un mensaje {@code b}.
       @param b mensaje que se quiere imprimir.
       @return cadena ingresada por el usuario. */
    static public String getSafeString(String b){
        System.out.print(b);
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextLine();
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un char de forma segura del usuario. 
        @return char ingresada por el usuario. */
    static public char getSafeChar(){
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextLine().charAt(0);
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }

    /**
     * Permite obtener un char de forma segura del usuario
       mientras se imprime un mensaje {@code b}.
       @param b mensaje que se quiere imprimir.
       @return char ingresada por el usuario. */
    static public char getSafeChar(String b){
        System.out.print(b);
        do{
            try{
                reader = new Scanner(System.in);
                return reader.nextLine().charAt(0);
            }catch(Throwable e){
                System.out.print("\n\tWrong input!\n\tTry again: ");
            }
        }while(true);
    }
}