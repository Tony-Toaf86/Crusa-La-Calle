import java.awt.Graphics;
import javax.swing.*;
import java.awt.Rectangle;

public class Jugador extends Coordenada {
    int anchoImg, altoImg;
    boolean enColision = false; 

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
        int velocidad = 15;

        switch (codigoTecla) {
            case 37: // izquierda
                x -= velocidad;
                if (x < 0) x = 0;
                break;
            case 38: // arriba
                y -= velocidad;
                if (y < 0) y = 0;
                break;
            case 39: // derecha
                x += velocidad;
                if (x > anchoCuadro - anchoImg)
                    x = anchoCuadro - anchoImg;
                break;
            case 40: // abajo
                y += velocidad;
                if (y > altoCuadro - altoImg)
                    y = altoCuadro - altoImg;
                break;
        }
    }

    public Rectangle getRect() { 
        return new Rectangle(x, y, anchoImg, altoImg);
    }

    public void setPosicion(int nuevaX, int nuevaY) { 
        x = nuevaX;
        y = nuevaY;
    }
}
