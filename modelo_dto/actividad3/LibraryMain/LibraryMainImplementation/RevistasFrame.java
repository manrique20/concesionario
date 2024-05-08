/*
 * @(#)RevistasFrame.java  17.0.6 23/03/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package LibraryMain.LibraryMainImplementation;

import Archives.PublicationsImplementation.Revista;
import BibliotecaImplementation.LibraryUMNG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
       Clase hija de {@link JFrame} e implementadora de 
       {@link ActionListener} cuyo propósito es el 
       de proporcionar un GUI que permita al usuario 
       consultar acerca de las revistas contenidas
       en objetos de {@link LibraryUMNG}. 
 * @version     
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
class RevistasFrame extends JFrame implements ActionListener{

    /**  
        Drop-down list que permite seleccionar una revista
        en específico para conocer sus datos. */
    private JComboBox<Revista> comboBox;

    /**  
       Referencia al GUI {@link UMNGLibraryFrame} que ha
       de "implementar", más no contener, a {@code LibrosFrame}. */
    private UMNGLibraryFrame parent;

    /**  
       Array que almacenará las revistas contenidas en
       libraryUMNG. */
    private Revista[] holder;
    

    /**
     * Constructor de RevistasFrame. Con este se planea
       crear un JFrame interactivo visible de 250X150 
       para que el usuario pueda acceder al catálogo de revistas.
       <li> Note: una vez creado, el {@code parent} habrá de ser desactivado
       hasta que termine el life-cycle de {@code this}. 
       @param libraryUMNG referencia a {@code this.libraryUMNG}
       @param parent referencia al contenedor GUI {@code this.parent} */
    RevistasFrame(LibraryUMNG libraryUMNG, UMNGLibraryFrame parent){

        this.parent = parent;

        this.setTitle("Revistas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250,75);
        this.setVisible(true); 
        this.setLayout(new FlowLayout());
        this.setIconImage(new ImageIcon("actividad3/Images/Lupa.png").getImage());
        this.setResizable(false);

        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent){
                    parent.setEnabled(true);
                }
            }
        );

        comboBox = new JComboBox<>(
            libraryUMNG.getCatalogoRevistas().toArray(
                holder = libraryUMNG.getCatalogoRevistas().toArray(
                    new Revista[libraryUMNG.getCatalogoRevistas().size()]
                )
            )
        );

        comboBox.addActionListener(this);

        this.add(comboBox);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (comboBox.getComponents().length == 0){
            JOptionPane.showMessageDialog(null, "Element not found!");
            return;
        }
        this.parent.showFrame(holder[comboBox.getSelectedIndex()]);
    }
}