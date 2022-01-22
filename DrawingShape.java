import  java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List; 


public class DrawingShape extends JComponent {
    private Integer x;
    private Integer y;
    private String shape;
    private String color;
    private String stringParam1;
    private String stringParam2;
    private String stringParam3;
    private Integer param1;
    private Integer param2;
    
    private Integer[] trianglePointArr;
   
    // define shape component
    public DrawingShape(String[] componentArray){     
        
        String[] address = componentArray[0].split(",");
        this.x = Integer.parseInt(address[0]); 
        this.y = Integer.parseInt(address[1]);
        this.shape= componentArray[1];
        this.color = componentArray[2];
        this.stringParam1 = componentArray[3];
        this.stringParam2 = componentArray[4];  
        this.stringParam3 = componentArray[5];      
        
        // exception for some param is null
        try{
            if (isNumeric(stringParam1) || isNumeric(stringParam2)){
                param1 = Integer.parseInt(stringParam1);
                param2 = Integer.parseInt(stringParam2);
            }

            /// check for triangle param & create triangle point array
            else{
                List<Integer> trianglePointlist = new ArrayList<Integer>();
                makeTrianglePoint(stringParam1,trianglePointlist);
                makeTrianglePoint(stringParam2,trianglePointlist);
                makeTrianglePoint(stringParam3,trianglePointlist);
                Integer[]  convertArr= new Integer[trianglePointlist.size()];                
                convertArr = trianglePointlist.toArray(convertArr);
                this.trianglePointArr = convertArr;              
                
            }
            
        } catch(NumberFormatException e){              
        }
    }    

 
    // make shape
    public void paintComponent(Graphics g){  
        ShapeLib shapemodel = new ShapeLib();        
        shapemodel.makeShape(x, y, shape, color,param1,param2,trianglePointArr,g);  
        
     }

    

    /// check numeric for string
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /// make triangle point from string param
    public void makeTrianglePoint(String param,List<Integer> list){        
        param = param.replace("(", "");
        param = param.replace(")", "");
        String[] params = param.split(",");
        Integer a = Integer.parseInt(params[0]); 
        Integer b = Integer.parseInt(params[1]);
        list.add(a);
        list.add(b);        
        
        
    }
}
