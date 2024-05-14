package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ui.VistaCliente.SignupCliente;

class ControladorSignup implements ActionListener {
    private SignupCliente Signup = new SignupCliente();
    
    public ControladorSignup(){
        this.Signup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Signup.volver.addActionListener(this);
        this.Signup.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                    new ControladorLogin();
                }});
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.Signup.volver)){
            new ControladorLogin();
            this.Signup.dispose();
        }    
    }
}
