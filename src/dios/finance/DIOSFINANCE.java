/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author meraki
 */
public class DIOSFINANCE extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();
        merakiBusinessDBClass.createDataBase();
        Parent root = FXMLLoader.load(
                getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        
        stage.setTitle("DIOS FINANCE");
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
