import  java.awt.*;
import javax.swing.*;

public class DrawingShape extends JComponent {
    private Integer x;
    private Integer y;
    private String shape;
    private String color;
    private Integer param1;
    private Integer param2;
   
    // define shape component
    public DrawingShape(String[] componentArray){     
        
        String[] address = componentArray[0].split(",");
        this.x = Integer.parseInt(address[0]); 
        this.y = Integer.parseInt(address[1]);
        this.shape= componentArray[1];
        this.color = componentArray[2];
        
        // exception for some param is null
        try{
            this.param1 = Integer.parseInt(componentArray[3]);
            this.param2 = Integer.parseInt(componentArray[4]);
        } catch(NumberFormatException e){  
            
        }
    }    

 
    // make shape
    public void paintComponent(Graphics g){  
        ShapeLib shapemodel = new ShapeLib();
        shapemodel.makeShape(x, y, shape, color,param1,param2,g);  
     }
}
