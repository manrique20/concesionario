/*
 * @(#)Main.java  17.0.6 27/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package LibraryMain;

import Archives.PublicationsImplementation.*;
import Archives.PublicationsImplementation.Revista.Periodicidad;
import BibliotecaImplementation.LibraryUMNG;
import LibraryMain.LibraryMainImplementation.UMNGLibraryFrame;
import actividad2.ejercicio1.Customs.SafeInput;
 

/**
 * 
      Clase de utilidad cuya finalidad es la de probar, hasta cierto
      punto, la implementacion de {@link Libro}, {@link Revista},
      {@link Sala}, {@link LibraryUMNG}, y los GUIs provistos en
      {@link UMNGLibraryFrame}.
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class MainTest {

    /**  
       Objeto de prueba. */
    static private LibraryUMNG libraryUMNG = new LibraryUMNG();

    /**  
       Objeto de prueba. */
    static private UMNGLibraryFrame libraryFrame;

    public static void main(String[] args){
            libraryFrame = new UMNGLibraryFrame(libraryUMNG);
            TrialFill();
            label: while(true) 
            {
                if (
                    SafeInput.getSafeChar("Insertar publicación (responde y si ese es el caso): ")
                    =='y'
                ) insertPublication(SafeInput.getSafeInt("¿Quieres ingresar un libro o una revista? (0 es libro y 1 es revista)"
                +"\nRespuesta: "));
                else continue label;
            }
    }

    /**
     * Método estático que permite insertar publicaciones a
       {@code libraryUMNG}. 
       @param chooser ¿qué se quiere insertar?.
       @return void*/
    public static void insertPublication(int chooser){

       switch(chooser) {
            case 0: {
                    libraryFrame.setEnabled(false);
                    System.out.println("Ingrese los datos del libro:");
                    libraryUMNG.insertPublication(
                        new Libro(
                        SafeInput.getSafeString("\tTítulo: "), 
                        getPositiveSafeInteger("\tAño de publicacion: "),
                        getPositiveSafeInteger("\tCódigo: "), 
                        Libro.getInstanceAutor(
                            SafeInput.getSafeString("\tAutor: "),
                            Libro.getInstancePais(
                                SafeInput.getSafeString("\tPais de origen del autor: "),
                                getPositiveSafeInteger("\tCódigo estatal: ")
                            )
                        ) 
                        )
                    );
                    libraryFrame.setEnabled(true);
                    System.out.println("El libro ha sido insertado");
                    return;
            }

            case 1: {
                libraryFrame.setEnabled(false);
                Revista.Periodicidad m = Periodicidad.MENSUAL;
                switch(SafeInput.getSafeString("Las periodicidades de las revistas son: "
                +"\nDiario;\nSemanario;\nQuincenal;\nMensual;\nBimestral;"
                +"\nCuatrimestral;\nTrimestral;\nSemestral;\nAnual;\nBienario."
                +"\n¿Qué periodicidad tiene tu revista?").strip().toUpperCase())
                {
                   case "DIARO": m = Periodicidad.ANUAL;break;
                   case "SEMANARIO": m = Periodicidad.SEMANARIO;break;
                   case "QUINCENAL": m = Periodicidad.QUINCENAL;break;
                   case "MENSUAL": m = Periodicidad.MENSUAL;break;
                   case "BIMESTRAL": m = Periodicidad.BIMESTRAL;break;
                   case "CUATRIMESTRAL": m = Periodicidad.CUATRIMESTRAL;break;
                   case "TRIMESTRAL": m = Periodicidad.TRIMESTRAL;break;
                   case "SEMESTRAL": m = Periodicidad.SEMESTRAL;break;
                   case "ANUAL": m = Periodicidad.ANUAL;break;
                   case "BIENARIO": m = Periodicidad.BIENARIO;break;
                   default: System.out.println("Se supone que se tiene una "
                   +"periodicidad mensual.");break;
                }

                libraryUMNG.insertPublication(
                    new Revista (
                        SafeInput.getSafeString("\tTítulo: "),
                        getPositiveSafeInteger("\tAño de publicación: "),
                        getPositiveSafeInteger("\tNúmero: "),
                        getPositiveSafeInteger("\tCódigo: "),
                        m
                    )
                );
                libraryFrame.setEnabled(true);
                System.out.println("La revista ha sido insertada");
                return;
            }
            default: return;
        }
    }

    /**
     * Método estático que permite conseguir un integro
       positivo de forma segura. 
       @param m mensaje que se quiere imprimir
       @return integro positivo*/
    private static int getPositiveSafeInteger(String m){
        int o;
        while((o = SafeInput.getSafeInt(m))<0){
            System.out.println("\tCannot insert negative values");
        }
        return o;
    }

    /**
     * Método estático que llenar a {@code libraryUMNG} con unas
       cuantas publicaciones de prubea
       @return void*/
    private static void TrialFill(){ 

        var x = Libro.getInstanceAutor( "Arthur", Libro.getInstancePais("England", 89122));
        var y = Libro.getInstanceAutor("Karl Mädchen", Libro.getInstancePais("Netherlands", 3811));

        libraryUMNG.insertPublication(new Libro("New Found Land", 1933, 83981, x));
        libraryUMNG.insertPublication(new Revista("Novedad en Reproducción", 1733, 12, 3712311, Revista.Periodicidad.TRIMESTRAL));
        libraryUMNG.insertPublication(new Libro("The old world", 2018, 471221, y));
        libraryUMNG.insertPublication(new Revista("Research X", 2008, 28, 738123, Revista.Periodicidad.BIENARIO));
    }
}