/*
 * @(#)UMNGLibraryFrame.java     17.0.6  24/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
*/


package LibraryMain.LibraryMainImplementation;

import Archives.ArchivesCustoms.CustomTextField;
import Archives.PublicationsImplementation.*;
import BibliotecaImplementation.LibraryUMNG;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 
       Clase hija de {@link JFrame} cuyo propósito es el 
       de proporcionar un GUI que permita al usuario interactuar
       con los contenidos de instancias de {@link LibraryUMNG}
       al crear el ambiente adecuado para pedir prestados libros,
       devolver libros, revisar revistas, y buscar una publicación 
       en específico por medio del código de esta. 
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class UMNGLibraryFrame extends JFrame {

    /**  
       Referencia a una instancia de {@link LibraryUMNG}. */
    private LibraryUMNG libraryUMNG;

    /**  
       JButton que se usará para crear un botón a través
       el cual el usuario puede devolver el libro prestado. */
    private JButton submit = new JButton("Submit");

    /**  
       Organizador {@link FlowLayout} que se usará como el
       Layout común de la mayoría de GUIS utilizadas en esta
       clase.*/
    private FlowLayout organizer = new FlowLayout();

    /**  
       Elemento utilizado con el fin de conseguir input tipo
       {@link Integer} positivo para la búsqueda de una 
       publicación en específico.*/
    private CustomTextField searchPublication = new CustomTextField("Código de la publicación buscada");

    /**  
       Elemento utilizado con el fin de conseguir input tipo
       {@link Integer} positivo para hacer la devolución de una
       publicación en específico.*/
    private CustomTextField giveBackPublication = new CustomTextField("Código del libro a devolver");

    /**  
       Permite al usuario seleccionar qué tipo de publicación quiere
       encontrar.*/
    private JComboBox<String> selectorSearch = new JComboBox<>(new String[]{"Libro", "Revista"});

    /**  
       Default logo of any {@link UMNGLibraryFrame} object.*/
    private ImageIcon logoUMNG = new ImageIcon("actividad3/Images/logo.png");

    /**  
       Barra menú que ayudara a proporcionar al usuario con una selección
       de búsqueda viendo el catálogo ya sea de libros o de revistas.*/
    private JMenuBar menuBar = new JMenuBar();

    /**  
       Opción de menú que permite el acceso a los catálogos.*/
    private JMenu catalogos = new JMenu("Catálogos");

    /**  
       Item menú que permite el acceso a los catálogos de libros.*/
    private JMenuItem libros = new JMenuItem("Libros");

    /**  
       Item menú que permite el acceso al catálogo de revistas.*/
    private JMenuItem revistas = new JMenuItem("Revistas");

    /**  
       Dominio en el que se insertarán los elementos concernientes a 
       la búsqueda de publicaciones.*/
    private JPanel searchPublicationDominion = new JPanel();

    /**  
       Dominio en el que se insertarán los elementos concernientes a 
       la devolución de libros prestados.*/
    private JPanel devolverPublicationDominion = new JPanel();

    /**  
      Elemento lambda {@link Consumer} utilizado precisamente 
      en esta clase para preguntarle al usuario por cuántos días
      va a pedir prestado un libro (máximo 7 días).*/
    public final Consumer<Libro> BORROWERSETTER = p->{
        label: while (true){
            try{
                String m = JOptionPane.showInputDialog(null, "¿Por cuántos días?");
                if(m == null) return;
                int n = Integer.parseInt(m);
                while(n>7 || n<0){
                    JOptionPane.showMessageDialog(null, "¡Máximo se puede prestar 7 días!");
                    if ((m = JOptionPane.showInputDialog(null, "¿Por cuántos días?")) == null) return;
                    n = Integer.parseInt(m);
                }
                p.borrow(n);
                return;
            }catch(NumberFormatException e){
                if (JOptionPane.showConfirmDialog(null, "Wrong input!\nDo you want to try it again?")
                == 0) continue label;
                else {
                    p.giveBack();
                    return;
                }
            }
        }
    };

    /**  
      Elemento lambda {@link Consumer} utilizado precisamente 
      en esta clase para avisarle al usuario si quiere devolver el
      libro que solicitó prestado, o para avisarle que aquello que va
      a devolver o no existe o no ha sido prestado aún.  */
    public final Consumer<Libro> GIVEBACKSETTER = p->{

        if (p == null){
            JOptionPane.showMessageDialog(null, "Username or Password do not coincide!");
            return;
        }
        if (!p.checkIfBorrowed()){
            JOptionPane.showMessageDialog(null, "This book isn't borrowed!");
            return;
        }

        switch(JOptionPane.showConfirmDialog(null, "¿Quieres continuar con la publicación?")){
            case 0: {
                p.giveBack(); 
                return;
            }
            default: return;
        }
    };
    
    /**
      * Constructor de  UMNGLibraryFrame. Con este se planea
        crear un JFrame interactivo, visible, en dónde al usuario
        se le da la opción de buscar una publicación por código,
        devolver una publicación por código, y si se accede al menú
        de opciones, entonces el usuario será capaz de acceder a los
        catálogos de tanto libros como revistas. 
        <li> Note: cada vez que se accedan a los catálogos ya sean de libros
        o revistas, se deshabilitará el objeto {@link UMNGLibraryFrame} hasta 
        que la ventana creada se cierre por alguna de las mútliplpes interacciones
        que tenga con el usuario.
        @param libraryUMNG referencia a {@code this.libraryUMNG}. */
    public UMNGLibraryFrame(LibraryUMNG libraryUMNG){

        this.libraryUMNG = libraryUMNG;

        this.setTitle("Biblioteca UMNG");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
        this.setIconImage(logoUMNG.getImage());
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setJMenuBar(menuBar);
        this.setResizable(false);

        searchPublicationDominion.setBackground(Color.white);
        devolverPublicationDominion.setBackground(Color.red);

        searchPublicationDominion.setLayout(organizer);
        devolverPublicationDominion.setLayout(organizer);

        searchPublication.setForeground(Color.black);
        searchPublication.setFont(new Font("Times New Roman", Font.ITALIC,35));
        searchPublicationDominion.add(searchPublication);

        giveBackPublication.setForeground(Color.red);
        giveBackPublication.setFont(new Font("Times New Roman", Font.ITALIC,35));
        devolverPublicationDominion.add(giveBackPublication);

        selectorSearch.addActionListener(
            p->{
                int buscador; 
                try{

                    if((buscador = searchPublication.getInt())<0) throw new NumberFormatException();

                    switch(selectorSearch.getSelectedIndex()){

                        case 0: {

                            if(libraryUMNG.getLibro(buscador) == null){
                                JOptionPane.showMessageDialog(null, "Element not found!");
                                return;
                            }

                            this.showFrame(libraryUMNG.getLibro(buscador), this, false);
                            return;
                        }
                        case 1:{ 
                            if(libraryUMNG.getRevista(buscador) == null){
                                JOptionPane.showMessageDialog(null, "Element not found!");
                                return;
                            }
                            this.showFrame(libraryUMNG.getRevista(buscador));
                            return;
                        }
                    }

                }catch(NumberFormatException e){   
                    JOptionPane.showMessageDialog(null,"Wrong input!\nYou may try again.");
                }
            }
        );

        submit.addActionListener(
            p->{
                try{
                    GIVEBACKSETTER.accept(libraryUMNG.getLibro(giveBackPublication.getInt()));
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Wrong input!\nYou may try again!");
                }
            }
        );

        devolverPublicationDominion.add(submit);
        searchPublicationDominion.add(selectorSearch);

        this.add(searchPublicationDominion);
        this.add(devolverPublicationDominion);

        menuBar.add(catalogos);

        catalogos.add(libros);
        catalogos.add(revistas);

        libros.addActionListener(
            p->{
                new LibrosFrame(libraryUMNG, this);
                this.setEnabled(false);
                
            }
        );

        revistas.addActionListener(
            p->{
                new RevistasFrame(libraryUMNG, this);
                this.setEnabled(false);
            }
        );

        this.pack();
    }

    /**
     * Método que crea un GUI por el cual el usuario es capaz
       de visualizar los datos de la revista {@code x}.
       @param x revista que se va ha visualizar.
       @return void*/
    public void showFrame(Revista x){

        JFrame shower = new JFrame(x.getTitulo());
        shower.setVisible(true);
        shower.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shower.setIconImage(new ImageIcon("actividad3/Images/Libro.png").getImage());
        shower.setLayout(new BoxLayout(shower.getContentPane(), BoxLayout.Y_AXIS));

       
        JTextArea visibleArea = new JTextArea();
        visibleArea.setText(libraryUMNG.getDefaultRepresentation(x));
        visibleArea.setEditable(false);

        shower.add(visibleArea);
        shower.pack();
    }

    /**
     * Método que crea un GUI por el cual el usuario es capaz
       de visualizar los datos del libro {@code x}, a su vez que
       le notifica si está prestado o no. 
       @param x libro que se quiere visualizar.
       @param container contenedor al cual se le adjudica este GUI.
       @param askSelector {@code == true}, entonces el {@code container}
       también cerrará una vez que el GUI también lo haga.
       @return void*/
    public void showFrame(Libro x, JFrame container, Boolean askSelector){
        
        container.setEnabled(false);

        JFrame shower = new JFrame(x.getTitulo());
        shower.setVisible(true);
        shower.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shower.setIconImage(new ImageIcon("actividad3/Images/Libro.png").getImage());
        shower.setLayout(new BoxLayout(shower.getContentPane(), BoxLayout.Y_AXIS));
        shower.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent){
                        container.setEnabled(true);
                    }
                }
            );

        JTextArea visibleArea = new JTextArea();
        visibleArea.setText(libraryUMNG.getDefaultRepresentation(x));
        visibleArea.setEditable(false);
        
        shower.add(visibleArea);

        if (!x.checkIfBorrowed()){

            JPanel chooser = new JPanel();
            chooser.setLayout(organizer);

            JButton borrowerSetter = new JButton("Enviar al foro");
            borrowerSetter.addActionListener(
                p->{
                    shower.dispatchEvent(new WindowEvent(shower, WindowEvent.WINDOW_CLOSING));
                    if(askSelector) {
                        container.dispatchEvent(new WindowEvent(container, WindowEvent.WINDOW_CLOSING));
                        BORROWERSETTER.accept(x);
                    }else BORROWERSETTER.accept(x);
                }
            );

            chooser.add(borrowerSetter);
            shower.add(chooser);
            shower.pack();

        } else shower.pack();
    }
}