import Controller.WelcomeWindow;
import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

    WelcomeWindow welcomeWindow = new WelcomeWindow();

    @Override
    public void start(Stage stage) throws Exception{

       welcomeWindow.start();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
