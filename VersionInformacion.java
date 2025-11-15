import javax.swing.*;
import java.awt.*;

public class VersionInformacion extends JPanel {

    JLabel labelAppName;
    JLabel labelVersion;
    JLabel labelAuthor;
    JLabel labelDate;
    JLabel labelDescription;
    JLabel labelTitulo;

    public VersionInformacion() {

        setLayout(new GridLayout(6, 1, 10, 5));
        setBackground(Color.WHITE);
        labelTitulo = crearEtiqueta("--------Información de la aplicación---------");
        labelAppName = crearEtiqueta("Nombre de la aplicación: Crusa La Calle");
        labelVersion = crearEtiqueta("Versión: 1.0.0");
        labelAuthor = crearEtiqueta("Autor: Tony Alonzo");
        labelDate = crearEtiqueta("Fecha: 2025-11-11");
        labelDescription = crearEtiqueta("Descripción: Juego arcade de cruzar la calle");

        add(labelTitulo);
        add(labelAppName);
        add(labelVersion);
        add(labelAuthor);
        add(labelDate);
        add(labelDescription);
        
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        return label;
    }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Información de la aplicacion");
        VersionInformacion panel = new VersionInformacion();
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

       
    }
}
