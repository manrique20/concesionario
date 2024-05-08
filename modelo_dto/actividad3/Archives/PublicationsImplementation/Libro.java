/*
 * @(#)Libro.java  17.0.6 21/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package Archives.PublicationsImplementation;

import Archives.ArchivesCustoms.*;
import actividad2.ejercicio1.Customs.Codigo;
import java.util.Date;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
        Clase hija de {@link Publication} e implementadora
        de la interfaze {@link Borrower}, esta posee el
        propósito de simular e implementar los comportamientos
        y propiedades de libros que pueden ser prestados 
        y/o devueltos dentro de una biblioteca.
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class Libro extends Publication implements Borrower{

    /**
     * 
        Clase que simula a un autor
        que posee un {@code paisOrigen}. 
     * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
    public static class Autor{   

        /**
         * 
            Clase hija de {@link Publication} cuyo 
            propósito es el de simular a un país que posee
            un código estatal. 
         * @version     
            17.0.6 06 Jan 2023  @author          
            Jorge Celis  */
        public static class PaisOrigen extends Codigo{

            /**  
                Nombre del objeto de tipo {@code PaisOrigen}. */
            private String nombrePais;

            /**
             * Sets {@code nombrePais} and {@code codigo}.      
                @param nombrePais nombre del país
                @param codigo código estatal del país 
                @throws InputMismatchException cuando se ingresan
                valores negativos.*/
            private PaisOrigen(String nombrePais, int codigo){
                if (codigo < 0) throw new InputMismatchException("Numbers below zero are not allowed");
                this.nombrePais = nombrePais.strip();
                this.codigo = codigo;
            }

            /**
             * Método get para {@code nombrePais}.   
               @return el nombre del país.*/
            public String getNombrePais(){
                return nombrePais;
            }
        }

        /**  
            Pais origen del autor.*/
        private PaisOrigen paisOrigen;

        /**  
            Nombre del autor.*/
        private String nombreAutor;

        /**
         * Sets {@code nombreAutor} and {@code paisOrigen}.      
           @param nombreAutor nombre del autor.
           @param paisOrigen país origen del autor. */
        private Autor(String nombreAutor, PaisOrigen paisOrigen){
            this.paisOrigen = paisOrigen;
            this.nombreAutor = nombreAutor.strip();
        }

        /**
         * Permite obtener el nombre del autor.     
           @return {@code nombreAutor}. */
        public String getNombreAutor(){
            return nombreAutor;
        }

        /**
         * Permite obtener el país origen
           del autor.     
           @return {@code paisOrigen}. */
        public PaisOrigen getPaisOrigen(){
            return paisOrigen;
        }
    }

    /**  
        Autor del libro. */
    private Autor autor;

    /**  
       Fecha de prestamo del libro si es que se presta. */
    private Calendar fechaPrestamo;
    
    /**  
       Guarda el estado del libro (si está prestado o no). */
    private Boolean estadoPrestado = false;

    /**  
      Temporizador que permite avisar al administrador que un 
      libro aún no ha sido devuelto.*/
    private Timer timer;

    /**
     * Sets {@code titulo}, {@code yearOfPublication},
       {@code codigo}, and {@code Autor}.     
       @param titulo título de la publicación.
       @param yearOfPublication año de publicación.
       @param codigo código de identificación del libro.
       @param Autor del libro.  */
    public Libro(String titulo, int yearOfPublication, int codigo, Autor autor){
        super(titulo, yearOfPublication, codigo);
        this.autor = autor;
    }

    
    /**
     * Método estático que permite obtener instancias
       de {@link PaisOrigen}.      
        @param nombrePais nombre del país.
        @param codigo código estatal del país. 
        @return una instancia de {@code PaisOrigen}.
        @throws InputMismatchException cuando se ingresan
        valores negativos.*/
    public static Autor.PaisOrigen getInstancePais(String nombrePais, int codigo){
        return new Autor.PaisOrigen(nombrePais, codigo);
    }
    
    /**
     * Método estático que permite obtener instancias
       de {@link Autor}.      
        @param nombreAutor nombre del autor.
        @param paisOrigen país origen del autor. 
        @return una instancia de {@code Autor}. */
    public static Autor getInstanceAutor(String nombreAutor, Autor.PaisOrigen paisOrigen){
        return new Autor(nombreAutor, paisOrigen);
    }

    /**
     * Método get para obtener el obejto de tipo {@code Date} 
       de {@code fechaPrestamo}.     
       @return {@code fechaPrestamo.getTime()}, o {@code null} si 
       {@code estadoPrestado == false}. */
    public Date getFechaPrestamo(){
        return (estadoPrestado)?fechaPrestamo.getTime():null;
    }

    /**
     * Método get para obtener el objeto de tipo {@code Date}
       del útlimo registro de {@code fechaPrestamo}.     
       @return {@code fechaPrestamo.getTime()}, o null si
       {@code estadoPrestado == true} */
    public Date getUltimaFechaPrestamo(){
        return (!estadoPrestado)?fechaPrestamo.getTime():null;
    }

    /**
     * Método get para obtener {@code autor}.     
       @return {@code Autor}.*/
    public Autor getAutor(){
        return autor;
    }

  

    /**
      * Este es un método privado que permite set
        {@code timer} para agendarlo a una fecha establecida por el 
        usuario con el fin de avisarle al administrador, una vez esa
        fecha se cumpla y no se haya devuelto aún el libro, que 
        el susodicho se encuentra en el estado sobreentendido. 
        <li> Note: cuando salga el aviso, el administrador puede elegir
        en decirle al programa que le avise una vez más unos cuántos días
        después, o que simplemente no le recuerde de nuevo. 
        @param x libro que se presto.
        @param n cantidad de días por los que se va ha prestar el 
        libro.    
        @return void. */
    private void verifier(int n){

        Calendar tracker = Calendar.getInstance();
        tracker.add(Calendar.DAY_OF_MONTH, n);

        timer = new Timer();
        timer.schedule(
            new TimerTask() {
                @Override
                public void run(){
                    JOptionPane.showMessageDialog(null, "El libro con título "
                    +titulo+" y código "+codigo+" aún no ha sido devuelto");

                    JFrame dialog = new JFrame();
                    dialog.setIconImage(new ImageIcon("actividad3/Images/admiracion.png").getImage());
                    dialog.setVisible(true);
                    dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    dialog.setLayout(new FlowLayout());
                    dialog.setResizable(false);

                    JTextArea message = new JTextArea("¿Cuándo quieres que te avisemos de nuevo?");
                    message.setEditable(false);

                    dialog.add(message);

                    JComboBox<String> chooserExtender = new JComboBox<>(
                        new String[]{"1 día", "2 días", "3 días", "0 días"}
                    );

                    chooserExtender.addActionListener(
                        p->{
                            switch(chooserExtender.getSelectedIndex()){
                                case 0: {
                                    dialog.dispose();
                                    timer.cancel();
                                    verifier(1);
                                    return;
                                }
                                case 1: {
                                    dialog.dispose();
                                    timer.cancel();
                                    verifier(2);
                                    return;
                                }
                                case 2:{
                                    dialog.dispose();
                                    timer.cancel();
                                    verifier(3);
                                    return;
                                }
                                case 3: {
                                    timer.cancel();
                                    dialog.dispose();
                                    return;
                                }
                            }
                        }
                    );
                    dialog.add(chooserExtender);
                    dialog.pack();
                }
            },
            tracker.getTime()
        );
    }

    @Override
    public void borrow(int n){
        estadoPrestado = true;
        fechaPrestamo = Calendar.getInstance();
        verifier(n);
    }

    @Override
    public void giveBack(){
        estadoPrestado = false;
        timer.cancel();
    }    
    
    @Override
    public Boolean checkIfBorrowed(){
        return estadoPrestado;
    }
}