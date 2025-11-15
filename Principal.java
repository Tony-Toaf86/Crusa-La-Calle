import javax.swing.JFrame;

public class Principal extends JFrame { // Clase principal

    public Principal() {
        super("Crusa la Calle");
        Menu miMenu = new Menu();
        add(miMenu);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}
