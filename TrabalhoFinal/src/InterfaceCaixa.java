import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceCaixa extends JFrame {
    
    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceCaixa (Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaCaixa (Academia academia, JFrame interfacePrincipal) {

    }
}
