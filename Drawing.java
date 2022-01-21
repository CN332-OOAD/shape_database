import  java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Drawing extends JComponent{
    private String x;
    private String y;
    private String shape;

    public Drawing(String shape,String x,String y){     
        this.x = x;
        this.y = y;
        this.shape= shape;
      


    }    
    
    public void paintComponent(Graphics g){  
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);  
        if (shape.equals("square")){
            Graphics2D g2d = (Graphics2D) g;
            Rectangle2D.Double r = new Rectangle2D.Double(a,b,100,250);            
            g2d.setColor(new Color(100,149,237));
            g2d.fill(r);

        }
       
    }

    
   
}
