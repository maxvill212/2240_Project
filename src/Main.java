//<editor-fold desc="About Project"
/******************************************************************************************************
*                                                                                                     *
*       ***************ABOUT***************                                                           *
*       This is the semester long project for COIS 2240H 2019 at Trent University                     *
*       Its an application that calculates your carbon footprint based on 29 questions                *
*       Users create an account to complete the questionnaire                                         *
*       Once completed, their results are compared to all other entries in the database               *
*       Through their account they can view their previous entries                                    *
*                                                                                                     *
*       This is the main method that simply starts the application                                    *
*                                                                                                     *
*                                                                                                     *
*       **********VARIABLES MAIN***********                                                           *
*       Stage                                                                                         *
*           welcomeStage     -> The stage for the welcome window                                      *
*       Root                                                                                          *
*           welcomeRoot      -> The root of the scene, a border pane                                  *
*       Scene                                                                                         *
*           welcomeStage     -> The scene of the project (what you can see)                           *
*                                                                                                     *
*                                                                                                     *
*       Each page has its own Stage, Root and Scene, so I won't mention them again                    *
*       Many variables repeat themselves, when this is the case they will be named but not explained  *
*                                                                                                     *
******************************************************************************************************/
//</editor-fold>




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//    The start method for javaFX
    @Override
    public void start(Stage welcomeStage) throws Exception{

//        This create the welcome screen window
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("WelcomeWindow/WelcomeWindow.fxml"));
        welcomeStage.setTitle("Welcome");
        welcomeStage.setScene(new Scene(welcomeRoot));
        welcomeStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
