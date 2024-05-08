/*
 * @(#)Borrower.java     17.0.6  20/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package Archives.ArchivesCustoms;

import javax.swing.JTextField;

/**
 * 
        Clase hija de {@link JTextField} que permite
        manejar integros (¡no maneja errores!).
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class CustomTextField extends JTextField{

    /**  
       Atributo que "guarda" el valor de {@code text}. */
    private String defaultMessage;

    /**  
       Atributo que ayuda a determinar si se quiere seguir
       usando {@code defaultMessage}.*/
    private Boolean defaultSelector = true;

    /**
     *  Permite inicializar (set) {@code text} y
        {@code defaultMessage}.     
        @param text */
    public CustomTextField(String text){
        super(text);
        defaultMessage = text;
    }

    /**
     *  Permite inicializar (set) {@code text}, 
        {@code defaultMessage}, y {@code defaultSelector}.   
        @param text default text.
        @param defaultSelector using {@code defaultText} true iff
        {@code defaultSelector} is true.*/
    public CustomTextField(String text, Boolean defaultSelector){
        super(text);
        this.defaultSelector = defaultSelector;
    }

    /**  
       Default constructor of {@code CustomTextField}.*/
    public CustomTextField(){}

    /**
     * Retorna el integro que fue parsed a través
       de {@code parseInt(this.getText().strip())}. 
       @return el integro que fue parsed.*/
    public int getInt(){
        int n = Integer.parseInt(this.getText().strip());
        this.setDefaultText();
        return n;
    }

    /**
     * {@code this.setText(defaultMessage)} siempre y
       cuando {@code defaultSelector = true}. 
       @return void*/
    public void setDefaultText(){
        if (defaultSelector) {
            this.setText(defaultMessage);
            return;
        } else return;
    }
}