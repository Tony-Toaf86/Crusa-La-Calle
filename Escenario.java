import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Escenario extends JPanel implements KeyListener, ActionListener {
    Timer miTimer;
    int alto, ancho;

    Fondo miFondo;
    ArrayList<Vehiculo> vehiculos; // lista vehiculo
    ArrayList<Moneda> monedas;     // lista de monedas
    Jugador miJugador;

    // rutas fondos
    String r_fondo1 = "imagenes/fondos/fondo1.png";
    String r_fondo2 = "imagenes/fondos/fondo2.png";
    String r_fondo3 = "imagenes/fondos/fondo3.png";

    // rutas elementos
    String r_moneda = "imagenes/atributos/monedapuntos.png";
    String r_moto = "imagenes/vehiculos/moto.png";
    String r_camion_orange = "imagenes/vehiculos/Rcamion_naranja.png";

    public Escenario(String rutaJugador) {
        vehiculos = new ArrayList<>();
        monedas = new ArrayList<>();

        // fondo aleatorio
        int fondo_Aleatorio = generaAleatorio(1, 30);

        if (fondo_Aleatorio <= 10) {
            miFondo = new Fondo(0, 0, r_fondo1);
            dibujarlosVehiculos(50, 180);
            miJugador = new Jugador(400, 100, rutaJugador);

        } else if (fondo_Aleatorio <= 20) {
            miFondo = new Fondo(0, 0, r_fondo2);
            dibujarlosVehiculos(100, 200);
            dibujarlosVehiculos(-400, 350); //nuevos vehiculos
            miJugador = new Jugador(400, 100, rutaJugador);

        } else {
            miFondo = new Fondo(0, 0, r_fondo3);
            dibujarlosVehiculos(200, 120);
            miJugador = new Jugador(400, 100, rutaJugador);
        }

        setFocusable(true);
        addKeyListener(this);
        ancho = miFondo.ancho;
        alto = miFondo.alto;

        miTimer = new Timer(20, this); // timer con 20ms de intervalo
        miTimer.start();

        setSize(ancho, alto);
    }

    public void dibujarlosVehiculos(int posx, int posy) {
        int opcion = generaAleatorio(1, 2);

        if (opcion == 1) {
            vehiculos.add(new Vehiculo(posx, posy, r_moto));
            vehiculos.add(new Vehiculo(-300, posy, r_camion_orange));
        } else {
            vehiculos.add(new Vehiculo(posx, posy, r_camion_orange));
            vehiculos.add(new Vehiculo(-600, posy, r_moto));
        }

        monedas.add(new Moneda(posx + 150, posy, r_moneda));
    }

    // timer para mover vehículos
    public void actionPerformed(ActionEvent e) {
        for (Vehiculo v : vehiculos) {
            v.moverVehiculos();
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        miJugador.mover(tecla, alto, ancho);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        miFondo.DibujaFondo(g);

        for (Moneda m : monedas) m.DibujaMoneda(g);
        miJugador.DibujaJugador(g);
        for (Vehiculo v : vehiculos) v.DibujaVehiculo(g);
    }

    public static int generaAleatorio(int d, int h) {
        return (int) (Math.random() * (h - d + 1) + d);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
