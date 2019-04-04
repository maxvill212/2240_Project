//import Classes.UserSession;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage welcomeStage) throws Exception{

        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("WelcomeWindow/WelcomeWindow.fxml"));
        welcomeStage.setTitle("Welcome");
        welcomeStage.setScene(new Scene(welcomeRoot));
        welcomeStage.getIcons();
        welcomeStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
