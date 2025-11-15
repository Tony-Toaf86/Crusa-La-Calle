

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Vehiculo extends Coordenada {
    int anchoImg, altoImg;

    Vehiculo(int x, int y, String ruta) {
        super(x, y, ruta);
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    public void DibujaVehiculo(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    
    

    public void setImagen(String ruta) {
        imagen = new ImageIcon(ruta).getImage();
        anchoImg = imagen.getWidth(null);
        altoImg = imagen.getHeight(null);
    }

    //metodos para mover vehiculos
    public void moverVehiculosEjeXDere() {
        x += 10;
        if (x > 1000) {
            x = -anchoImg; 
        }
       
    }
    public void moverVehiculosEjeXIza() {
        x -= 10;
        if (x < -anchoImg) {
            x = 1000; 
        }
       
    }

    public void moverVehiculosEjeYAbajo() {
        y += 10;
        if (y > 600) {
            y = -altoImg; 
        }
       
    }

    public void moverVehiculosEjeYArriba() {
        y -= 10;
        if (y < -altoImg) {
            y = 600; 
        }
       
    }

   
}
