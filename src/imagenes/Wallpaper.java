package imagenes;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wallpaper extends JPanel{
    Random rnd = new Random();    
        
    public void paintComponent( Graphics g ) {
    Graphics2D g2 = (Graphics2D)g;
    //degradado
    Color color_2= new Color(127, 15, 124);
    Color color_3= new Color(228,123,130);
    Color color_4= new Color(255,192,175);
    Color colores[]= {Color.black,color_2,color_3,color_4};
    float fracciones[]={.0f,.4f,.6f,1f};
    LinearGradientPaint p = new LinearGradientPaint(0f, 0f, 640f, 325.5f, fracciones, colores, CycleMethod.REFLECT);
    g2.setPaint(p);
    g2.fillRect(0, 0,1280,750);
    //--fin degradado
    
    //pinta_circulos(int posicion_x,int posicion_y,double ancho,double alto, float alpha)
    for(int q=0 ; q<100 ; q++)
    {
        int ancho_alto=rnd.nextInt(100);
        g2.drawImage(
                pinta_circulos_rellenos(rnd.nextInt(1280),rnd.nextInt(750),(double)ancho_alto,(double)ancho_alto,(float)rnd.nextInt(70)/100), 
                null, q, q);
    }
    
    for(int q=0 ; q<30 ; q++)
    {
        int ancho_alto=rnd.nextInt(100);
        g2.drawImage(
                pinta_circulos(rnd.nextInt(1280),rnd.nextInt(750),(double)ancho_alto,(double)ancho_alto,(float)rnd.nextInt(40)/100,(float)rnd.nextInt(100)/30), 
                null, q, q);
    }
    //--fin de pintar circulos
    
    //rayas
    g2.setColor(Color.white);
    g2.drawLine(0, 300, 200, 0);
    g2.drawLine(1280,400,1025,750);
    //fin rayas
    
    //strokes
    float fracciones_1[]={10,5,5,5};
    BasicStroke s = new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, TOP_ALIGNMENT, fracciones_1, TOP_ALIGNMENT);
    AffineTransform aT= g2.getTransform();
    aT.rotate(.6);
    BufferedImage bi = new BufferedImage(1000,1000,BufferedImage.TRANSLUCENT);
    Graphics2D big = bi.createGraphics();
    big.transform(aT);
    big.setStroke(s);
    big.draw(new Rectangle2D.Double(80,0,60,60));
    g2.drawImage(bi, null, 5, 5);
    bi = new BufferedImage(1000,1000,BufferedImage.TRANSLUCENT);
    big = bi.createGraphics();
    big.transform(aT);
    big.setStroke(s);
    big.draw(new Rectangle2D.Double(80, 0, 60, 60));
    g2.drawImage(bi, null,1100,550);
    //--fin strokes
    }
    
    private BufferedImage pinta_circulos_rellenos(int posicion_x,int posicion_y,double ancho,double alto, float alpha){
    BufferedImage bi = new BufferedImage(1280, 750, BufferedImage.TRANSLUCENT);
    Graphics2D big = bi.createGraphics();
    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.DST_OVER,alpha);;
    big.setColor(Color.WHITE);
    big.setComposite(ac);
    big.fill(new Ellipse2D.Double(posicion_x, posicion_y, ancho, alto));
    return bi;
    }
    
    private BufferedImage pinta_circulos(int posicion_x,int posicion_y,double ancho,double alto, float alpha, float ancho_pincel){
    BufferedImage bi = new BufferedImage(1280, 750, BufferedImage.TRANSLUCENT);
    Graphics2D big = bi.createGraphics();
    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.DST_OVER,alpha);;
    big.setColor(Color.WHITE);
    big.setComposite(ac);
    BasicStroke s = new BasicStroke(ancho_pincel,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND);
    big.setStroke(s);
    big.draw(new Ellipse2D.Double(posicion_x, posicion_y, ancho, alto));
    return bi;
    }
    
    
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Wallpaper p = new Wallpaper();
        //f.getContentPane().add("Center", p);
        f.getContentPane().add(p);
        f.pack();
        f.setSize(new Dimension(1280, 750));
        f.setVisible(true);
    }
}