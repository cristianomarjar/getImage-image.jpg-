package imagenes;
import java.awt.*;
import javax.swing.*;
/* @author CristianOmarJar */
public class Imagen extends JFrame {
    public Imagen() {
    super("Abrir Imagen");
}
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    Image im = Toolkit.getDefaultToolkit().getImage("src/recursos/Planeador.PNG");
    g2.drawImage(im, 5, 30, this);
}
public static void main (String args[]) {
    Imagen v = new Imagen();
    v.setDefaultCloseOperation(EXIT_ON_CLOSE);
    v.setSize(535,560);
    v.setVisible(true);
    }
}