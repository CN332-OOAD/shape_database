import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Database{    
    public static void main(String[] args) {
        try{

            // database section            
            String url = "jdbc:mysql://localhost/walk";           
            String user = "root";
            String password = "";     
            String sql = "SELECT * FROM `walk`";     
                        
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement  statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            
            //frame section
            JFrame f = new JFrame();
            int w = 1920;
            int h = 1080;
            
           // drawing from database
            while (resultset.next()){
                String shape = resultset.getString("shape");
                String x = resultset.getString("x");
                String y = resultset.getString("y");
                
                Drawing dc = new Drawing(shape,x,y);           
                f.setSize(w,h);
                f.add(dc);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
   
}