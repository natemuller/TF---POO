import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceProfessor extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceProfessor(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaProfessor(Academia academia, JFrame interfacePrincipal) {
    
    }

}
