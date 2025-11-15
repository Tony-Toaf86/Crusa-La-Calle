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
    ArrayList<Moneda> monedas; // lista de monedas
    Jugador miJugador;

    // rutas fondos
    String r_fondo1 = "imagenes/fondos/fondo1.png";
    String r_fondo2 = "imagenes/fondos/fondo2.png";
    String r_fondo3 = "imagenes/fondos/fondo3.png";

    // rutas elementos vehiculos derecha
    String r_motoR = "imagenes/vehiculos/moto.png";
    String r_moto_azulR = "imagenes/vehiculos/Rmoto_Azul.png";
    String r_camion_orangeR = "imagenes/vehiculos/Rcamion_naranja.png";
    String r_camion_verdeR = "imagenes/vehiculos/Rcamioncito_verde.png";

    // ruta elementos vehiculos izquierda
    String r_camion_naranjaL = "imagenes/vehiculos/Lcamion_naranja.png";
    String r_moto_azulL = "imagenes/vehiculos/Lmoto_Azul.png";
    String r_motoL = "imagenes/vehiculos/Lmoto.png";
    String r_camion_rojoL = "imagenes/vehiculos/Lcamion_rojo.png";

    // Atributos ganas
    String r_moneda = "imagenes/atributos/monedapuntos.png";
    String r_esfera = "imagenes/atributos/esfera.gif";
    String r_diamante = "imagenes/atributos/diamante.gif";
    int generamoneda = generaAleatorio(1, 3);

    public Escenario(String rutaJugador) {
        vehiculos = new ArrayList<>();
        monedas = new ArrayList<>();

        // fondo aleatorio
        int fondo_Aleatorio = 20;// generaAleatorio(1, 30);

        if (fondo_Aleatorio <= 10) {
            miFondo = new Fondo(0, 0, r_fondo1);
            dibujarVehiculosDerecha(50, 180);
            miJugador = new Jugador(400, 100, rutaJugador);

        } else if (fondo_Aleatorio == 20) {
            miFondo = new Fondo(0, 0, r_fondo2);
            dibujarVehiculosDerecha(100, 200); 
            dibujarVehiculosDerecha(-400, 350);
            dibujarVehiculosIzquierda(0, 100);
            dibujarVehiculosIzquierda(0, 470);
            miJugador = new Jugador(400, 100, rutaJugador);

        } else {
            miFondo = new Fondo(0, 0, r_fondo3);
            dibujarVehiculosDerecha(200, 120);
            miJugador = new Jugador(400, 100, rutaJugador);
        }

        setFocusable(true);
        addKeyListener(this);
        ancho = miFondo.ancho;
        alto = miFondo.alto;

        agregarMonedaAleatoria(); // dibujar moneda de forma aleatoria

        miTimer = new Timer(20, this); // timer con 20ms de intervalo
        miTimer.start();

        setSize(ancho, alto);
    }

    public void dibujarVehiculosDerecha(int posx, int posy) { // metodo para dibujar los vehiculos
        int opcion = generaAleatorio(1, 2);

        if (opcion == 1) {
            vehiculos.add(new Vehiculo(posx, posy, r_motoR));
            vehiculos.add(new Vehiculo(-300, posy, r_camion_orangeR));
            vehiculos.add(new Vehiculo(-600, posy, r_moto_azulR));
            vehiculos.add(new Vehiculo(-900, posy, r_camion_verdeR));
        } else {
            vehiculos.add(new Vehiculo(posx, posy, r_camion_orangeR));
            vehiculos.add(new Vehiculo(-600, posy, r_motoR));
            vehiculos.add(new Vehiculo(-300, posy, r_camion_verdeR));
            vehiculos.add(new Vehiculo(-900, posy, r_moto_azulR));
           

        }
    }
    public void dibujarVehiculosIzquierda(int posx, int posy) { // metodo para dibujar los vehiculos
        int opcion = generaAleatorio(1, 2);

        if (opcion == 1) {
            vehiculos.add(new Vehiculo(posx, posy, r_camion_naranjaL));
            vehiculos.add(new Vehiculo(+300, posy, r_moto_azulL));
            vehiculos.add(new Vehiculo(+600, posy, r_motoL));
            vehiculos.add(new Vehiculo(+900, posy, r_camion_rojoL));
        } else {
            vehiculos.add(new Vehiculo(posx, posy, r_moto_azulL));
            vehiculos.add(new Vehiculo(+300, posy, r_camion_rojoL));
            vehiculos.add(new Vehiculo(+600, posy, r_camion_naranjaL));
            vehiculos.add(new Vehiculo(+900, posy, r_motoL));

        }
    }

    public void agregarMonedaAleatoria() {
        int x = generaAleatorio(50, ancho - 100);
        int y = generaAleatorio(50, alto - 100);

        if (generamoneda == 1) {
            monedas.add(new Moneda(x, y, r_diamante));
        } else if (generamoneda == 2) {
            monedas.add(new Moneda(x, y, r_moneda));
        } else {
            monedas.add(new Moneda(x, y, r_esfera));
        }
    }

    // timer para mover vehículos
    public void actionPerformed(ActionEvent e) {

        for (Vehiculo v : vehiculos) {
            if (v.ruta.contains("L")) {
                v.moverVehiculosEjeXIza();
            } else {
                v.moverVehiculosEjeXDere(); // derecha
            }
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

        for (Moneda m : monedas)
            m.DibujaMoneda(g);

        miJugador.DibujaJugador(g);
        for (Vehiculo v : vehiculos)
            v.DibujaVehiculo(g);

    }

    public static int generaAleatorio(int d, int h) {
        return (int) (Math.random() * (h - d + 1) + d);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
