
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Moneda extends Coordenada {
    int anchoImg, altoImg;

    Moneda(int x, int y, String ruta) {
        super(x, y, ruta);
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    public void DibujaMoneda(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    public void setImagen(String ruta) {
        imagen = new ImageIcon(ruta).getImage();
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, anchoImg, altoImg);
    }

}
