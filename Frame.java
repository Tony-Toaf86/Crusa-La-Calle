import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame(String rutaJugador) {
        super("Crusa la Calle");

        Escenario miPanel = new Escenario(rutaJugador);
        add(miPanel);

        setSize(miPanel.getWidth(), miPanel.getHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
