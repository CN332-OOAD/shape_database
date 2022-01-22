import  java.awt.*;

public class ColorLib {
    // color libraly   
    private Color Colorfill;

    public Color ColorFill(String color){

        if ( color.equals("red") ) { Colorfill = new Color(255, 0, 0); }
        else if (color.equals("green")){Colorfill = new Color(0,255,0);}
        else if (color.equals("blue")){Colorfill = new Color(0,0,255);}

        return Colorfill;
    }
    
}


