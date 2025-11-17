import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Escenario extends JPanel implements KeyListener, ActionListener {

    Timer miTimer;
    int alto, ancho;
    int monedasGanadas = 0;
    int vidas = 4;

    Fondo miFondo;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Moneda> monedas;
    Jugador miJugador;

    // rutas fondos
    String r_fondo1 = "imagenes/fondos/fondo1.png";
    String r_fondo2 = "imagenes/fondos/fondo2.png";
    String r_fondo3 = "imagenes/fondos/fondo3.png";

    // vehículos derecha
    String r_motoR = "imagenes/vehiculos/moto.png";
    String r_moto_azulR = "imagenes/vehiculos/Rmoto_Azul.png";
    String r_camion_orangeR = "imagenes/vehiculos/Rcamion_naranja.png";
    String r_camion_verdeR = "imagenes/vehiculos/Rcamioncito_verde.png";

    // vehículos izquierda
    String r_camion_naranjaL = "imagenes/vehiculos/Lcamion_naranja.png";
    String r_moto_azulL = "imagenes/vehiculos/Lmoto_Azul.png";
    String r_motoL = "imagenes/vehiculos/Lmoto.png";
    String r_camion_rojoL = "imagenes/vehiculos/Lcamion_rojo.png";

    // vehículos arriba
    String r_camion_grisU = "imagenes/vehiculos/up/Ucamion_gris.png";
    String r_car_verdeU = "imagenes/vehiculos/up/UGreen.png";
    String r_car_blueU = "imagenes/vehiculos/up/UBlue.png";
    String r_car_violetU = "imagenes/vehiculos/up/UViolet.png";

    // vehículos abajo
    String r_camion_grisD = "imagenes/vehiculos/down/Dcamion_gris.png";
    String r_car_verdeD = "imagenes/vehiculos/down/DGreen.png";
    String r_car_blueD = "imagenes/vehiculos/down/DBlueCar.png";
    String r_car_violetD = "imagenes/vehiculos/down/DViolet.png";

    // monedas
    String r_moneda = "imagenes/atributos/monedapuntos.png";
    String r_esfera = "imagenes/atributos/esfera.gif";
    String r_diamante = "imagenes/atributos/diamante.gif";
    int generamoneda = generaAleatorio(1, 3);

    //ruta de los audios 
    String r_audio_fondo = "audios/sonido_autos.wav";
    String r_audio_win = "audios/game_win.wav";
    String r_audio_lose = "audios/game_over.wav";


    public Escenario(String rutaJugador) {

        vehiculos = new ArrayList<>();
        monedas = new ArrayList<>();
        Sonido.loop(r_audio_fondo);

        int fondo_Aleatorio = generaAleatorio(1, 30);

        if (fondo_Aleatorio <= 10) {
            miFondo = new Fondo(0, 0, r_fondo1);
            dibujarVehiculosDerecha(50, 180);
            dibujarVehiculosIzquierda(0, 130);
            dibujarVehiculosArriba(200, 0);
            dibujarVehiculosAbajo(700, 0);
            miJugador = new Jugador(500, 40, rutaJugador);

        } else if (fondo_Aleatorio <= 20) {
            miFondo = new Fondo(0, 0, r_fondo2);
            dibujarVehiculosDerecha(100, 200);
            dibujarVehiculosDerecha(-400, 350);
            dibujarVehiculosIzquierda(0, 100);
            dibujarVehiculosIzquierda(0, 470);
            miJugador = new Jugador(500, 270, rutaJugador);

        } else {
            miFondo = new Fondo(0, 0, r_fondo3);
            dibujarVehiculosDerecha(200, 120);
            dibujarVehiculosAbajo(430, 0);
            dibujarVehiculosArriba(760, 0);
            miJugador = new Jugador(300, 250, rutaJugador);
        }

        setFocusable(true);
        addKeyListener(this);
        ancho = miFondo.ancho;
        alto = miFondo.alto;

        agregarMonedaAleatoria();

        miTimer = new Timer(15, this);
        miTimer.start();

        setSize(ancho, alto);
    }

    public void dibujarVehiculosArriba(int posx, int posy) {
        vehiculos.add(new Vehiculo(posx, posy - 100, r_camion_grisU));
        vehiculos.add(new Vehiculo(posx, posy + 400, r_car_verdeU));
        vehiculos.add(new Vehiculo(posx, posy + 600, r_car_blueU));
        // vehiculos.add(new Vehiculo(posx -12, posy + 1200, r_car_violetU));

    }

    public void dibujarVehiculosAbajo(int posx, int posy) {
        vehiculos.add(new Vehiculo(posx, posy - 20, r_camion_grisD));
        // vehiculos.add(new Vehiculo(posx, posy-300, r_car_verdeD));
        vehiculos.add(new Vehiculo(posx + 19, posy - 700, r_car_blueD));
        vehiculos.add(new Vehiculo(posx + 19, posy - 1100, r_car_violetD));
    }

    public void dibujarVehiculosDerecha(int posx, int posy) {
        vehiculos.add(new Vehiculo(posx, posy, r_motoR));
        // vehiculos.add(new Vehiculo(-300, posy, r_camion_orangeR));
        vehiculos.add(new Vehiculo(-600, posy, r_moto_azulR));
        vehiculos.add(new Vehiculo(-900, posy, r_camion_verdeR));

    }

    public void dibujarVehiculosIzquierda(int posx, int posy) {
        vehiculos.add(new Vehiculo(posx, posy, r_camion_naranjaL));
        // vehiculos.add(new Vehiculo(+300, posy, r_moto_azulL));
        vehiculos.add(new Vehiculo(+600, posy, r_motoL));
        vehiculos.add(new Vehiculo(+900, posy, r_camion_rojoL));
    }

    public void agregarMonedaAleatoria() {
        int x = generaAleatorio(50, ancho - 100);
        int y = generaAleatorio(50, alto - 100);;

        if (generamoneda == 1)
            monedas.add(new Moneda(x, y, r_diamante));
        else if (generamoneda == 2)
            monedas.add(new Moneda(x, y, r_moneda));
        else
            monedas.add(new Moneda(x, y, r_esfera));
    }
    public void actionPerformed(ActionEvent e) {

        for (Vehiculo v : vehiculos) {
            if (v.ruta.contains("L"))
                v.moverVehiculosEjeXIza();
            else if (v.ruta.contains("U"))
                v.moverVehiculosEjeYArriba();
            else if (v.ruta.contains("D"))
                v.moverVehiculosEjeYAbajo();
            else
                v.moverVehiculosEjeXDere();
        }
        for (int i = 0; i < monedas.size(); i++) {
            Moneda m = monedas.get(i);

            if (miJugador.getRect().intersects(m.getRect())) {

                monedas.remove(i);
                agregarMonedaAleatoria();

                monedasGanadas++;
                juegoGanado(monedasGanadas);
            }
        }

        boolean colisionDetectada = false;

        for (Vehiculo v : vehiculos) {
            if (miJugador.getRect().intersects(v.getRect())) {
                colisionDetectada = true;
                break;
            }
        }
        manejarVidas(colisionDetectada);
        repaint();
    }

    public void juegoGanado(int monedas) {
        if (monedasGanadas >= 4) { 
            miTimer.stop();
            Sonido.reproducir(r_audio_win);
            JOptionPane.showMessageDialog(this, "has ganado el juego con " + monedasGanadas + " monedas");
            
            // Cerrar solo la ventana actual
            Window ventana = SwingUtilities.getWindowAncestor(this);
            if (ventana != null) {
                ventana.dispose(); 
            }
        }
    }
 
    public void manejarVidas(boolean colisionDetectada) {
        if (colisionDetectada && !miJugador.enColision) {
            vidas--;
            miJugador.enColision = true;

            if (vidas <= 0) {
                miTimer.stop();
                Sonido.reproducir(r_audio_lose);
                JOptionPane.showMessageDialog(this, "Has perdido todas tus vidas, fin del juego");
                System.exit(0);

            } else {
                JOptionPane.showMessageDialog(this, "te atropello un vehiculo, vidas restantes " + vidas);
                miJugador.setPosicion(10, 10);
            }

        } else if (!colisionDetectada) {
            miJugador.enColision = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        miJugador.mover(e.getKeyCode(), alto, ancho);
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        miFondo.DibujaFondo(g);

        // monedas
        for (Moneda m : monedas) {
            m.DibujaMoneda(g);
            // g.setColor(Color.YELLOW);
            // Rectangle r = m.getRect();
            // g.drawRect(r.x, r.y, r.width, r.height);
        }

        // jugador
        miJugador.DibujaJugador(g);
        // g.setColor(Color.GREEN);
        // Rectangle rj = miJugador.getRect();
        // g.drawRect(rj.x, rj.y, rj.width, rj.height);

        // vehiculos
        for (Vehiculo v : vehiculos) {
            v.DibujaVehiculo(g);
            // g.setColor(Color.RED);
            // Rectangle rv = v.getRect();
            // g.drawRect(rv.x, rv.y, rv.width, rv.height);
        }
    }

    public static int generaAleatorio(int d, int h) { //metodo de la clase
        return (int) (Math.random() * (h - d + 1) + d);
    }
}
