import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Canvas{    
    public static void main(String[] args) {
        try{

            // database section            
            String url = "jdbc:mysql://localhost/shape";           
            String user = "root";
            String password = "";     
            String sql = "SELECT * FROM `shape`";     
                        
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement  statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            
            //frame section
            JFrame f = new JFrame();
            int w = 670;
            int h = 480;
            
           // drawing section
            while (resultset.next()){
                String location = resultset.getString("location");
                String shape = resultset.getString("shape");  
                String color = resultset.getString("color");
                String param1 = resultset.getString("param1");                
                String param2 = resultset.getString("param2");
                String param3 = resultset.getString("param3");  
               
                  
                String[] componentArray = new String[]{location,shape,color,param1,param2,param3}; 
                
                DrawingShape drawingshape = new DrawingShape(componentArray);           
                f.setSize(w,h);
                f.add(drawingshape);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
   
}