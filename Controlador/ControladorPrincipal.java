package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.VistaPrincipal.*;

public class ControladorPrincipal implements ActionListener{

    private Inicial vistaPrincipal = new Inicial();

    public ControladorPrincipal()
    {
        this.vistaPrincipal.Cliente.addActionListener(this);
        this.vistaPrincipal.Vendedor.addActionListener(this);

    } 
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource().equals(this.vistaPrincipal.Cliente)){
            new ControladorLogin();
            this.vistaPrincipal.dispose();
        }
        //Pendiente finalizar vendedor
        if(e.getSource().equals(this.vistaPrincipal.Vendedor)){}    
    } 

    public static void main(String[] args){
        new ControladorPrincipal();
    }
}