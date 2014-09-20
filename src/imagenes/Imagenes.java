package imagenes;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import sun.awt.image.JPEGImageDecoder;
/* @author CristianOmarJar */

public class Imagenes extends JFrame {
public Imagenes() {
super("Abrir Imagen");
}
public void paint(Graphics g) {
Graphics2D g2 = (Graphics2D)g;
try {
InputStream in =getClass().getResourceAsStream("src/recursos/Planeador.PNG");
    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
BufferedImage image = decoder.decodeAsBufferedImage();
g2.drawImage(image, 0, 20,this);
in.close();
}
catch (IOException e) {e.printStackTrace();}
catch (ImageFormatException e) {e.printStackTrace();}
}
public static void main (String args[]) {
Imagenes v = new Imagenes();
v.setDefaultCloseOperation(EXIT_ON_CLOSE);
v.setSize(375,300);
v.setVisible(true);
}
}

