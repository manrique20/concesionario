package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.VistaPrincipal.*;


public class ControladorPrincipal implements ActionListener{

    private Inicial vistaPrincipal = new Inicial();

    public ControladorPrincipal(Inicial vistaPrincipal)
    {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.jButton1.addActionListener(this);
        this.vistaPrincipal.jButton2.addActionListener(this);
    } 
    
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        
    } 
}