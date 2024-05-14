package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import ui.VistaCliente.LoginCliente;

class ControladorLogin implements ActionListener {
    private LoginCliente Login= new LoginCliente();
    
    public ControladorLogin(){
        this.Login.Signup.addActionListener(this);
        this.Login.Volver.addActionListener(this);
        this.Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Login.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                    new ControladorPrincipal();
                }});
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.Login.Signup)){
            new ControladorSignup();
            this.Login.dispose();   
        }
        if(e.getSource().equals((this.Login.Volver))){
            new ControladorPrincipal();
            this.Login.dispose();
        }    
    }
}
