import Controller.WelcomeWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    WelcomeWindow welcomeWindow = new WelcomeWindow();

    @Override
    public void start(Stage primaryStage) throws Exception{

//        welcomeWindow.start();

        Parent root = FXMLLoader.load(getClass().getResource("/FXML/WelcomeWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
