
import java.awt.Graphics;
public class Fondo extends Coordenada
{
    Fondo(int x, int y, String ruta) //constructor
    {
        super(x,y,ruta);
    }
    public void DibujaFondo(Graphics g)
    {
        g.drawImage(imagen,x,y,null);
    }
    
}