package asatunes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends Application {

      protected IntroductionPane intro;
      protected static ContentPane contentPane;
      protected static SideBarPane sideBar;
      protected static AudioPane audioPane;
      protected static ExitPane exitPane;
      protected static Pane pane;
      protected static AlbumIcons albumIcons;

      @Override
      public void start(Stage primaryStage) {
            intro = new IntroductionPane();
            contentPane = new ContentPane();
            sideBar = new SideBarPane();
            audioPane = new AudioPane();
            albumIcons = new AlbumIcons();
            exitPane = new ExitPane();

            pane = new Pane();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("");
            primaryStage.show();

            pane.getChildren().addAll(contentPane, sideBar, audioPane, albumIcons, exitPane, intro);
      }

      public static void disable() {
            sideBar.setDisable(true);
            sideBar.setOpacity(0.5);

            audioPane.setDisable(true);
            audioPane.setOpacity(0.5);

            contentPane.setDisable(true);
            contentPane.setOpacity(0.5);
      }

      public static void enable() {
            sideBar.setDisable(false);
            sideBar.setOpacity(1);

            audioPane.setDisable(false);
            audioPane.setOpacity(1);

            contentPane.setDisable(false);
            contentPane.setOpacity(1);
      }

      public static void main(String[] args) {
            launch(args);
      }
}
