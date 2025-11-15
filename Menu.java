import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener {

    // rutas de jugadores
    String r_soni = "imagenes/atributos/soni.gif";
    String r_goku = "imagenes/atributos/goku.gif";
    String r_dog = "imagenes/atributos/dog.gif";
    String r_zombie = "imagenes/atributos/zombie.gif";

    public Menu() { // constructor
        setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel("SELECCIONE UN PERSONAJE");
        labelTitulo.setForeground(Color.RED);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));

        panelBotones.add(crearBoton("Goku"));
        panelBotones.add(crearBoton("Soni"));
        panelBotones.add(crearBoton("Zombie"));
        panelBotones.add(crearBoton("El perro"));
        panelBotones.add(crearBoton("Version e Informacion"));

        add(panelBotones, BorderLayout.CENTER);
    }

    public JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.PLAIN, 18));
        boton.addActionListener(this);
        return boton;
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Goku" -> abrirFrame(r_goku);
            case "Soni" -> abrirFrame(r_soni);
            case "Zombie" -> abrirFrame(r_zombie);
            case "El perro" -> abrirFrame(r_dog);
            case "Version e Informacion" -> {
                VersionInformacion info = new VersionInformacion();
                JFrame ventana = new JFrame("Versión e Información");
                ventana.add(info);
                ventana.setSize(400, 400);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
            default -> JOptionPane.showMessageDialog(this, "Opción no implementada");
        }
    }

    // mtodo para crear un Frame y pasarle la ruta del jugador
    public void abrirFrame(String rutaJugador) {
        Frame nuevaVentana = new Frame(rutaJugador);
        nuevaVentana.setVisible(true);
    }
}
