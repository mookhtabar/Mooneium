/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.mooneiumlite
 */
package mooneiumlite;


import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author Samuelson
 */
public class mooneiumlite extends Application {
    @Override
    public void start(Stage stage) throws Exception {
          
       
        System.out.println("Mac: " + GetNetworkAddress.GetAddress("mac"));
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("logo.png"));        
        stage.setTitle("MooneiumLite");
        stage.setResizable(false);
        
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
