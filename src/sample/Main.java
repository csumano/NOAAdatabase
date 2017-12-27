package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import org.json.*;

public class Main extends Application {


    public static void main(String[] args) throws IOException, JSONException {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("NOAA Weather database ");
        primaryStage.setScene(new Scene(root, 386, 541));
        primaryStage.show();
    }
}
