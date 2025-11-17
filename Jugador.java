import java.awt.Graphics;
import javax.swing.*;
import java.awt.Rectangle;

public class Jugador extends Coordenada {
    //String r_sonido_pasos = "audios/corriendo.wav";
    // Jugador left
    String r_soniL = "imagenes/atributos/soniL.gif";
    String r_gokuL = "imagenes/atributos/gokuL.gif";
    String r_dogL = "imagenes/atributos/dogL.gif";
    String r_zombieL = "imagenes/atributos/zombieL.gif";

    String r_soni = "imagenes/atributos/soni.gif";
    String r_goku = "imagenes/atributos/goku.gif";
    String r_dog = "imagenes/atributos/dog.gif";
    String r_zombie = "imagenes/atributos/zombie.gif";

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
                if (x < 0)
                    x = 0;
                if (ruta.contains("soni")) {
                    setImagen(r_soniL);
                } else if (ruta.contains("goku")) {
                    setImagen(r_gokuL);
                } else if (ruta.contains("dog")) {
                    setImagen(r_dogL);
                } else if (ruta.contains("zombie")) {
                    setImagen(r_zombieL);
                }
               

                break;
            case 38: // arriba
                y -= velocidad;
                if (y < 0)
                    y = 0;
                break;
            case 39:
                x += velocidad;
                if (x > anchoCuadro - anchoImg)
                    x = anchoCuadro - anchoImg;

                if (ruta.contains("soni")) {
                    setImagen(r_soni);
                } else if (ruta.contains("goku")) {
                    setImagen(r_goku);
                } else if (ruta.contains("dog")) {
                    setImagen(r_dog);
                } else if (ruta.contains("zombie")) {
                    setImagen(r_zombie);
                }
                 //Sonido.reproducir(r_sonido_pasos);
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
