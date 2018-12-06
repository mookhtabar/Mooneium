package mooneiumlite;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dinosaur
 */
public class HomeController implements Initializable {

    @FXML
    private JFXTextField data;
    @FXML
    private JFXButton dataB;
    @FXML
    private JFXButton dataA;
    @FXML
    private JFXTextArea dataD;
    //data now in database
    double AAA;
    private JFXButton exit;
    private JFXButton close;
    @FXML
    private Text url;

    public HomeController() {
        this.AAA = 0.0;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        double DATAcor=0.0;
        
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.


          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
//            System.out.println("id = " + rs.getDouble("id"));
            AAA=rs.getDouble("id");
//            System.out.println(AAA);
          }
        }
        catch(SQLException e)
        {
          String urll = "jdbc:sqlite:temp.db";
          try (Connection conn = DriverManager.getConnection(urll)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }   
            String sql1 = "CREATE TABLE person(id BLOB);";
            Statement stmt = conn.createStatement(); 
            stmt.execute(sql1);       
            String sql = "INSERT INTO person(id) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, 0);
            pstmt.executeUpdate();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            DATAcor = rs.getDouble("id");
          }
 
        } catch (SQLException e1) {
            System.out.println(e.getMessage());
        }
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
        //print to the app the corrent valeur
            String AAAA="";
            AAAA = Double.toString(AAA);
            dataD.setText(AAAA);
    }    

    @FXML
    private void dataaction(ActionEvent event) {
    }

    //remove -------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @FXML
    private void dataBaction(ActionEvent event) {
        
        double DATAcor=0.0;
        double subresulta = 0.0;
        AAA=0.0;
        
        // open database for get the valeur
        
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          
          
          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            DATAcor = rs.getDouble("id");
          }
        }
        
        
        catch(SQLException e)
        {
          
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }

        //end get valeur
        
        //substrat with the num 1 and num 2 
        
            
            
            String n1 = data.getText();
            double num1 = Double.parseDouble(n1);
            double a1 = DATAcor * 100;
            double a2 = num1 * 100;
            double a3 = a1 - a2;
            double a4 = a3 / 100;
            subresulta = (Math.round(a4 * 100.0) / 100.0);
            
//            System.out.println("num1: " + DATAcor);
//            System.out.println("num2: " + num1);
//            System.out.println("resulta: " + subresulta);

           
        //open database for update the valeur
        
        String sql = "UPDATE person SET id = ?  "+ "WHERE id = ?";
        try {
         connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);  // set timeout to 30 sec.
         PreparedStatement pstmt = connection.prepareStatement(sql);
            // set the corresponding param
            pstmt.setDouble(1, subresulta);
            pstmt.setDouble(2, DATAcor);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e){
        }
 
        //open database for display the valeur
            try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.


          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            AAA=rs.getDouble("id");
          }
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          
        
    }}
    
            String AAAA="";
            AAAA = Double.toString(AAA);
            dataD.setText(AAAA);
    }

    //add ----------------------------------------------------------------------
    //--------------------------------------------------------------------------
    @FXML
    private void dataAaction(ActionEvent event) {

        double DATAcor=0.0;
        double adda = 0.0;
        AAA=0.0;
        
        
        // open database for get the valeur
        
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.


          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            DATAcor = rs.getDouble("id");
          }
        }
        
        
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }

        //end get valeur
        
        //substrat with the num 1 and num 2 
        
            
            String n1 = data.getText();
            double num1 = Double.parseDouble(n1);
            double a1 = DATAcor * 100;
            double a2 = num1 * 100;
            double a3 = a1 + a2;
            double a4 = a3 / 100;
            adda = (Math.round(a4 * 100.0) / 100.0);
            
//            System.out.println("num1: " + DATAcor);
//            System.out.println("num2: " + num1);
//            System.out.println("resulta: " + adda);
           
        //open database for update the valeur
        
        String sql = "UPDATE person SET id = ?  "+ "WHERE id = ?";
        try {
         connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);  // set timeout to 30 sec.
         PreparedStatement pstmt = connection.prepareStatement(sql);
            // set the corresponding param
            pstmt.setDouble(1, adda);
            pstmt.setDouble(2, DATAcor);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e){
        }
 
        //open database for display the valeur
            try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:temp.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.


          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
//            System.out.println("id = " + rs.getDouble("id"));
            AAA=rs.getDouble("id");
//            System.out.println(AAA);
          }
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          
        
    }}
    
            String AAAA="";
            AAAA = Double.toString(AAA);
            dataD.setText(AAAA);


    }



    private void closeaction(ActionEvent event) {
    Stage stage = (Stage) close.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void urlaction(MouseEvent event) {
    }


    
    
}
