import javax.swing.*;
import java.awt.*;


class Coordenada {
    int x, y, ancho, alto;
    String ruta;
    ImageIcon icono;
    Image imagen;
    

    Coordenada(int x, int y, String ruta) { //contructor
        this.x = x;
        this.y = y;
        this.ruta = ruta;

        this.icono = new ImageIcon(getClass().getResource(ruta));
        this.imagen = icono.getImage();
        this.ancho = icono.getIconWidth();
        this.alto = icono.getIconHeight();
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, ancho, alto, null);
    }
    
    //metodo para aleatrorios
    public static int generaAleatorio(int d, int h)
    {
        int ale=((int)(Math.random()*(h-d+1)+d));
        return ale;
    }
}