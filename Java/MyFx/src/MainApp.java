import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello JavaFx with JDK 21!");
        Scene scene = new Scene(label,
                300,
                200);

        primaryStage.setTitle("javaFx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
