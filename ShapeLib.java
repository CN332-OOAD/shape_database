import  java.awt.*;
import java.awt.geom.*;

public class ShapeLib {    
    
    // create shape & color
    public void makeShape(Integer x,Integer y,String shape,String color,Integer param1,Integer param2,Integer[] trianglePointArr ,Graphics g){       
        Graphics2D g2d = (Graphics2D) g;
        ColorLib colormodel = new ColorLib();  

        

        // shape libraly
        if (shape.equals("square")){           
            Rectangle2D.Double r = new Rectangle2D.Double(x,y,param1,param1);                    
            g2d.setColor(colormodel.ColorFill(color));
            g2d.fill(r);                     
        }
        
        else if (shape.equals("circle")){
            g2d.setColor(colormodel.ColorFill(color));
            g.fillOval(x, y, param1, param1);                  
         }
        
         else if (shape.equals("rect")){
            g2d.setColor(colormodel.ColorFill(color));
            g.fillOval(x, y, param1, param2);                  
         }

        else if(shape.equals("triangle")){        
            g2d.setColor(colormodel.ColorFill(color));
            int[] xpoint = {trianglePointArr[0]+x,trianglePointArr[2]+x,trianglePointArr[4]+x};
            int[] ypoint = {trianglePointArr[1]+y,trianglePointArr[3]+y,trianglePointArr[5]+y};
            int nPoint = 3;
            g.fillPolygon(xpoint,ypoint,nPoint);

            
        }
        
    }
}
