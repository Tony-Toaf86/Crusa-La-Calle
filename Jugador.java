
import java.awt.Graphics;
import javax.swing.*;

public class Jugador extends Coordenada {
    int anchoImg, altoImg;

    Jugador(int x, int y, String ruta) {
        super(x, y, ruta);
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    public void DibujaJugador(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    public void setImagen(String ruta) {
        imagen = new ImageIcon(ruta).getImage();
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    public void mover(int codigoTecla, int altoCuadro, int anchoCuadro) {
        int velocidad = 5;
        int anchoJugador = imagen.getWidth(null);
        int altoJugador = imagen.getHeight(null);

        switch (codigoTecla) {
            case 37: // Izquierda
                x -= velocidad;
                if (x < 0)
                    x = 0;
                break;

            case 38: // Arriba
                y -= velocidad;
                if (y < 0)
                    y = 0;
                break;

            case 39: // Derecha
                x += velocidad;
                if (x > anchoCuadro - anchoJugador)
                    x = anchoCuadro - anchoJugador;
                break;

            case 40: // Abajo
                y += velocidad;
                if (y > altoCuadro - altoJugador)
                    y = altoCuadro - altoJugador;
                break;
        }
    }

}
