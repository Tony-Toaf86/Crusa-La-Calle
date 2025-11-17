import javax.sound.sampled.*;
import java.io.File;

public class Sonido {

    public static void reproducir(String ruta) { //por llamad
        try {
            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start(); 
        } catch (Exception e) {
            System.out.println("Error" + ruta);
        }
    }

    public static void loop(String ruta) { // en bucle
        try {
            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error" + ruta);
        }
    }
}
