import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAdministrador extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceAdministrador(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaAdministrador (Academia academia, JFrame interfacePrincipal) {

    }
}
