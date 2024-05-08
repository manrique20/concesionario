/*
 * @(#)LibrosFrame.java  17.0.6 23/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package LibraryMain.LibraryMainImplementation;

import Archives.PublicationsImplementation.Libro;
import BibliotecaImplementation.LibraryUMNG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 
       Clase hija de {@link JFrame} e implementadora de 
       {@link ActionListener} cuyo propósito es el 
       de proporcionar un GUI que permita al usuario acceder, 
       pedir prestado, corrobar, e inclusive consultar acerca 
       de los libros de la biblioteca de la UMNG. 
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
class LibrosFrame extends JFrame implements ActionListener{

    /**  
       Referencia a una instancia de {@link LibraryUMNG}. */
    private LibraryUMNG libraryUMNG;

    /**  
       Referencia al GUI {@link UMNGLibraryFrame} que ha
       de "contener" a {@code LibrosFrame} */
    private UMNGLibraryFrame parent;

    /**  
       JFrame que se usará para crear un GUI del
       catálogo de libros prestados o el catálogo 
       de libros no prestados según sea el caso. */
    private JFrame frame;

    /**  
       JButton que se usará para crear un botón que el 
       usuario puede oprimir si quiere ver el 
       catálogo de libros prestados. */
    private JButton librosPrestados = new JButton("Libros prestados");

    /**  
       JButton que se usará para crear un botón que el 
       usuario puede oprimir si quiere ver el 
       catálogo de libros no prestados. */
    private JButton librosNoPrestados = new JButton("Libros no prestados");

    /**
      * Constructor de LibrosFrame. Con este se planea
        crear un JFrame interactivo visible de 250X150 
        para que el usuario pueda acceder al catálogo de libros prestados
        y al catálogo de libros no prestados. 
        <li> Note: una vez creado, el {@code parent} habrá de ser desactivado
        hasta que termine el life-cycle de {@code this}.
        @param libraryUMNG referencia a {@code this.libraryUMNG}
        @param parent referencia al contenedor GUI {@code this.parent} */
    public LibrosFrame(LibraryUMNG libraryUMNG, UMNGLibraryFrame parent){

        this.parent = parent;
        this.libraryUMNG = libraryUMNG;

        //Establecemos las propiedades del Frame.
        this.setTitle("Libros");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250,150);
        this.setVisible(true);
        this.setLayout(new FlowLayout()); 
        this.setIconImage(new ImageIcon("actividad3/Images/Lupa.png").getImage());
        this.setResizable(false);

        //Integramos un WindowListener para reactivar parent.
        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent){
                    parent.setEnabled(true);
                }
            }
        );

        /*
        En ambos bótones se agrega el ActionListener
        de este contenedor. 
        */
        librosPrestados.addActionListener(this);
        librosNoPrestados.addActionListener(this);

        this.add(librosPrestados);
        this.add(librosNoPrestados); 
        this.pack();
    }

    /**
     * Permite crear un JFrame visible de 350x75. Una vez creado, 
       {@code this.setEnabled(false)}. Por supuesto, una vez cerrado,
       {@code this.setEnabled(true)}. 
       <li> Este posee como ícono un rayo. 
        @param m título del JFrame. 
        @param s cuál array se usara para la creación del {@link JComboBox}.
        @return void */
    private void createBaseSkeletonFrame(String m, Libro[] s, Boolean closer){

        this.setEnabled(false);

        frame = new JFrame(m);
        frame.setVisible(true);
        frame.setSize(350,75);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("actividad3/Images/rayo.png").getImage());
        frame.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent windowEvent){
                    setEnabled(true);
                }
            }
        );
        
        /*
         Creamos un JComboBox para colectar los datos contenidos en 
         s y así dejarlos en un drop_down list al cual pueden acceder
         los usuarios.
        */
        JComboBox<Libro> comboBox = new JComboBox<>(s);
        comboBox.addActionListener(
            p->{
                int index = comboBox.getSelectedIndex();
                parent.showFrame(s[index], frame, closer);
            }      
        );

        frame.add(comboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == librosNoPrestados){

           this.createBaseSkeletonFrame
           (
                "Libros no prestados",
                libraryUMNG.getCatalogoLibrosNoPrestados().toArray
                (
                    libraryUMNG.getCatalogoLibrosNoPrestados().toArray
                    (
                        new Libro[libraryUMNG.getCatalogoLibrosNoPrestados().size()]
                    )
                ),
                true
           );
           return;
        }

        if (e.getSource() == librosPrestados){
            
            this.createBaseSkeletonFrame
            (
                "Libros prestados",
                libraryUMNG.getCatalogoLibrosPrestados().toArray
                (
                    new Libro[libraryUMNG.getCatalogoLibrosPrestados().size()]
                ) 
                ,false
            );
            return;
        }
    }
}